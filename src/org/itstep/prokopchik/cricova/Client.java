package org.itstep.prokopchik.cricova;

/**
 *
 */

public class Client {

    private Integer id; //PK

    private String login;//unique
    private String password;

    private String name;
    private String middleName;
    private String lastname;
    private Company company;
    private String contacts;

    public Client() {

    }

    /**
     * methods
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", company=(" + company.toString() +
                "), contacts='" + contacts + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;

        Client client = (Client) o;

        if (!company.equals(client.company)) return false;
        if (contacts != null ? !contacts.equals(client.contacts) : client.contacts != null) return false;
        if (!id.equals(client.id)) return false;
        if (!lastname.equals(client.lastname)) return false;
        if (!login.equals(client.login)) return false;
        if (middleName != null ? !middleName.equals(client.middleName) : client.middleName != null) return false;
        if (!name.equals(client.name)) return false;
        if (!password.equals(client.password)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + login.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
        result = 31 * result + lastname.hashCode();
        result = 31 * result + company.hashCode();
        result = 31 * result + (contacts != null ? contacts.hashCode() : 0);
        return result;
    }
}
