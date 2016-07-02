package org.itstep.prokopchik.cricova;

public class Company {

    private Integer id;
    private String name;
    private Long unp;
    private String notes;

    public Company() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getUnp() {
        return unp;
    }

    public void setUnp(Long unp) {
        this.unp = unp;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", unp='" + unp + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Company)) return false;

        Company company = (Company) o;

        if (!id.equals(company.id)) return false;
        if (!name.equals(company.name)) return false;
        if (notes != null ? !notes.equals(company.notes) : company.notes != null) return false;
        if (!unp.equals(company.unp)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + unp.hashCode();
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        return result;
    }
}
