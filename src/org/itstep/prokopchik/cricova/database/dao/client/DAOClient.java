package org.itstep.prokopchik.cricova.database.dao.client;

import org.itstep.prokopchik.cricova.Client;
import org.itstep.prokopchik.cricova.Company;

import java.util.List;

public interface DAOClient {
    Client createClient(String login,
                        String password,
                        String name,
                        String middleName,
                        String lastName,
                        Company company);

    Client findClient(String login);

    Client findClientById(Integer id);

    Integer saveClient(Client client);

    List<Client> findAllClients();
}
