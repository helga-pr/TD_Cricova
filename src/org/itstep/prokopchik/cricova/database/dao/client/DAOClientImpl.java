package org.itstep.prokopchik.cricova.database.dao.client;


import org.itstep.prokopchik.cricova.Client;
import org.itstep.prokopchik.cricova.database.MyConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOClientImpl extends DAOClient {

    @Override
    public Client createClient(String login, String password, String name, String middleName, String lastname) {

        MyConnection myConnection = new MyConnection();

        myConnection.createConnection();

        Client newClient = new Client();

        final String SQL_INSERT = "INSERT into client (login, password, name, middlename, lastname) values (?,?,?,?,?)";

        try {

            PreparedStatement prepstatement = null;
            try {
                prepstatement = myConnection.createConnection().prepareStatement(SQL_INSERT);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            prepstatement.setString(1, login);
            prepstatement.setString(2, password);
            prepstatement.setString(3, name);
            prepstatement.setString(4, middleName);
            prepstatement.setString(5, lastname);

            prepstatement.executeUpdate();

            newClient.setLogin(login);
            newClient.setPassword(password);
            newClient.setName(name);
            newClient.setMiddleName(middleName);
            newClient.setLastname(lastname);

            //только для отладки
            System.out.println("Client " + newClient.toString() + " added!");

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


        return newClient;
    }

    @Override
    public Client getClient(String login) {


        Client client = null;

        if (login != null && !login.isEmpty()) {
            MyConnection myConnection = new MyConnection();
            Connection cn = myConnection.createConnection();

            final String SQL_SELECT = "SELECT * FROM client WHERE login = ?";
            try {

                PreparedStatement prepstatement = cn.prepareStatement(SQL_SELECT);

                prepstatement.setString(1, login);

                ResultSet rs = prepstatement.executeQuery();

                //в rs может быть 1 или 0 значений т.к. в таблице login - уникальное значение
                if (rs != null) {

                    while (rs.next()) {
                        client = new Client();
                        client.setLogin(rs.getString(1));
                        client.setPassword(rs.getString(2));
                        client.setName(rs.getString(3));
                        client.setMiddleName(rs.getString(4));
                        client.setLastname(rs.getString(5));

                        if (client.getLogin() != null) {
                            System.out.println("Client " + client.toString() + " is exist!");
                        } else {
                            System.out.println("Client " + login + " not exist!");
                        }
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
        return client;
    }

}
