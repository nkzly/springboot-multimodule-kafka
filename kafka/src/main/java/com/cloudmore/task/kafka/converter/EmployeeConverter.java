package com.cloudmore.task.kafka.converter;

import com.cloudmore.task.kafka.data.EmployeeData;
import com.cloudmore.task.model.Employee;

public class EmployeeConverter {

    public static EmployeeData dataConverter(Employee employee) {
        EmployeeData employeeData = new EmployeeData();

        employeeData.setName(employee.getName());
        employeeData.setSurname(employee.getSurname());
        employeeData.setSalary(employee.getSalary());
        employeeData.setEventTime(employee.getEventTime());

        return employeeData;
    }
}
