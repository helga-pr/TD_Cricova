package org.itstep.prokopchik.cricova.database.dao.admin;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.itstep.prokopchik.cricova.Admin;
import org.itstep.prokopchik.cricova.database.HibernateSessionFactory;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "admins", schema = "", catalog = "cricovadb")
public class AdminsEntity implements DAOAdmin, Serializable {
    private int idAdmin;
    private String loginAdmin;
    private String passwordAdmin;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //generated DataBase auto_increment when insert value
    @Column(name = "id_admin", nullable = false, insertable = true, updatable = true)
    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    @Basic
    @Column(name = "login_admin", nullable = false, insertable = true, updatable = true, length = 45)
    public String getLoginAdmin() {
        return loginAdmin;
    }

    public void setLoginAdmin(String loginAdmin) {
        this.loginAdmin = loginAdmin;
    }

    @Basic
    @Column(name = "password_admin", nullable = false, insertable = true, updatable = true, length = 45)
    public String getPasswordAdmin() {
        return passwordAdmin;
    }

    public void setPasswordAdmin(String passwordAdmin) {
        this.passwordAdmin = passwordAdmin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdminsEntity that = (AdminsEntity) o;

        if (idAdmin != that.idAdmin)
            return false;
        if (loginAdmin != null ? !loginAdmin.equals(that.loginAdmin) : that.loginAdmin != null)
            return false;
        if (passwordAdmin != null ? !passwordAdmin.equals(that.passwordAdmin) : that.passwordAdmin != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idAdmin;
        result = 31 * result + (loginAdmin != null ? loginAdmin.hashCode() : 0);
        result = 31 * result + (passwordAdmin != null ? passwordAdmin.hashCode() : 0);
        return result;
    }

    @Override
    public Admin createAdmin(String login, String password) {

        Admin newAdmin = null;

        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        try {
            Transaction transaction = session.beginTransaction();

            AdminsEntity adminEntity = new AdminsEntity();
            adminEntity.setLoginAdmin(login);
            adminEntity.setPasswordAdmin(password);
            Integer newId = (Integer) session.save(adminEntity);  // возвращает сгенерированный идентификатор id

            newAdmin = new Admin();
            newAdmin.setId(newId);
            newAdmin.setLogin(login);
            newAdmin.setPassword(password);

            transaction.commit();

            // TODO ддя отладки
            if (newAdmin != null) {
                System.out.println(newAdmin.getLogin() + " добавлен в БД. ");

            } else {
                System.out.println("Ошибка. Новый admin не сохранен в БД!");
            }
        } catch (HibernateException e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                throw e;// перебрасывание исключения на более высокий уровень
            }
        } finally {
            session.close(); // гарантированное закрытие сеанса
        }

        return newAdmin;
    }

    @Override
    public Admin createAdmin(Admin admin) {

        AdminsEntity newAdminEntity = null;

        return newAdminEntity.createAdmin(admin.getLogin(), admin.getPassword());
    }

    @Override
    public Admin findAdmin(String login) {

        Admin adminByLogin = null;
        AdminsEntity adminsEntity = null;

        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        try {
            Transaction transaction = session.beginTransaction();

            adminsEntity = (AdminsEntity) session.createQuery("from AdminsEntity a where a.loginAdmin = :login")
                    .setParameter("login", login)
                    .uniqueResult();

            if (adminsEntity != null) {
                adminByLogin = createAdminFromAdminEntity(adminsEntity);
            }

            transaction.commit();

            // TODO удалить или закомментировать
        /* ддя отладки */
            if (adminByLogin != null) {
                System.out.println(adminByLogin.getLogin() + " is exist in DB !");

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

        return adminByLogin;
    }

    private Admin createAdminFromAdminEntity(AdminsEntity adminsEntity) {
        Admin admin = null;
        if (adminsEntity != null) {
            admin = new Admin();
            admin.setId(adminsEntity.getIdAdmin());
            admin.setLogin(adminsEntity.getLoginAdmin());
            admin.setPassword(adminsEntity.getPasswordAdmin());
        }
        return admin;
    }

    @Override
    public Admin findAdminById(Integer id) {

        Admin adminById = null;
        AdminsEntity adminsEntity = null;

        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        try {
            Transaction transaction = session.beginTransaction();

            adminsEntity = (AdminsEntity) session.createQuery("from AdminsEntity a where a.idAdmin = id").uniqueResult();

            adminById = createAdminFromAdminEntity(adminsEntity);

            transaction.commit();

            // TODO удалить или закомментировать
        /* ддя отладки */
            if (adminById != null) {
                System.out.println(adminById.getLogin() + " is exist in DB!");

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

        return adminById;
    }

    @Override
    public List<Admin> findAllAdmins() {

        List<Admin> result = null;
        List<AdminsEntity> adminsEntities = null;

        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        try {
            Transaction transaction = session.beginTransaction();

            adminsEntities = session.createQuery("from AdminsEntity c").list();

            if (!adminsEntities.isEmpty()) {
                Admin admin = new Admin();

                for (AdminsEntity adminsEntity : adminsEntities) {
                    admin = createAdminFromAdminEntity(adminsEntity);
                    result.add(admin);
                }
            }
            transaction.commit();

            // TODO для отладки (удалить или закомментировать)

            if (!result.isEmpty()) {
                for (Admin admin : result) {
                    System.out.println(admin);
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
        return result;
    }


}
