package com.dansbetest.controllers;

import com.dansbetest.models.Job;
import com.dansbetest.outbounds.JobEndpointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private JobEndpointService jobSvc;

    @Autowired
    public JobController(JobEndpointService jobEndpointService) {
        jobSvc = jobEndpointService;
    }

    @GetMapping("/")
    public List<Job> getJobList() {
        try {
            return jobSvc.getJobs().execute().body();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @GetMapping("/{id}")
    public Job getJobDetail(@PathVariable String id) {
        try {
            return jobSvc.getJobDetail(id).execute().body();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
