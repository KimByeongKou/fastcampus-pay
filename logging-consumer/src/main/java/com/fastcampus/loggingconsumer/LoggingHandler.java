package com.fastcampus.loggingconsumer;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
@RequiredArgsConstructor
public class LoggingHandler {
    private final KafkaConsumer<String, String> loggingConsumer;
    public void consume() {
        Thread consumerThread = new Thread(() -> {
            try {
                while (true) {
                    ConsumerRecords<String, String> records = loggingConsumer.poll(Duration.ofMillis(100));
                    for (ConsumerRecord<String, String> record : records) {
                        handle(record);
                    }
                }
            } finally {
                loggingConsumer.close();
            }
        });
        consumerThread.start();
    }

    private void handle(ConsumerRecord<String, String> record) {
        if (!record.value().startsWith("[logging]")){
            return;
        }
        System.out.println("Received message: " + record.value());
    }
}
