package com.cloudmore.task.api.service;

import com.cloudmore.task.model.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface EmployeeService {
    void sendMessageToKafka(Employee employee) throws JsonProcessingException;
    void setTopicName(String topicName);
}
