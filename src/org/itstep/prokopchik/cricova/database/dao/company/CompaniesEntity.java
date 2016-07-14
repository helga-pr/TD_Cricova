package org.itstep.prokopchik.cricova.database.dao.company;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.itstep.prokopchik.cricova.Company;
import org.itstep.prokopchik.cricova.database.HibernateSessionFactory;
import org.itstep.prokopchik.cricova.database.dao.client.ClientsEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "companies", schema = "", catalog = "cricovadb")
public class CompaniesEntity implements DAOCompany, Serializable {
    private int id;
    private String nameCompany;
    private Long unpCompany;
    private String notes;

    private Set<ClientsEntity> clients = new HashSet<ClientsEntity>();

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
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
    public Company createCompany(String name, Long unp, String notes) {

        Company newCompany = null;

        HibernateSessionFactory hibernateSessionFactory = new HibernateSessionFactory();

        Session session = hibernateSessionFactory.getSessionFactory().openSession();

        try {
            Transaction transaction = session.beginTransaction();

            CompaniesEntity companiesEntity = new CompaniesEntity();

            companiesEntity.setNameCompany(name);
            companiesEntity.setUnpCompany(unp);
            companiesEntity.setNotes(notes);

            /**
             * Persist the given transient instance, first assigning a generated identifier.
             */
            companiesEntity.setId((Integer) session.save(companiesEntity));
            newCompany = createCompanyFromCompaniesEntity(companiesEntity);
            transaction.commit();

            //TODO ддя отладки
            if (companiesEntity != null) {
                System.out.println("Организация " + companiesEntity.getNameCompany()
                        + " добавлена в БД. УНП "
                        + companiesEntity.getUnpCompany());

            } else {
                System.out.println("Ошибка. Новая организация не сохранена в БД!");
            }
        } catch (HibernateException e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                throw e;// перебрасывание исключения на более высокий уровень
            }
        } finally {
            session.close(); // гарантированное закрытие сеанса
        }

        return newCompany;
    }

    /**
     * Метод используется при сохранении и обновлении объектов класса ClientsEntity ()
     *
     * @param company
     * @return CompaniesEntity
     */
    @Override
    public CompaniesEntity createCompany(Company company) {

        CompaniesEntity newCompaniesEntity = null;

        HibernateSessionFactory hibernateSessionFactory = new HibernateSessionFactory();

        Session session = hibernateSessionFactory.getSessionFactory().openSession();

        try {
            Transaction transaction = session.beginTransaction();

            newCompaniesEntity.setNameCompany(company.getName());
            newCompaniesEntity.setUnpCompany(company.getUnp());
            newCompaniesEntity.setNotes(company.getNotes());

            /**
             * Persist the given transient instance, first assigning a generated identifier.
             */
            newCompaniesEntity.setId((Integer) session.save(newCompaniesEntity));
            transaction.commit();

            //TODO ддя отладки
            if (newCompaniesEntity != null) {
                System.out.println("Организация " + newCompaniesEntity.getNameCompany()
                        + " добавлена в БД. УНП "
                        + newCompaniesEntity.getUnpCompany());

            } else {
                System.out.println("Ошибка. Новая организация не сохранена в БД!");
            }
        } catch (HibernateException e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                throw e;// перебрасывание исключения на более высокий уровень
            }
        } finally {
            session.close(); // гарантированное закрытие сеанса
        }

        return newCompaniesEntity;
    }

    @Override
    public Company findByName(String name) {

        Company company = null;

        HibernateSessionFactory hibernateSessionFactory = new HibernateSessionFactory();

        Session session = hibernateSessionFactory.getSessionFactory().openSession();

        try {
            Transaction transaction = session.beginTransaction();

            company = createCompanyFromCompaniesEntity(
                    (CompaniesEntity) session.createQuery("from CompaniesEntity c where c.nameCompany = :nameCompany")
                            .setParameter("nameCompany", name)
                            .uniqueResult()
            );

            transaction.commit();
            /**
             * Persist the given transient instance, first assigning a generated identifier.
             */

            //TODO ддя отладки
            if (company != null) {
                System.out.println("Организация " + company.getName()
                        + " найдена в БД. УНП "
                        + company.getUnp());

            } else {
                System.out.println("Ошибка. Организация не найдена в БД!");
            }
        } catch (HibernateException e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                throw e;// перебрасывание исключения на более высокий уровень
            }
        } finally {
            session.close(); // гарантированное закрытие сеанса
        }

        return company;
    }

    @Override
    public Company findByUnp(Long unp) {

        CompaniesEntity existCompanyEntity = null;
        Company existCompany = null;

        existCompanyEntity = findByUnpForEntity(unp);

        existCompany = createCompanyFromCompaniesEntity(existCompanyEntity);

        return existCompany;
    }

    @Override
    public CompaniesEntity findByUnpForEntity(Long unp) {
        CompaniesEntity existCompanyEntity = null;

        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        try {
            Transaction transaction = session.beginTransaction();

            existCompanyEntity = (CompaniesEntity) session.createQuery("from CompaniesEntity c where c.unpCompany = :unp")
                    .setParameter("unp", unp)
                    .uniqueResult();
            transaction.commit();
        } catch (HibernateException e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                throw e;// перебрасывание исключения на более высокий уровень
            }
        } finally {
            session.close(); // гарантированное закрытие сеанса
        }

        return existCompanyEntity;

    }

    @Override
    public Company findById(Integer id) {
        Company company = null;

        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        try {
            Transaction transaction = session.beginTransaction();

            company = createCompanyFromCompaniesEntity(
                    (CompaniesEntity) session.get(CompaniesEntity.class, id)
            );
            transaction.commit();

            //TODO ддя отладки
            if (company != null) {
                System.out.println("Организация " + company.getName()
                        + " добавлена в БД. УНП "
                        + company.getUnp());

            } else {
                System.out.println("Ошибка. Новая организация не сохранена в БД!");
            }

        } catch (HibernateException e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                throw e;// перебрасывание исключения на более высокий уровень
            }
        } finally {
            session.close(); // гарантированное закрытие сеанса
        }

        return company;
    }

    @Override
    public List<Company> findAllCompanies() {

        List<Company> allCompanies = null;
        List<CompaniesEntity> result = null;

        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        try {
            Transaction transaction = session.beginTransaction();

            result = session.createQuery("from CompaniesEntity c").list();

            transaction.commit();

            //TODO ддя отладки
            if (!result.isEmpty()) {
                for (CompaniesEntity companiesEntity : result) {
                    Company company = createCompanyFromCompaniesEntity(companiesEntity);

                    allCompanies.add(company);

                    System.out.println(companiesEntity);
                }
            } else {
                System.out.println("No data from table companies");
            }
        } catch (HibernateException e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                throw e;// перебрасывание исключения на более высокий уровень
            }
        } finally {
            session.close(); // гарантированное закрытие сеанса
        }

        return allCompanies;

    }

    @Override
    public Boolean isExistCompanyWithUnp(Long unp) {

        CompaniesEntity existCompanyEntity = null;

        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        try {
            Transaction transaction = session.beginTransaction();

            existCompanyEntity = (CompaniesEntity) session.createQuery("from CompaniesEntity c where c.unpCompany = :unp")
                    .setParameter("unp", unp)
                    .uniqueResult();
            transaction.commit();
        } catch (HibernateException e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                throw e;// перебрасывание исключения на более высокий уровень
            }
        } finally {
            session.close(); // гарантированное закрытие сеанса
        }

        return existCompanyEntity != null;

    }

    @Override
    public Integer updateCompany(Company company) {
        Integer newId = -1;
        Company existCompany = null;
        existCompany = new CompaniesEntity().findById(company.getId());

        if (company.equals(existCompany)) {
            return 0; //без изменений
        }

        if (existCompany == null) {
            return -1; //объект не найден в БД
        }

        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        try {
            Transaction transaction = session.beginTransaction();

            CompaniesEntity existCompaniesEntity = (CompaniesEntity) session.get(CompaniesEntity.class, company.getId());
            existCompaniesEntity.setNameCompany(company.getName());
            //добавляются заметки, если такой текст не найден в сохраненном экземпляре CompaniesEntity
            if (!existCompaniesEntity.getNotes().contains(company.getNotes())) {
                existCompaniesEntity.setNotes(existCompaniesEntity.getNotes() + "; " + company.getNotes());
            }
            newId = (Integer) session.save(existCompaniesEntity);

            transaction.commit();

            //TODO ддя отладки
            if (existCompany != null) {
                System.out.println(existCompany.getName() + " изменена в БД.");

            } else {
                System.out.println("Something error in save method of CompaniesEntity  :(((");
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

    private static Company createCompanyFromCompaniesEntity(CompaniesEntity existCompanyEntity) {
        Company existCompany = null;

        if (existCompanyEntity != null) {

            existCompany.setId(existCompanyEntity.getId());
            existCompany.setName(existCompanyEntity.getNameCompany());
            existCompany.setUnp(existCompanyEntity.getUnpCompany());
            existCompany.setNotes(existCompanyEntity.getNotes());
        }

        return existCompany;
    }


}
