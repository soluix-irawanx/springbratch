package com.soluix.spring.batch.config;

import com.soluix.spring.batch.model.mysql.OldCustomer;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class OldCustomerReaderConfig {

    @Bean
    @StepScope
    public JdbcCursorItemReader<OldCustomer> oldCustomerReader(@Qualifier("mysqlDataSource")DataSource dataSource){
        return new JdbcCursorItemReaderBuilder<OldCustomer>()
                .name("oldCustomerReader")
                .dataSource(dataSource)
                .sql("SELECT id, full_name, email, phone_number FROM old_customers")
                .rowMapper((rs, rowNum)->{
                    try {
                        OldCustomer customer = new OldCustomer();
                        customer.setId(rs.getLong("id"));
                        customer.setFullName(rs.getString("full_name"));
                        customer.setEmail(rs.getString("email"));
                        customer.setPhoneNumber(rs.getString("phone_number"));
                        return customer;
                    }catch (SQLException e){
                        // Menangkap dan mencatat error
                        System.out.println("Error mapping row " + rowNum +" " + e.toString());
                        throw new RuntimeException("Error mapping row: " + rowNum, e);
                    }
                })
                .build();
    }
}
