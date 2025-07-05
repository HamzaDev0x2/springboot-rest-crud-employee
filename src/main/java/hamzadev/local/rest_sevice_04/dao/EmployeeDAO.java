package hamzadev.local.rest_sevice_04.dao;

import hamzadev.local.rest_sevice_04.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    //find all employees
    public List<Employee> findAll();
}
