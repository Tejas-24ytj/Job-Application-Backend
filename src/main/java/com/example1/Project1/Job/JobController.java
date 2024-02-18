package com.example1.Project1.Job;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example1.Project1.Company.Company;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private final JobService jobservice;

    @Autowired
    public JobController(JobService jobservice) {
        this.jobservice = jobservice;
    }

    @GetMapping
    public ResponseEntity <List<Job>> findAll() {
        return ResponseEntity.ok(jobservice.findAll());
    }

    @PostMapping
    public ResponseEntity <String> createJob(@RequestBody Job job) {
        jobservice.createJob(job);
        return new ResponseEntity <>("Job Added Successfully",HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity <Job> getJobById(@PathVariable Long id) {
    	Job job=jobservice.getJobById(id);
    	if(job!=null) {
    		return new ResponseEntity<>(job,HttpStatus.OK);
    	}
    	return new ResponseEntity<>(HttpStatus.NOT_FOUND);   	
    }
    @DeleteMapping("{id}")
    public ResponseEntity <String>deleteJob(@PathVariable Long id){
    	boolean deleted=jobservice.deleteJobById(id);
    	if(deleted)
    		return new ResponseEntity <>("Job Deleted Successfully.",HttpStatus.OK);
    	return new ResponseEntity <>(HttpStatus.NOT_FOUND);	
    }
    @PutMapping("{id}")
    //@RequestMapping(value  ="/jobs/{id}", method=RequestMethod.PUT)
    public ResponseEntity <String>updateJob(@PathVariable Long id,@RequestBody Job updatedJob){
    	boolean updated=jobservice.updateJob(id,updatedJob);
    	if(updated)
    		return new ResponseEntity<>("Job Updated Successfully",HttpStatus.OK);
    	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
}
