package com.fastcampuspay.settlement.scheduler;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class SettlementBatchScheduler {
    private final JobLauncher jobLauncher;
    private final Job settlementJob;

    @Scheduled(fixedRate = 1000)
    public void runSettlementJob() throws Exception {
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("time", System.currentTimeMillis())
                .toJobParameters();
        jobLauncher.run(settlementJob, jobParameters);
    }


}
