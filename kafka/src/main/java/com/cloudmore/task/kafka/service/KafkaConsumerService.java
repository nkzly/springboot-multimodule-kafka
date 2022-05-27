package com.cloudmore.task.kafka.service;

import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @Autowired
    private EmployeeService service;

    @KafkaListener(topics = "${kafka.topic}", groupId = "docker_spring")
    public void listen(Employee employee) {
        service.save(employee);
        System.out.println("Message: Name - " + employee.getName() + " | Surname - " + employee.getSurname() + " | Salary - " + employee.getSalary() + " | Eventtime - " + employee.getEventTime());
    }


}
