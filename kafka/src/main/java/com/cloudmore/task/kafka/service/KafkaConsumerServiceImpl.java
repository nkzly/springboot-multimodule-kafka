package com.cloudmore.task.kafka.service;

import com.cloudmore.task.kafka.converter.EmployeeConverter;
import com.cloudmore.task.kafka.repository.EmployeeRepository;
import com.cloudmore.task.model.Employee;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerServiceImpl implements KafkaConsumerService {

    private EmployeeRepository repository;

    public KafkaConsumerServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @KafkaListener(topics = "${kafka.topic}", groupId = "docker_spring")
    public void listen(Employee employee) {
        repository.save(EmployeeConverter.dataConverter(employee));
        System.out.println("Message: Name - " + employee.getName() + " | Surname - " + employee.getSurname() + " | Salary - " + employee.getSalary() + " | Eventtime - " + employee.getEventTime());
    }


    @Override
    public void listenKafka(Employee employee) {
        listen(employee);
    }
}
