package com.cloudmore.task.kafka.data;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table
public class EmployeeData {
    @Id
    @GenericGenerator(
            name = "id-sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "user_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1000"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @GeneratedValue(generator = "id-sequence-generator")
    @Column
    private Long employeeId;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private BigDecimal salary;
    @Column
    private LocalDateTime eventTime;

    public EmployeeData(String name, String surname, BigDecimal salary, LocalDateTime eventTime) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.eventTime = eventTime;
    }

    public EmployeeData() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeData employeeData = (EmployeeData) o;
        return Objects.equals(employeeId, employeeData.employeeId) && Objects.equals(name, employeeData.name) && Objects.equals(surname, employeeData.surname);
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public LocalDateTime getEventTime() {
        return eventTime;
    }

    public void setEventTime(LocalDateTime eventTime) {
        this.eventTime = eventTime;
    }
}
