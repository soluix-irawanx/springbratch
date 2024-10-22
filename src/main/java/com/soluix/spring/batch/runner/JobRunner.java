//package com.soluix.spring.batch.runner;
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.JobParameters;
//import org.springframework.batch.core.JobParametersBuilder;
//import org.springframework.batch.core.launch.JobLauncher;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.scheduling.annotation.EnableAsync;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.text.SimpleDateFormat;
//import java.util.UUID;
//@EnableAsync
//@Component
//public class JobRunner {
//
//    @Autowired
//    private JobLauncher jobLauncher;
//
//    @Autowired
//    private Job customerMigrationJob;
//
//    @Async
//    @Scheduled(fixedRate = 5000)
//    public void runJob() {
//        try {
//            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            JobParameters jobParameters = new JobParametersBuilder()
//                    .addLong("jobId", System.currentTimeMillis())
//                    .toJobParameters();
//            jobLauncher.run(customerMigrationJob, jobParameters);
//            System.out.println("Task executed at "+fmt.format(System.currentTimeMillis()));
//            Thread.sleep(10000);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
