package com.cloudmore.task.api.controller;

import com.cloudmore.task.api.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
@Api(value = "RestApi Controller")
public class ApiController {
    @Autowired
    private EmployeeService employeeService;


    @PostMapping(value = "/save")
    @ApiOperation(value = "send To Kafka")
    public HttpStatus save(@RequestBody Employee employee) {
        try {
            employeeService.sendMessageToKafka(employee);
            return HttpStatus.OK;
        } catch (Exception e) {
            System.out.println(e);
            return HttpStatus.BAD_REQUEST;
        }
    }
}
