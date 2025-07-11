package hamzadev.local.rest_sevice_04.service;

import hamzadev.local.rest_sevice_04.entity.Employee;

import java.util.List;

public interface EmployeeService {

    //get all employees
    List<Employee> findAll();

    //find employee by id
    Employee findById(long id);

    //add or update employee
    Employee save(Employee employee);

    //delete employee by id
    void delete(long id);
}
