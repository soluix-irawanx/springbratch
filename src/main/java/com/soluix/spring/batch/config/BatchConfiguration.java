//package com.soluix.spring.batch.config;
//
//import com.soluix.spring.batch.model.mysql.User;
//import com.soluix.spring.batch.model.postgres.Product;
//import com.soluix.spring.batch.repository.mysql.UserRepository;
//import com.soluix.spring.batch.repository.postgres.ProductRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.StepScope;
//import org.springframework.batch.core.job.builder.JobBuilder;
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.batch.core.repository.JobRepository;
//import org.springframework.batch.core.step.builder.StepBuilder;
//import org.springframework.batch.item.ItemProcessor;
//import org.springframework.batch.item.data.RepositoryItemReader;
//import org.springframework.batch.item.data.RepositoryItemWriter;
//import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
//import org.springframework.batch.item.database.JdbcBatchItemWriter;
//import org.springframework.batch.item.database.JdbcCursorItemReader;
//import org.springframework.batch.item.database.JpaPagingItemReader;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.transaction.PlatformTransactionManager;
//
//import javax.sql.DataSource;
//
//@Configuration
//@EnableBatchProcessing
//@RequiredArgsConstructor
//public class BatchConfiguration {
//
//    private final JobRepository jobRepository;
//
//    @Bean
//    @StepScope
//    public JdbcCursorItemReader<User> reader(
//       DataSource dataSource){
//        JdbcCursorItemReader<User> reader = new JdbcCursorItemReader<>();
//        reader.setDataSource(dataSource);
//        reader.setSql("select * from users");
//        reader.setRowMapper(new BeanPropertyRowMapper<>(User.class));
//        return reader;
//    }
//
////    @Bean
////    public RepositoryItemReader<User> readerRepo(){
////        RepositoryItemReader<User> readerRepo = new RepositoryItemReader<>();
////        readerRepo.setRepository();
////        readerRepo.setMethodName();
////    }
//
//    @Bean
//    public ItemProcessor<User, Product> itemProcessor(){
//        return new ProductProcessor();
//    }
////    @Bean
////    public RepositoryItemWriter<Product> writterRepo(){
////        RepositoryItemWriter<Product> writerRepo = new RepositoryItemWriter<>();
////        writerRepo.setRepository(productRepository);
////        writerRepo.setMethodName("saveAll");
////        return writerRepo;
////
////    }
//
//    @Bean
//    public JdbcBatchItemWriter<Product> writer(
//           DataSource dataSource){
//        JdbcBatchItemWriter<Product> writer = new JdbcBatchItemWriter<>();
//        writer.setDataSource(dataSource);
//        writer.setSql("INSERT INTO products (product_name, product_description) VALUES (:productName, :productDescription)");
//        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
//        return writer;
//    }
//
//    @Bean
//    public Job eltJob(Step step,
//            JdbcBatchItemWriter<Product> writer,
//            @Qualifier("postgresDataSource") JdbcCursorItemReader<User> reader,
//            @Qualifier("postgresTransactionManager") PlatformTransactionManager transactionManager){
//        return new JobBuilder("eltJob", jobRepository)
//                .incrementer(new RunIdIncrementer())
//                .flow(step)
//                .end()
//                .build();
//    }
//
//    @Bean
//    public Step etlStep(@Qualifier("postgresDataSource") JdbcCursorItemReader<User> reader,
//                        JdbcBatchItemWriter<Product> writer,
//                        @Qualifier("postgresTransactionManager") PlatformTransactionManager transactionManager){
//        return new StepBuilder("etlStep", jobRepository)
//                .<User, Product> chunk(100, transactionManager)
//                .reader(reader)
//                .processor(itemProcessor())
//                .writer(writer)
//                .build();
//    }
//}
