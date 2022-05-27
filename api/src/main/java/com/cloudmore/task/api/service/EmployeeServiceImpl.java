package com.cloudmore.task.api.service;


import com.cloudmore.task.api.config.EnvironmentConfig;
import com.cloudmore.task.model.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.math.BigDecimal;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    @Value(value = "${kafka.topic}")
    private String topicName;
    private final KafkaTemplate<String, Employee> kafkaTemplate;

    public EmployeeServiceImpl(KafkaTemplate<String, Employee> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendMessageToKafka(Employee employee) throws JsonProcessingException {
        sendMessage(topicName,employee);
    }

    public void sendMessage(String topicName, Employee message) {
        calculateTaxForSalary(message);

        ListenableFuture<SendResult<String, Employee>> future =
                kafkaTemplate.send(topicName, message);

        future.addCallback(new ListenableFutureCallback<SendResult<String, Employee>>() {

            @Override
            public void onSuccess(SendResult<String, Employee> result) {
                System.out.println("Success");
            }

            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Error");
            }
        });
    }

    private void calculateTaxForSalary(Employee request) {
        BigDecimal salary= request.getSalary();
        salary=salary.multiply(EnvironmentConfig.taxRate == null ? BigDecimal.ONE : new BigDecimal(EnvironmentConfig.taxRate)).add(salary);
        request.setSalary(salary);
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }
}
