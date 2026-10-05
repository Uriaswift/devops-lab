package com.devopslab.backend.runner;

import com.devopslab.backend.job.JobAction;

public interface JobRunner {

    RunnerResult run(
        JobAction action,
        String targetHost
    );
}
