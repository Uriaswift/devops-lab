package com.devopslab.backend.job;

import jakarta.persistence.*;

import java.time.OffsetDateTime;

@Entity
@Table(name = "jobs")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private JobAction action;

    @Column(name = "target_host", nullable = false)
    private String targetHost;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private JobStatus status;

    @Column(name = "started_at", nullable = false)
    private OffsetDateTime startedAt;

    @Column(name = "finished_at")
    private OffsetDateTime finishedAt;

    @Column(columnDefinition = "TEXT")
    private String output;

    protected Job() {
    }

    public Job(JobAction action, String targetHost) {
        this.action = action;
        this.targetHost = targetHost;
        this.status = JobStatus.PENDING;
        this.startedAt = OffsetDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public JobAction getAction() {
        return action;
    }

    public String getTargetHost() {
        return targetHost;
    }

    public JobStatus getStatus() {
        return status;
    }

    public OffsetDateTime getStartedAt() {
        return startedAt;
    }

    public OffsetDateTime getFinishedAt() {
        return finishedAt;
    }

    public String getOutput() {
        return output;
    }

    public void markRunning () {
        this.status = JobStatus.RUNNING;
    }

    public void markSuccess (String output) {
        this.status = JobStatus.SUCCESS;
        this.finishedAt = OffsetDateTime.now();
        this.output = output;
    }

    public void markFailed (String output) {
        this.status = JobStatus.FAILED;
        this.finishedAt = OffsetDateTime.now();
        this.output = output;
    }
}
