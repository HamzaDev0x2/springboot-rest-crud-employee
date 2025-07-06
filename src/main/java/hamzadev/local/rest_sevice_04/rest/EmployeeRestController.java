package hamzadev.local.rest_sevice_04.rest;

import hamzadev.local.rest_sevice_04.dao.EmployeeDAO;
import hamzadev.local.rest_sevice_04.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    //quick and dirty: inject employee dao
    private EmployeeDAO employeeDAO;
    public EmployeeRestController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    //expose "/employees" and return list of employees
    @GetMapping("/employees")
    public List<Employee> findAll()
    {
        return employeeDAO.findAll();
    }
}
