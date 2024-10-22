package com.soluix.spring.batch.config;

import com.soluix.spring.batch.model.mysql.OldCustomer;
import com.soluix.spring.batch.model.postgres.NewCustomer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerProsessorConfig {
    @Bean
    public ItemProcessor<OldCustomer, NewCustomer> customerProcessor(){
        return oldCustomer -> {
            NewCustomer newCustomer = new NewCustomer();
            newCustomer.setId(oldCustomer.getId()+1);

            String[] nameParts =oldCustomer.getFullName().split(" ",2);
            newCustomer.setFirstName(nameParts[0]);
            newCustomer.setLastName(nameParts.length >1 ? nameParts[1] : "");

            newCustomer.setEmail(oldCustomer.getEmail());
            newCustomer.setMobileNumber("+62-"+oldCustomer.getPhoneNumber());
            return newCustomer;
        };
    }
}
