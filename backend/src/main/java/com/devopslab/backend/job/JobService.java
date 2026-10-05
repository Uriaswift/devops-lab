package com.devopslab.backend.job;

import com.devopslab.backend.runner.JobRunner;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.devopslab.backend.runner.RunnerResult;

import java.util.List;

@Service
public class JobService {

    private final JobRepository jobRepository;

    private final JobRunner jobRunner;

    public JobService(
        JobRepository jobRepository,
        JobRunner jobRunner
    ) {
        this.jobRepository = jobRepository;
        this.jobRunner = jobRunner;
    }

    @Transactional
    public Job create(JobAction action, String targetHost) {

        Job job = new Job(action, targetHost);

        jobRepository.save(job);

        job.markRunning();

        try {

            RunnerResult result =
                jobRunner.run(action, targetHost);

            if (result.success()) {
                job.markSuccess(result.output());
            } else {
                job.markFailed(result.output());
            }

        } catch (Exception exception) {

            job.markFailed(
                "Runner error: " + exception.getMessage()
            );
        }

        return job;
    }

    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    public Job findById(Long id) {
        return jobRepository.findById(id)
            .orElseThrow(() ->
                new IllegalArgumentException("Job not found: " + id)
            );
    }

    @Transactional
    public Job markRunning(Long id) {
        Job job = findById(id);

        job.markRunning();

        return job;
    }

    @Transactional
    public Job markSuccess(Long id, String output) {
        Job job = findById(id);

        job.markSuccess(output);

        return job;
    }

    @Transactional
    public Job markFailed(Long id, String output) {
        Job job = findById(id);

        job.markFailed(output);

        return job;
    }
}
