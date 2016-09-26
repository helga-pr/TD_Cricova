package org.itstep.prokopchik.cricova.database.dao.wine;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.itstep.prokopchik.cricova.*;
import org.itstep.prokopchik.cricova.database.HibernateSessionFactory;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "wines", schema = "", catalog = "cricovadb")
public class WinesEntity implements Serializable, DAOWine {
    private int idWine;
    private String nameWine;
    private int priceWine;
    private int ndsrateWine;
    private byte[] imageWine;
    private String annotationWine;
    private String wineType;
    private String wineColor;
    private String wineAge;
    private String wineSugarContent;
    private String wineSpiritContent;
    private String wineCollection;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //generated DataBase auto_increment when insert value
    @Column(name = "id_wine", nullable = false, insertable = true, updatable = true)
    public int getIdWine() {
        return idWine;
    }

    public void setIdWine(int idWine) {
        this.idWine = idWine;
    }

    @Basic
    @Column(name = "name_wine", nullable = false, insertable = true, updatable = true, length = 45)
    public String getNameWine() {
        return nameWine;
    }

    public void setNameWine(String nameWine) {
        this.nameWine = nameWine;
    }

    @Basic
    @Column(name = "price_wine", nullable = false, insertable = true, updatable = true)
    public int getPriceWine() {
        return priceWine;
    }

    public void setPriceWine(int priceWine) {
        this.priceWine = priceWine;
    }

    @Basic
    @Column(name = "ndsrate_wine", nullable = false, insertable = true, updatable = true)
    public int getNdsrateWine() {
        return ndsrateWine;
    }

    public void setNdsrateWine(int ndsrateWine) {
        this.ndsrateWine = ndsrateWine;
    }

    @Basic
    @Column(name = "image_wine", nullable = true, insertable = true, updatable = true)
    public byte[] getImageWine() {
        return imageWine;
    }

    public void setImageWine(byte[] imageWine) {
        this.imageWine = imageWine;
    }

    @Basic
    @Column(name = "annotation_wine", nullable = true, insertable = true, updatable = true, length = 254)
    public String getAnnotationWine() {
        return annotationWine;
    }

    public void setAnnotationWine(String annotationWine) {
        this.annotationWine = annotationWine;
    }

    @Basic
    @Column(name = "wine_type", nullable = false, insertable = true, updatable = true, length = 14)
    public String getWineType() {
        return wineType;
    }

    public void setWineType(String wineType) {
        this.wineType = wineType;
    }

    @Basic
    @Column(name = "wine_color", nullable = false, insertable = true, updatable = true, length = 5)
    public String getWineColor() {
        return wineColor;
    }

    public void setWineColor(String wineColor) {
        this.wineColor = wineColor;
    }

    @Basic
    @Column(name = "wine_age", nullable = false, insertable = true, updatable = true, length = 15)
    public String getWineAge() {
        return wineAge;
    }

    public void setWineAge(String wineAge) {
        this.wineAge = wineAge;
    }

    @Basic
    @Column(name = "wine_sugar_content", nullable = false, insertable = true, updatable = true, length = 10)
    public String getWineSugarContent() {
        return wineSugarContent;
    }

    public void setWineSugarContent(String wineSugarContent) {
        this.wineSugarContent = wineSugarContent;
    }

    @Basic
    @Column(name = "wine_spirit_content", nullable = false, insertable = true, updatable = true, length = 8)
    public String getWineSpiritContent() {
        return wineSpiritContent;
    }

    public void setWineSpiritContent(String wineSpiritContent) {
        this.wineSpiritContent = wineSpiritContent;
    }

    @Basic
    @Column(name = "wine_collection", nullable = false, insertable = true, updatable = true, length = 15)
    public String getWineCollection() {
        return wineCollection;
    }

    public void setWineCollection(String wineCollection) {
        this.wineCollection = wineCollection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WinesEntity that = (WinesEntity) o;

        if (idWine != that.idWine) return false;
        if (ndsrateWine != that.ndsrateWine) return false;
        if (priceWine != that.priceWine) return false;
        if (annotationWine != null ? !annotationWine.equals(that.annotationWine) : that.annotationWine != null)
            return false;
        if (!Arrays.equals(imageWine, that.imageWine)) return false;
        if (nameWine != null ? !nameWine.equals(that.nameWine) : that.nameWine != null) return false;
        if (wineAge != null ? !wineAge.equals(that.wineAge) : that.wineAge != null) return false;
        if (wineCollection != null ? !wineCollection.equals(that.wineCollection) : that.wineCollection != null)
            return false;
        if (wineColor != null ? !wineColor.equals(that.wineColor) : that.wineColor != null) return false;
        if (wineSpiritContent != null ? !wineSpiritContent.equals(that.wineSpiritContent) : that.wineSpiritContent != null)
            return false;
        if (wineSugarContent != null ? !wineSugarContent.equals(that.wineSugarContent) : that.wineSugarContent != null)
            return false;
        if (wineType != null ? !wineType.equals(that.wineType) : that.wineType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idWine;
        result = 31 * result + (nameWine != null ? nameWine.hashCode() : 0);
        result = 31 * result + priceWine;
        result = 31 * result + ndsrateWine;
        result = 31 * result + (imageWine != null ? Arrays.hashCode(imageWine) : 0);
        result = 31 * result + (annotationWine != null ? annotationWine.hashCode() : 0);
        result = 31 * result + (wineType != null ? wineType.hashCode() : 0);
        result = 31 * result + (wineColor != null ? wineColor.hashCode() : 0);
        result = 31 * result + (wineAge != null ? wineAge.hashCode() : 0);
        result = 31 * result + (wineSugarContent != null ? wineSugarContent.hashCode() : 0);
        result = 31 * result + (wineSpiritContent != null ? wineSpiritContent.hashCode() : 0);
        result = 31 * result + (wineCollection != null ? wineCollection.hashCode() : 0);
        return result;
    }

    @Override
    public Wine createWine(String name,
                           Integer price,
                           Integer ndsRate,
                           Object image,
                           String annotation,
                           WineTypeEnum wineType,
                           WineColorEnum wineColor,
                           WineAgeEnum wineAge,
                           WineSugarContentEnum wineSugarContent,
                           WineSpiritContentEnum wineSpiritContent,
                           WineCollectionEnum wineCollection) {

        Wine newWine = null;

        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        try {
            Transaction transaction = session.beginTransaction();

            WinesEntity winesEntity = new WinesEntity();
            winesEntity.setNameWine(name);
            winesEntity.setPriceWine(price);
            winesEntity.setNdsrateWine(ndsRate);
            if ((byte[]) image != null)
                winesEntity.setImageWine((byte[]) image);
            winesEntity.setAnnotationWine(annotation);
            winesEntity.setWineType(wineType.getValue());
            winesEntity.setWineColor(wineColor.getValue());
            winesEntity.setWineAge(wineAge.getValue());
            winesEntity.setWineSugarContent(wineSugarContent.getValue());
            winesEntity.setWineSpiritContent(WineSpiritContentEnum.getConstant(wineSpiritContent.getValue()).toLowerCase());
            winesEntity.setWineCollection(wineCollection.getValue());

            Integer newId = (Integer) session.save(winesEntity);  // возвращает сгенерированный идентификатор id

            if (newId > 0) {
                newWine = createWineFromWinesEntity(winesEntity);
            }

            transaction.commit();

            // TODO ддя отладки
            if (newWine != null) {
                System.out.println(newWine.getName() + " добавлен в БД. ");

            } else {
                System.out.println("Ошибка. Новый пункт прайса не сохранен в БД!");
            }
        } catch (HibernateException e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                throw e;// перебрасывание исключения на более высокий уровень
            }
        } finally {
            session.close(); // гарантированное закрытие сеанса
        }

        return newWine;
    }

    private Wine createWineFromWinesEntity(WinesEntity winesEntity) {
        Wine newWine = null;

        if (winesEntity != null) {
            newWine = new Wine();
            newWine.setId(winesEntity.getIdWine());
            newWine.setName(winesEntity.getNameWine());
            newWine.setPrice(winesEntity.getPriceWine());
            newWine.setNdsRate(winesEntity.getNdsrateWine());
            newWine.setImage(winesEntity.getImageWine());
            newWine.setAnnotation(winesEntity.getAnnotationWine());
            newWine.setWineType(WineTypeEnum.valueOf(winesEntity.getWineType()));
            newWine.setWineColor(WineColorEnum.valueOf(winesEntity.getWineColor()));
            newWine.setWineAge(WineAgeEnum.valueOf(winesEntity.getWineAge()));
            newWine.setWineSugarContent(WineSugarContentEnum.valueOf(winesEntity.getWineSugarContent()));
            newWine.setWineSpiritContent(WineSpiritContentEnum.valueOf(winesEntity.getWineSpiritContent().toUpperCase()));
            newWine.setWineCollection(WineCollectionEnum.valueOf(winesEntity.getWineCollection()));
        }
        return newWine;
    }

    @Override
    public Wine createWine(Wine wine) {

        return new WinesEntity().createWine(
                wine.getName(),
                wine.getPrice(),
                wine.getNdsRate(),
                wine.getImage(),
                wine.getAnnotation(),
                wine.getWineType(),
                wine.getWineColor(),
                wine.getWineAge(),
                wine.getWineSugarContent(),
                wine.getWineSpiritContent(),
                wine.getWineCollection());
    }

    @Override
    public List<Wine> findAllWines() {
        List<Wine> allWines = new ArrayList<Wine>();
        List<WinesEntity> allWinesEntities = new ArrayList<WinesEntity>();

        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        try {
            Transaction transaction = session.beginTransaction();

            allWinesEntities = session.createQuery("from WinesEntity w").list();

            if (!allWinesEntities.isEmpty()) {
                Wine wine;

                for (WinesEntity winesEntity : allWinesEntities) {
                    wine = createWineFromWinesEntity(winesEntity);
                    allWines.add(wine);
                }
            }
            transaction.commit();

            // TODO для отладки (удалить или закомментировать)
            if (!allWines.isEmpty()) {
                System.out.println(new SimpleDateFormat("\ndd.MM.yyyy HH:mm:ss ").format(new Date()) +
                        getClass() + " =>");
                for (Wine wine : allWines) {
                    System.out.println(wine);
                }
            } else {
                System.out.println("No data from table wines!");
            }
        } catch (HibernateException e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                throw e;// перебрасывание исключения на более высокий уровень
            }
        } finally {
            session.close(); // гарантированное закрытие сеанса
        }

        return allWines;
    }

    @Override
    public List<Wine> findWineByName(String name) {
        List<Wine> winesByName = new ArrayList<Wine>();
        List<WinesEntity> winesEntityByName;

        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        try {
            Transaction transaction = session.beginTransaction();

            winesEntityByName = session.createQuery("from WinesEntity w where w.nameWine = :nameWine")
                    .setParameter("nameWine", name)
                    .list();

            if (!winesEntityByName.isEmpty()) {
                Wine wine;

                for (WinesEntity winesEntity : winesEntityByName) {
                    wine = createWineFromWinesEntity(winesEntity);
                    winesByName.add(wine);
                }
            }
            transaction.commit();

            // TODO для отладки (удалить или закомментировать)
            if (!winesByName.isEmpty()) {
                System.out.println(new SimpleDateFormat("\ndd.MM.yyyy HH:mm:ss ").format(new Date()) +
                        getClass() + " =>");
                for (Wine wine : winesByName) {
                    System.out.println(wine);
                }
            } else {
                System.out.println("No data from table wines!");
            }
        } catch (HibernateException e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                throw e;// перебрасывание исключения на более высокий уровень
            }
        } finally {
            session.close(); // гарантированное закрытие сеанса
        }

        return winesByName;
    }

    @Override
    public List<Wine> findWineByWineType(String wineType) {


        List<Wine> winesByType = new ArrayList<Wine>();
        List<WinesEntity> winesEntities;

        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        try {
            Transaction transaction = session.beginTransaction();

            winesEntities = session.createQuery("from WinesEntity w where w.wineType = :wineType")
                    .setParameter("wineType", wineType.toLowerCase())
                    .list();

            if (!winesEntities.isEmpty()) {
                Wine wine;

                for (WinesEntity winesEntity : winesEntities) {
                    wine = createWineFromWinesEntity(winesEntity);
                    winesByType.add(wine);
                }
            }
            transaction.commit();

            // TODO для отладки (удалить или закомментировать)
            if (!winesByType.isEmpty()) {
                System.out.println(new SimpleDateFormat("\ndd.MM.yyyy HH:mm:ss ").format(new Date()) +
                        getClass() + " =>");
                for (Wine wine : winesByType) {
                    System.out.println(wine);
                }
            } else {
                System.out.println("No data with this wineType from table wines!");
            }
        } catch (HibernateException e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                throw e;// перебрасывание исключения на более высокий уровень
            }
        } finally {
            session.close(); // гарантированное закрытие сеанса
        }

        return winesByType;
    }

    @Override
    public List<Wine> findWineByWineColor(String wineColor) {
        List<Wine> wineByColor = new ArrayList<Wine>();
        List<WinesEntity> winesEntities;

        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        try {
            Transaction transaction = session.beginTransaction();

            winesEntities = session.createQuery("from WinesEntity w where w.wineColor = :wineColor")
                    .setParameter("wineColor", wineColor.toLowerCase())
                    .list();

            if (!winesEntities.isEmpty()) {
                Wine wine;

                for (WinesEntity winesEntity : winesEntities) {
                    wine = createWineFromWinesEntity(winesEntity);
                    wineByColor.add(wine);
                }
            }
            transaction.commit();

            // TODO для отладки (удалить или закомментировать)
            if (!wineByColor.isEmpty()) {
                System.out.println(new SimpleDateFormat("\ndd.MM.yyyy HH:mm:ss ").format(new Date()) +
                        getClass() + " =>");
                for (Wine wine : wineByColor) {
                    System.out.println(wine);
                }
            } else {
                System.out.println("No data with this wineColor from table wines!");
            }
        } catch (HibernateException e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                throw e;// перебрасывание исключения на более высокий уровень
            }
        } finally {
            session.close(); // гарантированное закрытие сеанса
        }

        return wineByColor;
    }

    @Override
    public List<Wine> findWineByWineAge(String wineAge) {
        List<Wine> winesByWineAge = new ArrayList<Wine>();
        List<WinesEntity> winesEntities;

        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        try {
            Transaction transaction = session.beginTransaction();

            winesEntities = session.createQuery("from WinesEntity w where w.wineAge = :wineAge")
                    .setParameter("wineAge", wineAge.toLowerCase())
                    .list();

            if (!winesEntities.isEmpty()) {
                Wine wine;

                for (WinesEntity winesEntity : winesEntities) {
                    wine = createWineFromWinesEntity(winesEntity);
                    winesByWineAge.add(wine);
                }
            }
            transaction.commit();

            // TODO для отладки (удалить или закомментировать)
            if (!winesByWineAge.isEmpty()) {
                System.out.println(new SimpleDateFormat("\ndd.MM.yyyy HH:mm:ss ").format(new Date()) +
                        getClass() + " =>");
                for (Wine wine : winesByWineAge) {
                    System.out.println(wine);
                }
            } else {
                System.out.println("No data with this wineAge from table wines!");
            }
        } catch (HibernateException e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                throw e;// перебрасывание исключения на более высокий уровень
            }
        } finally {
            session.close(); // гарантированное закрытие сеанса
        }

        return winesByWineAge;
    }

    @Override
    public List<Wine> findWineByWineSugarContent(String wineSugarContent) {
        List<Wine> winesBySugarContent = new ArrayList<Wine>();
        List<WinesEntity> winesEntities;

        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        try {
            Transaction transaction = session.beginTransaction();

            winesEntities = session.createQuery("from WinesEntity w where w.wineSugarContent = :sugarContent")
                    .setParameter("sugarContent", wineSugarContent.toLowerCase())
                    .list();

            if (!winesEntities.isEmpty()) {
                Wine wine;

                for (WinesEntity winesEntity : winesEntities) {
                    wine = createWineFromWinesEntity(winesEntity);
                    winesBySugarContent.add(wine);
                }
            }
            transaction.commit();

            // TODO для отладки (удалить или закомментировать)
            if (!winesBySugarContent.isEmpty()) {
                System.out.println(new SimpleDateFormat("\ndd.MM.yyyy HH:mm:ss ").format(new Date()) +
                        getClass() + " =>");
                for (Wine wine : winesBySugarContent) {
                    System.out.println(wine);
                }
            } else {
                System.out.println("No data with this wineSugarContent from table wines!");
            }
        } catch (HibernateException e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                throw e;// перебрасывание исключения на более высокий уровень
            }
        } finally {
            session.close(); // гарантированное закрытие сеанса
        }

        return winesBySugarContent;
    }

    @Override
    public List<Wine> findWineByWineSpiritContent(String wineSpiritContent) {
        List<Wine> wineBySpiritContent = new ArrayList<Wine>();
        List<WinesEntity> winesEntities;

        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        try {
            Transaction transaction = session.beginTransaction();

            winesEntities = session.createQuery("from WinesEntity w where w.wineSpiritContent = :spiritContent")
                    .setParameter("spiritContent", wineSpiritContent.toLowerCase())
                    .list();

            if (!winesEntities.isEmpty()) {
                Wine wine;

                for (WinesEntity winesEntity : winesEntities) {
                    wine = createWineFromWinesEntity(winesEntity);
                    wineBySpiritContent.add(wine);
                }
            }
            transaction.commit();

            // TODO для отладки (удалить или закомментировать)
            if (!wineBySpiritContent.isEmpty()) {
                System.out.println(new SimpleDateFormat("\ndd.MM.yyyy HH:mm:ss ").format(new Date()) +
                        getClass() + " =>");
                for (Wine wine : wineBySpiritContent) {
                    System.out.println(wine);
                }
            } else {
                System.out.println("No data with this wineSpiritContent from table wines!");
            }
        } catch (HibernateException e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                throw e;// перебрасывание исключения на более высокий уровень
            }
        } finally {
            session.close(); // гарантированное закрытие сеанса
        }

        return wineBySpiritContent;
    }

    @Override
    public List<Wine> findWineByWineCollection(String wineCollection) {
        List<Wine> winesByCollection = new ArrayList<Wine>();
        List<WinesEntity> winesEntities;

        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        try {
            Transaction transaction = session.beginTransaction();

            winesEntities = session.createQuery("from WinesEntity w where w.wineCollection = :collection")
                    .setParameter("collection", wineCollection.toLowerCase())
                    .list();

            if (!winesEntities.isEmpty()) {
                Wine wine;

                for (WinesEntity winesEntity : winesEntities) {
                    wine = createWineFromWinesEntity(winesEntity);
                    winesByCollection.add(wine);
                }
            }
            transaction.commit();

            // TODO для отладки (удалить или закомментировать)
            if (!winesByCollection.isEmpty()) {
                System.out.println(new SimpleDateFormat("\ndd.MM.yyyy HH:mm:ss ").format(new Date()) +
                        getClass() + " =>");
                for (Wine wine : winesByCollection) {
                    System.out.println(wine);
                }
            } else {
                System.out.println("No data with this Collection from table wines!");
            }
        } catch (HibernateException e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                throw e;// перебрасывание исключения на более высокий уровень
            }
        } finally {
            session.close(); // гарантированное закрытие сеанса
        }

        return winesByCollection;
    }

    @Override
    public Wine findWineById(Integer id) {
        Wine wineById = null;

        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        try {
            Transaction transaction = session.beginTransaction();

            wineById = createWineFromWinesEntity(
                    (WinesEntity) session.createQuery("FROM WinesEntity w WHERE w.idWine = :id")
                            .setParameter("id", id)
                            .uniqueResult());

            transaction.commit();

            // TODO ддя отладки
            if (wineById != null) {
                System.out.println(new SimpleDateFormat("\ndd.MM.yyyy HH:mm:ss ").format(new Date()) +
                        getClass() + ": \n" +
                        wineById.getName() + " найден в БД.");

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

        return wineById;
    }

    @Override
    public Integer deleteWineById(Integer id) {

        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        Integer result = 0;

        try {
            Transaction transaction = session.beginTransaction();

            result = session.createQuery("delete WinesEntity w where w.id = :param")
                    .setInteger("param", id)
                    .executeUpdate();

            transaction.commit();

            // TODO ддя отладки
            if (result > 0) {
                System.out.println(new SimpleDateFormat("\ndd.MM.yyyy HH:mm:ss ").format(new Date()) +
                        getClass() + ": \n" +
                        "Товар с id = " + id + "успешно удален из БД!");

            } else {
                System.out.println(new SimpleDateFormat("\ndd.MM.yyyy HH:mm:ss ").format(new Date()) +
                        getClass() + ": \n" +
                        "Товар с id = " + id + "не найден в БД!");
            }
        } catch (HibernateException e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                throw e;// перебрасывание исключения на более высокий уровень
            }
        } finally {
            session.close(); // гарантированное закрытие сеанса
        }
        return result;
    }

    @Override
    public Integer updateWine(Wine newWine) {

        Integer updateId = -1;
        Wine existWine = new WinesEntity().findWineById(newWine.getId());

        if (newWine.equals(existWine)) {
            return 0; //без изменений
        }

        if (existWine == null) {
            return -1; //объект не найден в БД
        }

        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        try {
            Transaction transaction = session.beginTransaction();

            WinesEntity existWinesEntity = (WinesEntity) session.get(WinesEntity.class, newWine.getId());
            if (!existWinesEntity.getNameWine().equals(newWine.getName())) {
                existWinesEntity.setNameWine(newWine.getName());
            }

            if (!(Integer.valueOf(existWinesEntity.getPriceWine()) == (newWine.getPrice()))) {
                existWinesEntity.setPriceWine(newWine.getPrice());
            }

            if (!(Integer.valueOf(existWinesEntity.getNdsrateWine()) == (newWine.getNdsRate()))) {
                existWinesEntity.setNdsrateWine(newWine.getNdsRate());
            }

            if ((byte[]) (byte[]) newWine.getImage() != null && !(existWinesEntity.getImageWine().equals(newWine.getImage()))) {
                existWinesEntity.setImageWine((byte[]) newWine.getImage());
            }

            if (!existWinesEntity.getWineType().equals(newWine.getWineType().getValue())) {
                existWinesEntity.setWineType(newWine.getWineType().getValue());
            }

            if (!existWinesEntity.getWineAge().equals(newWine.getWineAge().getValue())) {
                existWinesEntity.setWineAge(newWine.getWineAge().getValue());
            }

            if (!existWinesEntity.getWineColor().equals(newWine.getWineColor().getValue())) {
                existWinesEntity.setWineColor(newWine.getWineColor().getValue());
            }

            if (!existWinesEntity.getWineSugarContent().equals(newWine.getWineSugarContent().getValue())) {
                existWinesEntity.setWineSugarContent(newWine.getWineSugarContent().getValue());
            }

            if (!existWinesEntity.getWineSpiritContent().equals(WineSpiritContentEnum.getConstant(newWine.getWineSpiritContent().getValue()))) {
                existWinesEntity.setWineSpiritContent(WineSpiritContentEnum.getConstant(newWine.getWineSpiritContent().getValue()));
            }

            if (!existWinesEntity.getWineCollection().equals(newWine.getWineCollection().getValue())) {
                existWinesEntity.setWineCollection(newWine.getWineCollection().getValue());
            }

            if (!existWinesEntity.getAnnotationWine().equals(newWine.getAnnotation())) {
                existWinesEntity.setAnnotationWine(newWine.getAnnotation());
            }

            updateId = (Integer) session.save(existWinesEntity);

            transaction.commit();

            //TODO ддя отладки
            if (existWine != null) {
                System.out.println(new SimpleDateFormat("\ndd.MM.yyyy HH:mm:ss ").format(new Date()) +
                        " Class: " + getClass() + "\n" +
                        "Wine with id =" + existWine.getId() + "(" + existWine.getName() + ") -" + " изменен в БД.");

            } else {
                System.out.println(new SimpleDateFormat("\ndd.MM.yyyy HH:mm:ss ").format(new Date()) +
                        " Class: " + getClass() +
                        " : Something error (((");
            }
        } catch (HibernateException e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                throw e;// перебрасывание исключения на более высокий уровень
            }
        } finally {
            session.close(); // гарантированное закрытие сеанса
        }
        return updateId; //изменения успешно внесены в БД

    }


}
