package com.job.job.Impl;

import com.job.job.Entities.Jobs;
import com.job.job.Service.JobsService;
import com.job.job.Repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobsService {
    private final JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Jobs> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public Void createJob(Jobs job) {
        jobRepository.save(job);
        return null;
    }

    @Override
    public Jobs getJobById(Long id) {
       return jobRepository.findById(id).orElse(null);

    }

    @Override
    public void deleteJobById(Long id) {
       jobRepository.deleteById(id);
    }

    @Override
    public Boolean updateJob(Long id, Jobs updateJob) {
        Optional<Jobs> jobOptional = jobRepository.findById(id);
        if(jobOptional.isPresent()){
            Jobs job = jobOptional.get();
            job.setTitle(updateJob.getTitle());
            job.setDescription(updateJob.getDescription());
            job.setMinSalary(updateJob.getMinSalary());
            job.setMaxSalary(updateJob.getMaxSalary());
            job.setLocation(updateJob.getLocation());
            jobRepository.save(updateJob);
            return true;
        }
        return false;

    }
}


