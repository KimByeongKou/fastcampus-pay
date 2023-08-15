package com.fastcampus.loggingconsumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.mockito.Mockito.*;

@SpringBootTest
@Execution(ExecutionMode.SAME_THREAD) // 순차 실행
public class TestLoggingHandler {
    @InjectMocks
    private LoggingHandler loggingHandler;
    @Mock
    private KafkaConsumer<String, String> loggingConsumer;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        loggingHandler = new LoggingHandler(loggingConsumer);
    }
    private static Stream<String> provideStringForConsumer() {
        return Stream.of(
                new String("[log] hello world"),
                new String("[logging] hello world")
        );
    }
    @ParameterizedTest
    @MethodSource("provideStringForConsumer")
    public void testConsumeMessages(String arg) {
        // 모킹된 Kafka 컨슈머의 동작 설정
        when(loggingConsumer.poll(any(Duration.class))).thenReturn(createMockRecordsFromString(arg));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        loggingHandler.consume();
        verify(loggingConsumer, atLeastOnce()).poll(any(Duration.class));
    }

    private ConsumerRecords<String, String> createMockRecordsFromString(String value) {
        List list = new ArrayList<>();
        ConsumerRecord<String, String> dummyRecord
                = new ConsumerRecord<>("test", 0, 0, "key", value);
        list.add(dummyRecord);

        Map<TopicPartition, List<ConsumerRecord<String, String>>> map
                = new HashMap<>();
        map.put(new TopicPartition("test", 0), list);
        return new ConsumerRecords<>(map);
    }
}
