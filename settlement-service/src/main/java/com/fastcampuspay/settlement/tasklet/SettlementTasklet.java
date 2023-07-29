package com.fastcampuspay.settlement.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Component
public class SettlementTasklet implements  Tasklet{
    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext){


        System.out.println("Tasklet Execute!: "
                + chunkContext.getStepContext()
                .getStepExecution()
                .getJobParameters()
                .getLong("time"));
        return RepeatStatus.FINISHED;
    }
}
