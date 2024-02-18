package com.example1.Project1.Job;

import com.example1.Project1.Company.Company;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
//@Table(name="job_table")
public class Job {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; 
	private String title;
	private String description;
	
	@ManyToOne
	private Company company;
	
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Job() {
		
	}
	private String maxSalary;
	private String minSalary;
	private String location;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMaxSalary() {
		return maxSalary;
	}
	public void setMaxSalary(String maxSalary) {
		this.maxSalary = maxSalary;
	}
	public String getMinSalary() {
		return minSalary;
	}
	public void setMinSalary(String minSalary) {
		this.minSalary = minSalary;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Job(Long id, String title, String description, String maxSalary, String minSalary, String location) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.maxSalary = maxSalary;
		this.minSalary = minSalary;
		this.location = location;
	}
	
	
	
	
	
	
	

}
