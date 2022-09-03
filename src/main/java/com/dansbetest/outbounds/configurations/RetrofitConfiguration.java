package com.dansbetest.outbounds.configurations;

import com.dansbetest.outbounds.JobEndpointService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Configuration
public class RetrofitConfiguration {

    @Bean
    public Retrofit retrofitJobEndpointService(JobApiProperties jobApiProperties) {
        return getRetrofit(jobApiProperties);
    }

    @Bean
    public JobEndpointService jobEndpointService(@Qualifier(value = "retrofitJobEndpointService") Retrofit retrofitGitHub) {
        return retrofitGitHub.create(JobEndpointService.class);
    }

    private Retrofit getRetrofit(OutboundProperties outboundProperties) {
        return new Retrofit.Builder()
                .baseUrl(outboundProperties.getHost())
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

}
