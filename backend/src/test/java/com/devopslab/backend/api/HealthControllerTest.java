package com.devopslab.backend.api;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HealthControllerTest {

    private final HealthController controller = new HealthController();

    @Test
    void shouldReturnUpStatus() {
        var response = controller.health();

        assertThat(response.get("status")).isEqualTo("UP");

        assertThat(response.get("service")).isEqualTo("devops-lab-backend");

    }
}
