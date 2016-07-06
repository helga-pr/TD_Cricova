package org.itstep.prokopchik.cricova.database.dao.admin;


import org.itstep.prokopchik.cricova.Admin;

import java.util.List;

interface DAOAdmin {

    Admin createAdmin(String login, String password);

    Admin createAdmin(Admin admin);

    Admin findAdmin(String login);

    Admin findAdminById(Integer id);

    List<Admin> findAllAdmins();
}
