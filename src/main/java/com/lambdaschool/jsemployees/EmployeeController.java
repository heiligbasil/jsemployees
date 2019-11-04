package com.lambdaschool.jsemployees;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

// Java Spring Bean
@RestController
@RequestMapping("/data")
public class EmployeeController
{
    // localhost:2019/data/allemployees
    // list of all employees sorted by first name
    @GetMapping(value = "/allemployees",
            produces = {"application/json"})
    public ResponseEntity<?> getAllEmployees()
    {
        JsEmployeesApplication.ourEmpList.empList.sort((e1, e2) -> e1.getFname().compareToIgnoreCase(e2.getFname()));
        return new ResponseEntity<>(JsEmployeesApplication.ourEmpList.empList, HttpStatus.OK);
    }

    // localhost:2019/data/employee/2
    @GetMapping(value = "/employee/{empid}",
            produces = {"application/json"})
    public ResponseEntity<?> getEmpDetail(
            @PathVariable
                    long empid)
    {
        Employee rtnEmp = JsEmployeesApplication.ourEmpList.findEmployee(e -> (e.getId() == empid));
        return new ResponseEntity<>(rtnEmp, HttpStatus.OK);
    }

    // first name starts with s sorted by salary
    // localhost:2019/data/employees/s
    @GetMapping (value = "/employees/{letter}",
            produces = {"application/json"})
    public ResponseEntity<?> getSortedEmployees(@PathVariable char letter)
    {
        ArrayList<Employee> rtnEmps = JsEmployeesApplication.ourEmpList
                .findEmployees(e -> e.getFname().toUpperCase().charAt(0) == Character.toUpperCase(letter));
        rtnEmps.sort((e1, e2) -> ((int) (e2.getSalary() - e1.getSalary())));
        return new ResponseEntity<>(rtnEmps, HttpStatus.OK);
    }
}