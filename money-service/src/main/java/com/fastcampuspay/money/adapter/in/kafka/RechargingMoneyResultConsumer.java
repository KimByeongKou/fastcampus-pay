package com.fastcampuspay.money.adapter.in.kafka;

import com.fastcampuspay.money.CountDownLatchManager;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

@Component
public class RechargingMoneyResultConsumer {
    private final KafkaConsumer<String, String> consumer;

    @NotNull
    private final CountDownLatchManager countDownLatchManager;
    public RechargingMoneyResultConsumer(@Value("${kafka.clusters.bootstrapservers}") String bootstrapServers,
                           @Value("${task.topic}")String topic, CountDownLatchManager countDownLatchManager) {
        this.countDownLatchManager = countDownLatchManager;
        Properties props = new Properties();
        props.put("bootstrap.servers", bootstrapServers);
        props.put("group.id", "my-group");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        this.consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Collections.singletonList(topic));

        Thread consumerThread = new Thread(() -> {
            try {
                while (true) {
                    ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(1));
                    for (ConsumerRecord<String, String> record : records) {
                        System.out.println("Received message: " + record.value());
                        this.countDownLatchManager.getCountDownLatch("rechargingMoneyTask").countDown();
                    }
                }
            } finally {
                consumer.close();
            }
        });
        consumerThread.start();
    }
}