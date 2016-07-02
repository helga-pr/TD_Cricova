package org.itstep.prokopchik.cricova.database.dao.article;

import org.itstep.prokopchik.cricova.Article;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;

@Entity
@Table(name = "articles", schema = "", catalog = "cricovadb")
public class ArticlesEntity extends DAOArticle implements Serializable {
    private int idArticle;
    private String nameArticle;
    private String contentArticle;
    private byte[] imageArticle;

    @Id
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
        return null;
    }

    @Override
    public Article createArticle(Article article) {
        return null;
    }

    @Override
    public Article getArticle(String name) {
        return null;
    }

    @Override
    public Article getArticleById(Integer id) {
        return null;
    }
}
