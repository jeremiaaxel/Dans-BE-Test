package com.dansbetest.outbounds;

import com.dansbetest.models.Job;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

@Service
public interface JobEndpointService {
    @GET("/api/recruitment/positions.json")
    Call<List<Job>> getJobs();

    @GET("/api/recruitment/positions/{id}")
    Call<Job> getJobDetail(@Path("id") String id);
}
