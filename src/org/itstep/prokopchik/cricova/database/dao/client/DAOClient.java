package org.itstep.prokopchik.cricova.database.dao.client;


import org.itstep.prokopchik.cricova.Client;

public abstract class DAOClient {

    abstract public Client createClient(String login, String password, String name, String middleName, String lastname);

    abstract public Client getClient(String login);
}
