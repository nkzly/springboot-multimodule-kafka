package com.cloudmore.task.kafka.service;

import com.cloudmore.task.kafka.converter.EmployeeConverter;
import com.cloudmore.task.kafka.repository.EmployeeRepository;
import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    public void save(Employee employee) {
        repository.save(EmployeeConverter.dataConverter(employee));
    }

}
