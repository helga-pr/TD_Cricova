package org.itstep.prokopchik.cricova.database.dao.article;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.itstep.prokopchik.cricova.Article;
import org.itstep.prokopchik.cricova.database.HibernateSessionFactory;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "articles", schema = "", catalog = "cricovadb")
public class ArticlesEntity implements Serializable, DAOArticle {
    private int idArticle;
    private String nameArticle;
    private String contentArticle;
    private byte[] imageArticle;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //generated DataBase auto_increment when insert value
    @Column(name = "id_article", nullable = false, insertable = true, updatable = true)
    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    @Basic
    @Column(name = "name_article", nullable = false, insertable = true, updatable = true, length = 45)
    public String getNameArticle() {
        return nameArticle;
    }

    public void setNameArticle(String nameArticle) {
        this.nameArticle = nameArticle;
    }

    @Basic
    @Column(name = "content_article", nullable = false, insertable = true, updatable = true, length = 45)
    public String getContentArticle() {
        return contentArticle;
    }

    public void setContentArticle(String contentArticle) {
        this.contentArticle = contentArticle;
    }

    @Basic
    @Column(name = "image_article", nullable = true, insertable = true, updatable = true)
    public byte[] getImageArticle() {
        return imageArticle;
    }

    public void setImageArticle(byte[] imageArticle) {
        this.imageArticle = imageArticle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArticlesEntity that = (ArticlesEntity) o;

        if (idArticle != that.idArticle) return false;
        if (contentArticle != null ? !contentArticle.equals(that.contentArticle) : that.contentArticle != null)
            return false;
        if (!Arrays.equals(imageArticle, that.imageArticle)) return false;
        if (nameArticle != null ? !nameArticle.equals(that.nameArticle) : that.nameArticle != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idArticle;
        result = 31 * result + (nameArticle != null ? nameArticle.hashCode() : 0);
        result = 31 * result + (contentArticle != null ? contentArticle.hashCode() : 0);
        result = 31 * result + (imageArticle != null ? Arrays.hashCode(imageArticle) : 0);
        return result;
    }

    @Override
    public Article createArticle(String name, String content, Object image) {
        Article newArticle = null;

        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        try {
            Transaction transaction = session.beginTransaction();

            ArticlesEntity articlesEntity = new ArticlesEntity();
            articlesEntity.setNameArticle(name);
            articlesEntity.setContentArticle(content);
            if ((byte[]) image != null)
                articlesEntity.setImageArticle((byte[]) image);

            Integer newId = (Integer) session.save(articlesEntity);  // возвращает сгенерированный идентификатор id

            if (newId > 0) {
                newArticle = new Article();
                newArticle.setId(newId);
                newArticle.setName(name);
                newArticle.setContent(content);
                newArticle.setImage((byte[]) image);
            }

            transaction.commit();

            // TODO ддя отладки
            if (newArticle != null) {
                System.out.println(newArticle.getName() + " добавлен в БД. ");

            } else {
                System.out.println("Ошибка. Новая статья не сохранена в БД!");
            }
        } catch (HibernateException e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                throw e;// перебрасывание исключения на более высокий уровень
            }
        } finally {
            session.close(); // гарантированное закрытие сеанса
        }

        return newArticle;
    }

    @Override
    public Article createArticle(Article article) {

        return new ArticlesEntity().createArticle(article.getName(),
                article.getContent(),
                article.getImage());
    }

    @Override
    public List<Article> findAllArticles() {

        List<Article> allArticles = null;
        List<ArticlesEntity> articlesEntities = null;

        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        try {
            Transaction transaction = session.beginTransaction();

            articlesEntities = session.createQuery("from ArticlesEntity a").list();

            if (!articlesEntities.isEmpty()) {
                Article article = new Article();

                for (ArticlesEntity articlesEntity : articlesEntities) {
                    article = createArticleFromArticlesEntity(articlesEntity);
                    allArticles.add(article);
                }
            }
            transaction.commit();

            // TODO для отладки (удалить или закомментировать)

            if (!allArticles.isEmpty()) {
                for (Article article : allArticles) {
                    System.out.println(article);
                }
            } else {
                System.out.println("No data from table admins");
            }
        } catch (HibernateException e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                throw e;// перебрасывание исключения на более высокий уровень
            }
        } finally {
            session.close(); // гарантированное закрытие сеанса
        }
        return allArticles;
    }

    @Override
    public Article findArticle(String name) {
        Article articleByName = null;

        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        try {
            Transaction transaction = session.beginTransaction();

            ArticlesEntity articlesEntity = (ArticlesEntity) session.createQuery
                    ("from ArticlesEntity AS a where nameArticle = :articleName")
                    .setParameter("articleName", name)
                    .uniqueResult();

            if (articlesEntity != null) {
                articleByName = createArticleFromArticlesEntity(articlesEntity);
            }

            transaction.commit();

        /* ддя отладки */
            if (articleByName != null) {
                System.out.println(new SimpleDateFormat("dd.mm.yyyy hh:mm:ss ").format(new Date()) +
                        getClass() +
                        ": " +
                        articleByName.getName() + " найден в БД.");

            } else {
                System.out.println(new SimpleDateFormat("dd.mm.yyyy hh:mm:ss ").format(new Date()) +
                        getClass() +
                        ": \nNo data with this criterias in table articles");
            }
        } catch (HibernateException e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                throw e;// перебрасывание исключения на более высокий уровень
            }
        } finally {
            session.close(); // гарантированное закрытие сеанса
        }


        return articleByName;
    }

    @Override
    public Article findArticleById(Integer id) {
        Article articleById = null;

        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        try {
            Transaction transaction = session.beginTransaction();

            articleById = createArticleFromArticlesEntity(
                    (ArticlesEntity) session.createQuery("FROM ArticlesEntity a WHERE a.idArticle = :id")
                            .setParameter("id", id)
                            .uniqueResult());

            transaction.commit();

            // TODO ддя отладки
            if (articleById != null) {
                System.out.println(new SimpleDateFormat("\ndd.MM.yyyy HH:mm:ss ").format(new Date()) +
                        getClass() + ": \n" +
                        articleById.getName() + " найден в БД.");

            } else {
                System.out.println(new SimpleDateFormat("\ndd.MM.yyyy HH:mm:ss ").format(new Date()) +
                        getClass() + ": \n" +
                        "No data with this criterias");
            }
        } catch (HibernateException e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                throw e;// перебрасывание исключения на более высокий уровень
            }
        } finally {
            session.close(); // гарантированное закрытие сеанса
        }

        return articleById;
    }

    private Article createArticleFromArticlesEntity(ArticlesEntity articlesEntity) {
        Article article = null;
        if (articlesEntity != null) {
            article = new Article();
            article.setId(articlesEntity.getIdArticle());
            article.setName(articlesEntity.getNameArticle());
            article.setContent(articlesEntity.getContentArticle());
            article.setImage(articlesEntity.getImageArticle());
        }
        return article;
    }

}
