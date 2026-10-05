package com.devopslab.backend.job;

public record CreateJobRequest(
    JobAction action,
    String targetHost
) {
}
