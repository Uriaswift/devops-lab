package com.devopslab.backend.runner;

import com.devopslab.backend.job.JobAction;

public enum AnsiblePlaybook {

    INSTALL_NGINX(
        JobAction.INSTALL_NGINX,
        "playbooks/nginx.yml"
    ),

    REMOVE_NGINX(
        JobAction.REMOVE_NGINX,
        "playbooks/nginx-remove.yml"
    ),

    CHECK_NGINX_STATUS(
        JobAction.CHECK_NGINX_STATUS,
        "playbooks/nginx-status.yml"
    );

    private final JobAction action;
    private final String playbook;

    AnsiblePlaybook(
        JobAction action,
        String playbook
    ) {
        this.action = action;
        this.playbook = playbook;
    }

    public JobAction getAction() {
        return action;
    }

    public String getPlaybook() {
        return playbook;
    }

    public static AnsiblePlaybook fromAction(JobAction action) {

        for (AnsiblePlaybook value : values()) {

            if (value.action == action) {
                return value;
            }
        }

        throw new IllegalArgumentException(
            "Unsupported Ansible action: " + action
        );
    }
}
