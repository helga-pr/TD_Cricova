package org.itstep.prokopchik.cricova;

/**
 *
 */

public class Client {
    private String login;//unique e-mail. возможно работа с БД без id типа int?
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

    /**
     * @see Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((login == null) ? 0 : login.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
        result = prime * result + ((middleName == null) ? 0 : middleName.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((contacts == null) ? 0 : contacts.hashCode());
        return result;
    }

    /**
     * @see Object#equals(Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Client)) {
            return false;
        }
        Client other = (Client) obj;

        if (lastname == null) {
            if (other.lastname != null) {
                return false;
            }
        } else if (!lastname.equals(other.lastname)) {
            return false;
        }
        if (login == null) {
            if (other.login != null) {
                return false;
            }
        } else if (!login.equals(other.login)) {
            return false;
        }
        if (middleName == null) {
            if (other.middleName != null) {
                return false;
            }
        } else if (!middleName.equals(other.middleName)) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (password == null) {
            if (other.password != null) {
                return false;
            }
        } else if (!password.equals(other.password)) {
            return false;
        }
        if (contacts == null) {
            if (other.contacts != null) {
                return false;
            }
        } else if (!contacts.equals(other.contacts)) {
            return false;
        }
        return true;
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
