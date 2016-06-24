package org.itstep.prokopchik.cricova.database.dao.admin;

import org.itstep.prokopchik.cricova.Admin;

import javax.persistence.*;

@Entity
@Table(name = "admins", schema = "", catalog = "cricovadb")
public class AdminsEntity extends DAOAdmin {
    private int idAdmin;
    private String loginAdmin;
    private String passwordAdmin;

    @Id
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

        if (idAdmin != that.idAdmin) return false;
        if (loginAdmin != null ? !loginAdmin.equals(that.loginAdmin) : that.loginAdmin != null) return false;
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
        return null;
    }

    @Override
    public Admin getAdmin(String login, String password) {
        return null;
    }

    @Override
    public Admin getAdminById(Integer id) {
        return null;
    }
}
