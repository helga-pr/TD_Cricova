package org.itstep.prokopchik.cricova.database.dao.admin;


import org.itstep.prokopchik.cricova.Admin;

abstract public class DAOAdmin {

    abstract public Admin createAdmin(String login, String password);

    abstract public Admin createAdmin(Admin admin);

    abstract public Admin getAdmin(String login);

    abstract public Admin getAdminById(Integer id);
}
