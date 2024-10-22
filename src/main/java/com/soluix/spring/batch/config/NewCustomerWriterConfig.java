package com.soluix.spring.batch.config;

import com.soluix.spring.batch.model.postgres.NewCustomer;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class NewCustomerWriterConfig {

    @Bean
    public JdbcBatchItemWriter<NewCustomer> newCustomerWriter(@Qualifier("postgresDataSource") DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<NewCustomer>()
                .dataSource(dataSource)
                .sql("INSERT INTO new_customers (id, first_name, last_name, email, mobile_number) " +
                        "VALUES (:id, :firstName, :lastName, :email, :mobileNumber)")
                .beanMapped()
                .build();
    }
}