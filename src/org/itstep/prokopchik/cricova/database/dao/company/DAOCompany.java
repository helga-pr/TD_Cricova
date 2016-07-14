package org.itstep.prokopchik.cricova.database.dao.company;

import org.itstep.prokopchik.cricova.Company;

import java.util.List;

interface DAOCompany {

    CompaniesEntity createCompany(Company company);

    Company createCompany(String name, Long unp, String notes);

    Company findByName(String name);

    Company findByUnp(Long unp);

    CompaniesEntity findByUnpForEntity(Long unp);

    Company findById(Integer id);

    List<Company> findAllCompanies();

    Boolean isExistCompanyWithUnp(Long unp);

    Integer updateCompany(Company company);

}
