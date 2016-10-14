package org.itstep.prokopchik.cricova.logic;

import org.itstep.prokopchik.cricova.Admin;
import org.itstep.prokopchik.cricova.Client;
import org.itstep.prokopchik.cricova.database.dao.admin.AdminsEntity;
import org.itstep.prokopchik.cricova.database.dao.client.ClientsEntity;

/**
 * class LoginLogic: для проверки логина-пароля"
 */
public class LoginLogic {

    private static final String SESSION_ATTR_ROLE = "role";//роль пользователя (клиент или администратор)

    /**
     * проверка логина-пароля
     *
     * @param enterLogin
     * @param enterPass
     * @return boolean
     */
    public static String checkLogin(String enterLogin, String enterPass) {

        Admin admin = null;
        admin = new AdminsEntity().findAdmin(enterLogin);
        Client client = null;
        client = new ClientsEntity().findClient(enterLogin);

        if (admin != null &&
                admin.getPassword().equals(enterPass)) {
            return "admin";

        } else if (client != null &&
                client.getPassword().equals(enterPass)) {
            return "client";
        } else

            return "error_login_or_password";
    }


}
