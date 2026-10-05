package com.devopslab.backend.job;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public List<Job> findAll() {
        return jobService.findAll();
    }

    @PostMapping
    public Job create(@RequestBody CreateJobRequest request) {
        return jobService.create(
            request.action(),
            request.targetHost()
        );
    }

    @GetMapping("/{id}")
    public Job findById(@PathVariable Long id) {
        return jobService.findById(id);
    }

    @PostMapping("/{id}/start")
    public Job start(@PathVariable Long id) {
        return jobService.markRunning(id);
    }

    @PostMapping("/{id}/success")
    public Job success(
        @PathVariable Long id,
        @RequestBody JobResultRequest request
    ) {
        return jobService.markSuccess(id, request.output());
    }

    @PostMapping("/{id}/fail")
    public Job fail(
        @PathVariable Long id,
        @RequestBody JobResultRequest request
    ) {
        return jobService.markFailed(id, request.output());
    }
}
