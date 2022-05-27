package com.cloudmore.task.kafka.service;

import com.cloudmore.task.model.Employee;

public interface KafkaConsumerService {
    void listenKafka(Employee employee);
}
