package com.cloudmore.task.api.controller;

import com.cloudmore.task.api.service.EmployeeService;
import com.cloudmore.task.model.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
@Api(value = "RestApi Controller")
public class ApiController {

    private final EmployeeService service;

    public ApiController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping(value = "/sendMessageToKafka")
    @ApiOperation(value = "send To Kafka")
    public HttpStatus sendMessageToKafka(@RequestBody Employee employee) {
        try {
            service.sendMessageToKafka(employee);
            return HttpStatus.OK;
        } catch (Exception e) {
            System.out.println(e);
            return HttpStatus.BAD_REQUEST;
        }
    }
}
