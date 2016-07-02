package org.itstep.prokopchik.cricova.database.dao.client;

import org.itstep.prokopchik.cricova.Client;
import org.itstep.prokopchik.cricova.Company;

import java.util.List;

public abstract class DAOClient {

    abstract public Client createClient(String login,
                                        String password,
                                        String name,
                                        String middleName,
                                        String lastName,
                                        Company company);

    abstract public Client getClient(String login);

    abstract public List<ClientsEntity> getAllClients();

    abstract public Client getClientById(Integer id);

    abstract public Integer saveClient(Client client);

}

