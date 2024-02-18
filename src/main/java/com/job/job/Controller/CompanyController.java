package com.job.job.Controller;

import com.job.job.Entities.Company;
import com.job.job.Service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<Company>getAllCompanies(){
        return companyService.getAllCompanies();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id , @RequestBody Company updatedCompany){
        companyService.updateCompany(id,updatedCompany);
        return new ResponseEntity<>("successfully updated company", HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> createCompany(@RequestBody Company company){
        this.companyService.createCompany(company);
        return new ResponseEntity<>("company added successfully",HttpStatus.CREATED);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id){
        companyService.deleteCompany(id);
        return new ResponseEntity<>("company deleted successfully",HttpStatus.ACCEPTED);
    }

}
