package org.itstep.prokopchik.cricova.logic;

import org.itstep.prokopchik.cricova.Admin;
import org.itstep.prokopchik.cricova.Client;
import org.itstep.prokopchik.cricova.database.dao.admin.AdminsEntity;
import org.itstep.prokopchik.cricova.database.dao.client.ClientsEntity;

/**
 * class LoginLogic: для проверки логина-пароля"
 */
public class LoginLogic {

    /**
     * проверка логина-пароля
     *
     * @param enterLogin
     * @param enterPass
     * @param adminflag
     * @return boolean
     */
    public static boolean checkLogin(String enterLogin, String enterPass, String adminflag) {


        if (adminflag.equals("администратор")) {
            Admin admin = null;

            admin = new AdminsEntity().findAdmin(enterLogin);

            return admin != null &&
                    admin.getPassword().equals(enterPass);

        } else if (adminflag.equals("клиент")) {

            Client client = null;

            client = new ClientsEntity().findClient(enterLogin);

            return client != null &&
                    client.getPassword().equals(enterPass);
        } else


            return false;
    }


}
