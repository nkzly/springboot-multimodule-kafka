package com.cloudmore.task.kafka.repository;

import com.cloudmore.task.kafka.data.EmployeeData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeData, Long> {
}
