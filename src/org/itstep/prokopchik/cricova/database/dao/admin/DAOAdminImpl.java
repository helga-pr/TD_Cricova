package org.itstep.prokopchik.cricova.database.dao.admin;


import org.itstep.prokopchik.cricova.Admin;
import org.itstep.prokopchik.cricova.database.MyConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOAdminImpl extends DAOAdmin {

    /**
     * Метод добавляет в базу данных пользователя с правами администратора
     * возможно, такой метод не нужен с точки зрения безопасности
     * админов лучше доавлять напрямую в базуданных.
     *
     * @param login
     * @param password
     * @return
     */
    @Override
    public Admin createAdmin(String login, String password) {

        Admin newAdmin = null;

        if (login != null && !login.isEmpty() && password != null && !password.isEmpty()) {
            MyConnection myConnection = new MyConnection();
            myConnection.createConnection();

            final String SQL_INSERT = "INSERT into admin (login, password) values (?,?)";
            try {

                PreparedStatement prepstatement = myConnection.createConnection().prepareStatement(SQL_INSERT);

                newAdmin = new Admin();
                prepstatement.setString(1, login);
                prepstatement.setString(2, password);

                prepstatement.executeUpdate();

                newAdmin.setLogin(login);
                newAdmin.setPassword(password);

                //только для отладки
                System.out.println("Admin " + newAdmin.toString() + " added!");

                //prepstatement closed
                if (prepstatement != null) {
                    try {
                        prepstatement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return newAdmin;
    }

    /**
     * Метод возвращает пользователя с административными правами по заданным логину и паролю
     * Метод используется при авторизации
     *
     * @param login
     * @param password
     * @return Admin
     */
    @Override
    public Admin getAdmin(String login, String password) {

        Admin admin = null;

        if (login != null && !login.isEmpty() && password != null && !password.isEmpty()) {
            MyConnection myConnection = new MyConnection();
            myConnection.createConnection();

            final String SQL_SELECT = "SELECT * FROM admin WHERE login = ? AND password = ?";
            try {

                PreparedStatement prepstatement = myConnection.createConnection().prepareStatement(SQL_SELECT);

                prepstatement.setString(1, login);
                prepstatement.setString(2, password);

                ResultSet rs = prepstatement.executeQuery();

                //в rs может быть 1 или 0 значений т.к. в таблице login - уникальное значение
                if (rs != null) {

                    while (rs.next()) {

                        admin = new Admin();

                        admin.setLogin(rs.getString(1));
                        admin.setPassword(rs.getString(2));
                    }

                    //только для отладки
                    if (admin.getLogin() != null) {

                        System.out.println(admin.toString() + " is exist!");
                    } else {
                        System.out.println("Admin " + login + " not exist!");
                    }

                }

                //prepstatement closed
                if (prepstatement != null) {
                    try {
                        prepstatement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

            } catch (SQLException e) {
                // TODO Auto-generated catch block


                e.printStackTrace();
            }
        }
        return admin;
    }

}
