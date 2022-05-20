package com.portfolio.loadcsv.controllers;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job job;

    @PostMapping("/car-parts")
    public ResponseEntity<?> importCsv() {

        Map<String, JobParameter> maps = new HashMap<>();
        maps.put("time", new JobParameter(System.currentTimeMillis()));
        JobParameters parameters = new JobParameters(maps);
        JobExecution jobExecution = null;

        try {
            jobExecution = jobLauncher.run(job, parameters);
        } catch (JobExecutionAlreadyRunningException | JobParametersInvalidException e) {
            e.printStackTrace();
        } catch (JobRestartException e) {
            e.printStackTrace();
        } catch (JobInstanceAlreadyCompleteException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }

        List<StepExecution> list;
        list = getExecutionInfo( jobExecution );
        return ResponseEntity.ok(
                "Status: " + jobExecution.getStatus() +
                " Job: " + jobExecution.getJobId() +
                " Total Read: " + list.get(0).getReadCount() );
    }

    private List<StepExecution> getExecutionInfo(JobExecution jobExecution){
        List<StepExecution> list = new ArrayList<>();
        for ( StepExecution stepExecution : jobExecution.getStepExecutions()) {
            list.add( stepExecution );
        }
        return list;
    }
}
