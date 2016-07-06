package org.itstep.prokopchik.cricova.logic;


import org.itstep.prokopchik.cricova.Admin;
import org.itstep.prokopchik.cricova.Client;
import org.itstep.prokopchik.cricova.database.dao.admin.AdminsEntity;
import org.itstep.prokopchik.cricova.database.dao.client.ClientsEntity;

public class LoginLogic {

    public static boolean checkLogin(String enterLogin, String enterPass, String adminflag) {


        if (adminflag.equals("администратор")) {
            Admin admin = new Admin();

            admin = new AdminsEntity().findAdmin(enterLogin);

            return admin != null &&
                    admin.getPassword().equals(enterPass);
        } else {

            Client client = new Client();

            client = new ClientsEntity().findClient(enterLogin);

            return client != null &&
                    client.getPassword().equals(enterPass);
        }
    }

}
