package org.itstep.prokopchik.cricova.database.dao.company;

import org.itstep.prokopchik.cricova.Company;
import org.itstep.prokopchik.cricova.database.dao.client.ClientsEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "companies", schema = "", catalog = "cricovadb")
public class CompaniesEntity extends DAOCompany {
    private int id;
    private String nameCompany;
    private long unpCompany;
    private String notes;

    private Set<ClientsEntity> clients = new HashSet<ClientsEntity>();

    @OneToMany(cascade = CascadeType.ALL)
    public Set<ClientsEntity> getClients() {
        return clients;
    }

    public void setClients(Set<ClientsEntity> clients) {
        this.clients = clients;
    }

    public void addClient(ClientsEntity client) {
        client.setCompany(this);
        this.clients.add(client);
    }

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name_company", nullable = false, insertable = true, updatable = true, length = 45)
    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    @Basic
    @Column(name = "unp_company", nullable = false, insertable = true, updatable = true)
    public long getUnpCompany() {
        return unpCompany;
    }

    public void setUnpCompany(long unpCompany) {
        this.unpCompany = unpCompany;
    }

    @Basic
    @Column(name = "notes", nullable = true, insertable = true, updatable = true, length = 254)
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompaniesEntity that = (CompaniesEntity) o;

        if (id != that.id) return false;
        if (unpCompany != that.unpCompany) return false;
        if (nameCompany != null ? !nameCompany.equals(that.nameCompany) : that.nameCompany != null) return false;
        if (notes != null ? !notes.equals(that.notes) : that.notes != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nameCompany != null ? nameCompany.hashCode() : 0);
        result = 31 * result + (int) (unpCompany ^ (unpCompany >>> 32));
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        return result;
    }

    @Override
    public Company createCompany(Company company) {
        return null;
    }

    @Override
    public Company createCompany(String name, String unp, String notes) {
        return null;
    }

    @Override
    public Company getByName(String name) {
        return null;
    }

    @Override
    public Company getByUnp(String unp) {
        return null;
    }

    @Override
    public Company getById(Integer id) {
        return null;
    }
}
