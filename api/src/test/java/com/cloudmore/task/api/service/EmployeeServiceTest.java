package com.cloudmore.task.api.service;

import com.cloudmore.task.model.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.SettableListenableFuture;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class EmployeeServiceTest {
    private EmployeeService service;
    private KafkaTemplate<String, Employee> template;

    @BeforeEach
    public void setup() {
        template = mock(KafkaTemplate.class);
        service = new EmployeeServiceImpl(template);
        service.setTopicName("");

    }

    @Test
    void createAccount() throws JsonProcessingException {
        Employee employee = new Employee();
        employee.setSalary(BigDecimal.TEN);
        employee.setName("Nihat");
        employee.setSurname("Kızılay");
        employee.setEventTime(LocalDateTime.MIN);

        ListenableFuture<SendResult<String, Employee>> future = new SettableListenableFuture<>();

        when(template.send(anyString(),any(Employee.class))).thenReturn(future);
        service.sendMessageToKafka(employee);
    }


}