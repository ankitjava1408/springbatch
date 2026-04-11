package com.ankitjava.springbatch.controller;

import org.springframework.batch.core.job.Job;
import org.springframework.batch.core.job.parameters.JobParameters;
import org.springframework.batch.core.job.parameters.JobParametersBuilder;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private final JobOperator jobOperator;
    private final Job runJob;

    public JobController(JobOperator jobOperator,
                         @Qualifier("runJob") Job runJob) {
        this.jobOperator = jobOperator;
        this.runJob = runJob;
    }

    @PostMapping("/importCustomers")
    public String importCsvToDBJob() {
        try {
            JobParameters jobParameters = new JobParametersBuilder()
                    .addLong("startAt", System.currentTimeMillis())
                    .toJobParameters();

            var jobExecution = jobOperator.start(runJob, jobParameters);

            return "Job started successfully. Execution Id: " + jobExecution.getId();
        } catch (Exception e) {
            return "Job failed: " + e.getMessage();
        }
    }
}