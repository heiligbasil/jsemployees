package com.lambdaschool.jsemployees;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JsEmployeesApplication
{
    static EmpList ourEmpList;

    public static void main(String[] args)
    {
        ourEmpList = new EmpList();

        SpringApplication.run(JsEmployeesApplication.class, args);
    }

}