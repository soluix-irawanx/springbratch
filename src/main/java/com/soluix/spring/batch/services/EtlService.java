//package com.soluix.spring.batch.services;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.JobParameter;
//import org.springframework.batch.core.JobParameters;
//import org.springframework.batch.core.JobParametersBuilder;
//import org.springframework.batch.core.launch.JobLauncher;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//
//@Component
//@RequiredArgsConstructor
//public class EtlService {
//
//    private final JobLauncher jobLauncher;
//    private final Job eltJob;
//
//    @Scheduled(fixedRate = 5000) // runs 5 second
//    public void runUserUpadateJob() {
//        try {
//            JobParameters jobParameters = new JobParametersBuilder()
//                    .addLong("timee", System.currentTimeMillis())
//                    .toJobParameters();
//            jobLauncher.run(eltJob, jobParameters);
//        }catch (Exception e){
//            System.err.println("Error executing ETL job: " + e.getMessage());
//        }
//    }
//}
