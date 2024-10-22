package com.soluix.spring.batch.config;

import com.soluix.spring.batch.model.mysql.OldCustomer;
import com.soluix.spring.batch.model.postgres.NewCustomer;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class CustomerMigrationStepConfig {
    @Bean
    public Step customerMigrationStep(
            JobRepository jobRepository,
            @Qualifier("postgresTransactionManager")PlatformTransactionManager transactionManager,
            ItemReader<OldCustomer> oldCustomerReader,
            ItemProcessor<OldCustomer, NewCustomer> customerProcessor,
            ItemWriter<NewCustomer> newCustomerItemWriter ){
        return new StepBuilder("customerMigrationStep", jobRepository)
                .<OldCustomer, NewCustomer>chunk(100, transactionManager)
                .reader(oldCustomerReader)
                .processor(customerProcessor)
                .writer(newCustomerItemWriter)
                .faultTolerant()
                .skip(RuntimeException.class)
                .skipLimit(10)
                .build();
    }
}
