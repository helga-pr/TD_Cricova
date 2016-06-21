package org.itstep.prokopchik.cricova.logic;


import org.itstep.prokopchik.cricova.Admin;
import org.itstep.prokopchik.cricova.Client;
import org.itstep.prokopchik.cricova.database.dao.admin.DAOAdminImpl;
import org.itstep.prokopchik.cricova.database.dao.client.DAOClientImpl;

public class LoginLogic {

    public static boolean checkLogin(String enterLogin, String enterPass, String adminflag) {


        if (adminflag.equals("администратор")) {
            Admin admin = new Admin();

            admin = new DAOAdminImpl().getAdmin(enterLogin, enterPass);

            return admin != null &&
                    admin.getPassword().equals(enterPass);
        } else {

            Client client = new Client();

            client = new DAOClientImpl().getClient(enterLogin);

            return client != null &&
                    client.getPassword().equals(enterPass);
        }
    }

}
