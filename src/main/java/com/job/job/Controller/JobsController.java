package com.job.job.Controller;

import com.job.job.Entities.Jobs;
import com.job.job.Service.JobsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class JobsController {

    private final JobsService jobsService;

    public JobsController(JobsService jobsService) {
        this.jobsService = jobsService;
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Jobs>> findAll(){
        return new ResponseEntity<>(jobsService.findAll(),HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> save(@RequestBody Jobs job){
        jobsService.createJob(job);
        return new ResponseEntity<>("jobs added successfully",HttpStatus.ACCEPTED);

    }

    @GetMapping("/job/{id}")
    public ResponseEntity<Jobs> getJobById(@PathVariable Long id){
        return new  ResponseEntity<> (jobsService.getJobById(id),HttpStatus.IM_USED);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity <String> deleteJobById(@PathVariable Long id){
         jobsService.deleteJobById(id);
         return new ResponseEntity<>("Jobs deleted Successfully",HttpStatus.OK);
    }

    @PutMapping("put/{id}")
    public ResponseEntity<String> updateJob(@PathVariable Long id, @RequestBody Jobs updateJob){
        boolean updated = jobsService.updateJob(id, updateJob);
        if(updated)
            return new ResponseEntity<>("Jobs Updated Successfully", HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
