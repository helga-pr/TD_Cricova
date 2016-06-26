package org.itstep.prokopchik.cricova.database.dao.company;

import org.itstep.prokopchik.cricova.Company;

abstract public class DAOCompany {

    abstract public Company createCompany(Company company);

    abstract public Company createCompany(String name, String unp, String notes);

    abstract public Company getByName(String name);

    abstract public Company getByUnp(String unp);

    abstract public Company getById(Integer id);

}
