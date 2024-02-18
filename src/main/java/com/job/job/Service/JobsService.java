package com.job.job.Service;

import com.job.job.Entities.Jobs;

import java.util.List;
import java.util.Optional;

public interface JobsService {
    List<Jobs>findAll();
    Void createJob(Jobs job);

    Jobs getJobById(Long id);
    void deleteJobById(Long id);

    Boolean updateJob(Long id, Jobs updateJob);
}
