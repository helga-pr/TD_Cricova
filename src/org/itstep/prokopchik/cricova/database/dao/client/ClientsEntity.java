package org.itstep.prokopchik.cricova.database.dao.client;

import org.itstep.prokopchik.cricova.Client;
import org.itstep.prokopchik.cricova.Company;
import org.itstep.prokopchik.cricova.database.dao.company.CompaniesEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "clients", schema = "", catalog = "cricovadb")
public class ClientsEntity extends DAOClient implements Serializable {
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
    public Client createClient(String login, String password, String name, String middleName, String lastName, Company company) {
        return null;
    }

    @Override
    public Client getClient(String login) {
        return null;
    }

    @Override
    public Client getClientById(Integer id) {
        return null;
    }

    @Override
    public Client createClient(Client client) {
        return null;
    }
}
