package com.cloudmore.task.kafka.service;

import com.cloudmore.task.kafka.data.EmployeeData;
import com.cloudmore.task.kafka.repository.EmployeeRepository;
import com.cloudmore.task.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class KafkaConsumerServiceImplTest {


    private KafkaConsumerService service;
    private EmployeeRepository repository;

    @BeforeEach
    public void setup() {
        repository = mock(EmployeeRepository.class);
        service = new KafkaConsumerServiceImpl(repository);

    }

    @Test
    void listenKafka() {
        EmployeeData employeeData = new EmployeeData();
        employeeData.setSalary(BigDecimal.TEN);
        employeeData.setName("Nihat");
        employeeData.setSurname("Kızılay");
        employeeData.setEventTime(LocalDateTime.MIN);


        Employee employee = new Employee();
        employee.setSalary(BigDecimal.TEN);
        employee.setName("Nihat");
        employee.setSurname("Kızılay");
        employee.setEventTime(LocalDateTime.MIN);

        when(repository.save(employeeData)).thenReturn(employeeData);
        service.listenKafka(employee);
    }
}