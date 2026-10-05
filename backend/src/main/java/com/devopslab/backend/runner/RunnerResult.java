package com.devopslab.backend.runner;

public record RunnerResult(
    boolean success,
    String output
) {
}
