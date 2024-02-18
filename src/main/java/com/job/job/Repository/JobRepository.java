package com.job.job.Repository;

import com.job.job.Entities.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Jobs,Long> {
}
