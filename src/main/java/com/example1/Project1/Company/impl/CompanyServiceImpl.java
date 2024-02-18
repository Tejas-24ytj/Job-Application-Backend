package com.example1.Project1.Company.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example1.Project1.Company.Company;
import com.example1.Project1.Company.CompanyRepository;
import com.example1.Project1.Company.CompanyService;
import com.example1.Project1.Job.Job;

@Service
public class CompanyServiceImpl implements CompanyService {
	private CompanyRepository companyRepository;

	public CompanyServiceImpl(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}

	@Override
	public List<Company> getAllCompanies() {
		return companyRepository.findAll();
	}

	@Override
	public boolean updateCompany(Company company, Long id) {
		Optional<Company> companyOptional = companyRepository.findById(id);
		if (companyOptional.isPresent()) {
			Company companyToUpdate = companyOptional.get();
			companyToUpdate.setDescription(company.getDescription());
			companyToUpdate.setName(company.getName());
			companyToUpdate.setJobs(company.getJobs());
			companyRepository.save(companyToUpdate);
			return true;

		} else {
			return false;
		}
	}

	@Override
	public void createCompany(Company company) {
		companyRepository.save(company);

	}

	@Override
	public boolean deleteById(Long id) {
		if (companyRepository.existsById(id)) {
			companyRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Company getCompanyById(Long id) {
		return companyRepository.findById(id).orElse(null);
	}
}
