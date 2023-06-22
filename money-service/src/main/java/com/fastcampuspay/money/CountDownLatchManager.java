package com.fastcampuspay.money;

import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

@Configuration
public class CountDownLatchManager {
    private final Map<String, CountDownLatch> countDownLatchMap;

    public CountDownLatchManager() {
        this.countDownLatchMap = new HashMap<>();
    }

    public void addCountDownLatch(String key) {
        this.countDownLatchMap.put(key, new CountDownLatch(1));
    }

    public CountDownLatch getCountDownLatch(String key) {
        return this.countDownLatchMap.get(key);
    }
}
