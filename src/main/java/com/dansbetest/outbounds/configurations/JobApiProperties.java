package com.dansbetest.outbounds.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "job")
public class JobApiProperties extends OutboundProperties {
}
