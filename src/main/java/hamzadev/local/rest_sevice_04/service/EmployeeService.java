package hamzadev.local.rest_sevice_04.service;

import hamzadev.local.rest_sevice_04.entity.Employee;

import java.util.List;

public interface EmployeeService {

    //get all employees
    List<Employee> findAll();
}
