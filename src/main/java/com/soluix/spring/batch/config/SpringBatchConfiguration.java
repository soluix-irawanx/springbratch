package com.soluix.spring.batch.config;

import com.soluix.spring.batch.dto.EmployeeDto;
import com.soluix.spring.batch.entity.Employee;
import com.soluix.spring.batch.repository.EmployeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class SpringBatchConfiguration {

    private JobRepository jobRepository;
    private PlatformTransactionManager platformTransactionManager;
    private DataSource dataSource;

    @Bean
    @StepScope
    public FlatFileItemReader<EmployeeDto> reader(
            @Value("#{jobParameters['inputFilePath']}")
            FileSystemResource fileSystemResource){
        return new FlatFileItemReaderBuilder<EmployeeDto>()
                .name("employeeItemReader")
                .linesToSkip(1)
                .resource(fileSystemResource)
                .delimited()
                .names("employeeId", "fullName", "jobTitle", "department",
                        "businessUnit", "gender", "ethnicity", "age")
                .targetType(EmployeeDto.class)
                .build();
    }

    @Bean
    public ItemProcessor<EmployeeDto, Employee> itemProcessor(){
        return new EmployeeProcessor();
    }

    @Bean
    public EmployeeWriter employeeWriter(final EmployeRepository employeRepository){
        return new EmployeeWriter(employeRepository);
    }

    @Bean
    public Step importEmployeeStep(final JobRepository repository,
                                   final PlatformTransactionManager platformTransactionManager,
                                   final EmployeRepository employeRepository){
        return new StepBuilder("importEmployeesStep",repository)
                .<EmployeeDto, Employee>chunk(100, platformTransactionManager)
                .reader(reader(null))
                .processor(itemProcessor())
                .writer(employeeWriter(employeRepository))
                .build();
    }

    @Bean
    public Job importEmployeeJob(final JobRepository repository,
                                 final PlatformTransactionManager transactionManager,
                                 final EmployeRepository employeRepository){
        return new JobBuilder("job", repository)
                .incrementer(new RunIdIncrementer())
                .start(importEmployeeStep(repository, transactionManager, employeRepository))
                .build();
    }
}
