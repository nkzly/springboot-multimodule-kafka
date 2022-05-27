package com.cloudmore.task.kafka.converter;

import com.cloudmore.task.kafka.data.EmployeeData;
import com.cloudmore.task.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeConverterTest {

    private EmployeeConverter converter;
    @BeforeEach
    public void setup() {
        converter = new EmployeeConverter();
    }
    @Test
    void dataConverter() {
        Employee employee = new Employee();
        employee.setSalary(BigDecimal.TEN);
        employee.setName("Nihat");
        employee.setSurname("Kızılay");
        employee.setEventTime(LocalDateTime.MIN);
        EmployeeData employeeData = converter.dataConverter(employee);

        assertEquals(employeeData.getName(), "Nihat");
        assertEquals(employeeData.getSurname(), "Kızılay");
        assertEquals(employeeData.getSalary(), BigDecimal.TEN);
        assertEquals(employeeData.getEventTime(), LocalDateTime.MIN);
    }
}