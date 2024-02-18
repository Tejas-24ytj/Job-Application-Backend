package com.example1.Project1.Company;

import java.util.List;

public interface CompanyService {
 List<Company>getAllCompanies();
 boolean updateCompany (Company company,Long id);
 void createCompany(Company company);
 boolean deleteById(Long id);
 Company getCompanyById(Long id);


}
