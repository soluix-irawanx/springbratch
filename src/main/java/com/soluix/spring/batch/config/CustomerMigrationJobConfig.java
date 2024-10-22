package com.soluix.spring.batch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerMigrationJobConfig {
    @Bean
    public Job customerMigrationJob(JobRepository jobRepository, Step customerMigrationStep){
        return new JobBuilder("customerMigrationJob",jobRepository)
                .start(customerMigrationStep)
                .build();
    }
}
