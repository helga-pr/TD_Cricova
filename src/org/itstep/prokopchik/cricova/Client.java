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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;

        Client client = (Client) o;

        if (!contacts.equals(client.contacts)) return false;
        if (id != null ? !id.equals(client.id) : client.id != null) return false;
        if (lastname != null ? !lastname.equals(client.lastname) : client.lastname != null) return false;
        if (login != null ? !login.equals(client.login) : client.login != null) return false;
        if (!middleName.equals(client.middleName)) return false;
        if (name != null ? !name.equals(client.name) : client.name != null) return false;
        if (password != null ? !password.equals(client.password) : client.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + middleName.hashCode();
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + contacts.hashCode();
        return result;
    }

    /**
     * @see Object#toString()
     */
    @Override
    public String toString() {

        return lastname + " " + name + " " + middleName + "(" + login + ")"
                + ": (Contacts: " + contacts + "}";
    }


}
