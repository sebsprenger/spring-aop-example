package de.sebsprenger.aop.infrastructure;

import org.springframework.stereotype.Component;

@Component
public class MetricPublisher {

    public void push(String metricName, long value) {
        System.out.println("store(" + metricName + ", " + value + ")");
    }

}
