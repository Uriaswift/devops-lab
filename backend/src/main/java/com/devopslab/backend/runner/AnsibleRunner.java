package com.devopslab.backend.runner;

import com.devopslab.backend.job.JobAction;
import org.springframework.stereotype.Component;

@Component
public class AnsibleRunner implements JobRunner {

    private final AnsibleRunnerProperties properties;

    public AnsibleRunner(
        AnsibleRunnerProperties properties
    ) {
        this.properties = properties;
    }

    @Override
    public RunnerResult run(
        JobAction action,
        String targetHost
    ) {

        AnsiblePlaybook ansiblePlaybook =
            AnsiblePlaybook.fromAction(action);

        if (!properties.isEnabled()) {

            return new RunnerResult(
                true,
                "SIMULATION: ansible-playbook "
                    + ansiblePlaybook.getPlaybook()
                    + " --limit "
                    + targetHost
            );
        }

        throw new UnsupportedOperationException(
            "Real Ansible execution is not configured yet"
        );
    }
}
