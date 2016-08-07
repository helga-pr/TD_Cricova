package org.itstep.prokopchik.cricova.database.dao.client;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.itstep.prokopchik.cricova.Client;
import org.itstep.prokopchik.cricova.Company;
import org.itstep.prokopchik.cricova.database.HibernateSessionFactory;
import org.itstep.prokopchik.cricova.database.dao.company.CompaniesEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "clients", schema = "", catalog = "cricovadb")
public class ClientsEntity implements Serializable, DAOClient {
    private int idClient;
    private String loginClient;
    private String passwordClient;
    private String nameClient;
    private String middlenameClient;
    private String lastnameClient;
    private String contactsClient;


    private CompaniesEntity company;

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    public CompaniesEntity getCompany() {
        return this.company;
    }

    public void setCompany(CompaniesEntity company) {
        this.company = company;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //generated DataBase auto_increment when insert value
    @Column(name = "id_client", nullable = false, insertable = true, updatable = true)
    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    @Basic
    @Column(name = "login_client", nullable = false, insertable = true, updatable = true, length = 45)
    public String getLoginClient() {
        return loginClient;
    }

    public void setLoginClient(String loginClient) {
        this.loginClient = loginClient;
    }

    @Basic
    @Column(name = "password_client", nullable = false, insertable = true, updatable = true, length = 45)
    public String getPasswordClient() {
        return passwordClient;
    }

    public void setPasswordClient(String passwordClient) {
        this.passwordClient = passwordClient;
    }

    @Basic
    @Column(name = "name_client", nullable = false, insertable = true, updatable = true, length = 45)
    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    @Basic
    @Column(name = "middlename_client", nullable = true, insertable = true, updatable = true, length = 45)
    public String getMiddlenameClient() {
        return middlenameClient;
    }

    public void setMiddlenameClient(String middlenameClient) {
        this.middlenameClient = middlenameClient;
    }

    @Basic
    @Column(name = "lastname_client", nullable = false, insertable = true, updatable = true, length = 45)
    public String getLastnameClient() {
        return lastnameClient;
    }

    public void setLastnameClient(String lastnameClient) {
        this.lastnameClient = lastnameClient;
    }

    @Basic
    @Column(name = "contacts_client", nullable = true, insertable = true, updatable = true, length = 45)
    public String getContactsClient() {
        return contactsClient;
    }

    public void setContactsClient(String contactsClient) {
        this.contactsClient = contactsClient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientsEntity that = (ClientsEntity) o;

        if (idClient != that.idClient) return false;
        if (contactsClient != null ? !contactsClient.equals(that.contactsClient) : that.contactsClient != null)
            return false;
        if (lastnameClient != null ? !lastnameClient.equals(that.lastnameClient) : that.lastnameClient != null)
            return false;
        if (loginClient != null ? !loginClient.equals(that.loginClient) : that.loginClient != null) return false;
        if (middlenameClient != null ? !middlenameClient.equals(that.middlenameClient) : that.middlenameClient != null)
            return false;
        if (nameClient != null ? !nameClient.equals(that.nameClient) : that.nameClient != null) return false;
        if (passwordClient != null ? !passwordClient.equals(that.passwordClient) : that.passwordClient != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idClient;
        result = 31 * result + (loginClient != null ? loginClient.hashCode() : 0);
        result = 31 * result + (passwordClient != null ? passwordClient.hashCode() : 0);
        result = 31 * result + (nameClient != null ? nameClient.hashCode() : 0);
        result = 31 * result + (middlenameClient != null ? middlenameClient.hashCode() : 0);
        result = 31 * result + (lastnameClient != null ? lastnameClient.hashCode() : 0);
        result = 31 * result + (contactsClient != null ? contactsClient.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ClientsEntity{" +
                "idClient=" + idClient +
                ", loginClient='" + loginClient + '\'' +
                ", passwordClient='" + passwordClient + '\'' +
                ", nameClient='" + nameClient + '\'' +
                ", middlenameClient='" + middlenameClient + '\'' +
                ", lastnameClient='" + lastnameClient + '\'' +
                ", contactsClient='" + contactsClient + '\'' +
                ", company=" + company.getNameCompany() + "(" + company.getUnpCompany() + ") " +
                '}';
    }

    @Override
    public Client createClient(String login,
                               String password,
                               String name,
                               String middleName,
                               String lastName,
                               Company company,
                               String contactsClient) {

        Client newClient = null;

        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        try {
            Transaction transaction = session.beginTransaction();

            ClientsEntity clientEntity = new ClientsEntity();
            clientEntity.setLoginClient(login);
            clientEntity.setPasswordClient(password);
            clientEntity.setNameClient(name);
            clientEntity.setMiddlenameClient(middleName);
            clientEntity.setLastnameClient(lastName);
            clientEntity.setContactsClient(contactsClient);
            clientEntity.setCompany(new CompaniesEntity().findByUnpForEntity(company.getUnp()));

            Integer newClientId = (Integer) session.save(clientEntity);
            transaction.commit();

            newClient = findClientById(newClientId);

        /* ддя отладки */
            if (newClient != null) {
                System.out.println(new SimpleDateFormat("dd.mm.yyyy hh:mm:ss ").format(new Date()) +
                        getClass() +
                        ": \nКлиент " + newClient.getLogin() + " добавлен в БД. Представляет компанию "
                        + newClient.getCompany());

            } else {
                System.out.println(new SimpleDateFormat("dd.mm.yyyy hh:mm:ss ").format(new Date()) +
                        getClass() +
                        ": \nОшибка. Новый клиент не сохранен в БД!");
            }
        } catch (HibernateException e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                throw e;// перебрасывание исключения на более высокий уровень
            }
        } finally {
            session.close(); // гарантированное закрытие сеанса
        }

        return newClient;
    }

    @Override
    public Client findClient(String login) {
        Client clientByLogin = null;

        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        try {
            Transaction transaction = session.beginTransaction();

            ClientsEntity clientsEntity = (ClientsEntity) session.createQuery
                    ("from ClientsEntity AS c where c.loginClient = :login")
                    .setParameter("login", login)
                    .uniqueResult();

            if (clientsEntity != null) {
                clientByLogin = createClientFromClientEntity(clientsEntity);
            }

            transaction.commit();

        /* ддя отладки */
            if (clientByLogin != null) {
                System.out.println(new SimpleDateFormat("dd.mm.yyyy hh:mm:ss ").format(new Date()) +
                        getClass() +
                        ": " +
                        clientByLogin.getLogin() + " найден в БД. Представляет компанию "
                        + clientByLogin.getCompany());

            } else {
                System.out.println(new SimpleDateFormat("dd.mm.yyyy hh:mm:ss ").format(new Date()) +
                        getClass() +
                        ": \nNo data with this criterias in table clients");
            }
        } catch (HibernateException e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                throw e;// перебрасывание исключения на более высокий уровень
            }
        } finally {
            session.close(); // гарантированное закрытие сеанса
        }


        return clientByLogin;
    }

    @Override
    public Client findClientById(Integer id) {
        Client clientById = null;

        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        try {
            Transaction transaction = session.beginTransaction();

            clientById = createClientFromClientEntity(
                    (ClientsEntity) session.createQuery("FROM ClientsEntity c WHERE c.idClient = :id")
                            .setParameter("id", id)
                            .uniqueResult());

            transaction.commit();

            // TODO ддя отладки
            if (clientById != null) {
                System.out.println(new SimpleDateFormat("\ndd.MM.yyyy HH:mm:ss ").format(new Date()) +
                        " Class ClientsEntity: " +
                        clientById.getLogin() + " найден в БД. Представляет компанию "
                        + clientById.getCompany());

            } else {
                System.out.println(new SimpleDateFormat("\ndd.MM.yyyy HH:mm:ss ").format(new Date()) +
                        " Class ClientsEntity: " +
                        "No data with this criterias");
            }
        } catch (HibernateException e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                throw e;// перебрасывание исключения на более высокий уровень
            }
        } finally {
            session.close(); // гарантированное закрытие сеанса
        }

        return clientById;
    }

    @Override
    public List<Client> findAllClients() {

        List<Client> allClients = null;
        List<ClientsEntity> result = null;

        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        try {
            Transaction transaction = session.beginTransaction();

            result = session.createQuery("from ClientsEntity c").list();

            transaction.commit();

            //TODO ддя отладки
            if (!result.isEmpty()) {
                for (ClientsEntity clientsEntity : result) {
                    Client client = createClientFromClientEntity(clientsEntity);

                    allClients.add(client);

                    System.out.println(new SimpleDateFormat("\ndd.MM.yyyy HH:mm:ss ").format(new Date()) +
                            " Class ClientsEntity: clientsEntity = " +
                            clientsEntity);
                }
            } else {
                System.out.println(new SimpleDateFormat("\ndd.MM.yyyy HH:mm:ss ").format(new Date()) +
                        " Class ClientsEntity: " +
                        "No data from table clients");
            }
        } catch (HibernateException e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                throw e;// перебрасывание исключения на более высокий уровень
            }
        } finally {
            session.close(); // гарантированное закрытие сеанса
        }

        return allClients;
    }

    /**
     * сохранение объекта Client в БД
     *
     * @param client
     * @return idClient
     */
    @Override
    public Integer updateClient(Client client) {

        Integer newId = -1;
        Client existClient = new ClientsEntity().findClientById(client.getId());

        if (client.equals(existClient)) {
            return 0; //без изменений
        }

        if (existClient == null) {
            return -1; //объект не найден в БД
        }

        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        try {
            Transaction transaction = session.beginTransaction();

            ClientsEntity existClientsEntity = (ClientsEntity) session.get(ClientsEntity.class, client.getId());
            existClientsEntity.setLoginClient(client.getLogin());
            existClientsEntity.setPasswordClient(client.getPassword());
            existClientsEntity.setNameClient(client.getName());
            existClientsEntity.setMiddlenameClient(client.getMiddleName());
            existClientsEntity.setLastnameClient(client.getLastname());
            existClientsEntity.setContactsClient(client.getContacts());

            CompaniesEntity existCompanyEntity = new CompaniesEntity();

            if (existCompanyEntity.isExistCompanyWithUnp(client.getCompany().getUnp())) {

                existCompanyEntity = existCompanyEntity.findByUnpForEntity(client.getCompany().getUnp());

            } else {
                existCompanyEntity = existCompanyEntity.createCompany(client.getCompany());
            }

            existClientsEntity.setCompany(existCompanyEntity);

            newId = (Integer) session.save(existClientsEntity);

            transaction.commit();

            //TODO ддя отладки
            if (existClient != null) {
                System.out.println(new SimpleDateFormat("\ndd.MM.yyyy HH:mm:ss ").format(new Date()) +
                        " Class ClientsEntity: " +
                        existClient.getLogin() + " изменен в БД. Представляет компанию "
                        + existClient.getCompany());

            } else {
                System.out.println(new SimpleDateFormat("\ndd.MM.yyyy HH:mm:ss ").format(new Date()) +
                        " Class ClientsEntity: " +
                        "Something error (((");
            }
        } catch (HibernateException e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                throw e;// перебрасывание исключения на более высокий уровень
            }
        } finally {
            session.close(); // гарантированное закрытие сеанса
        }
        return newId; //изменения успешно внесены в БД

    }

    /**
     * метод для приведения сущности ClientsEntity из БД к экземпляру класса Client
     *
     * @param clientsEntity
     * @return Client
     */
    private static Client createClientFromClientEntity(ClientsEntity clientsEntity) {

        Client client = null;

        if (clientsEntity != null) {
            client = new Client();
            client.setId(clientsEntity.getIdClient());
            client.setLogin(clientsEntity.getLoginClient());
            client.setPassword(clientsEntity.getPasswordClient());
            client.setName(clientsEntity.getNameClient());
            client.setMiddleName(clientsEntity.getMiddlenameClient());
            client.setLastname(clientsEntity.getLastnameClient());
            client.setContacts(clientsEntity.getContactsClient());

            Company company = new Company();
            company.setId(clientsEntity.getCompany().getId());
            company.setName(clientsEntity.getCompany().getNameCompany());
            company.setUnp(clientsEntity.getCompany().getUnpCompany());
            company.setNotes(clientsEntity.getCompany().getNotes());

            client.setCompany(company);
        }
        return client;
    }

}
