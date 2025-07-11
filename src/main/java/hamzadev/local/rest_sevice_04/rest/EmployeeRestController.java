package hamzadev.local.rest_sevice_04.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import hamzadev.local.rest_sevice_04.entity.Employee;
import hamzadev.local.rest_sevice_04.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    //inject employee service and the helper class (objectMapper)
    private final EmployeeService employeeService;
    private final ObjectMapper objectMapper; //its auto-configured by Spring Boot, so that allows us to easly inject it in our restController

    @Autowired
    public EmployeeRestController(EmployeeService employeeService, ObjectMapper objectMapper) {
        this.employeeService = employeeService;
        this.objectMapper = objectMapper;
    }

    //expose "/employees" and return list of employees
    @GetMapping("/employees")
    public List<Employee> findAll()
    {
        return employeeService.findAll();
    }

    //expose /employees/{id}
    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable long employeeId)
    {
        Employee employee = employeeService.findById(employeeId);
        if(employee == null)
            throw new EmployeeNotFoundException("Employee with id: " + employeeId + " not found");
        return employee;
    }

    //add mapping for POST /employees add new employees
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee)
    {
        //in case the client pass an id JSON ... set id to 0
        //this force merge method to add a new item instead of update
        employee.setId(0L);
        return employeeService.save(employee);
    }

    //add mapping for PUT /employees update existing employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee)
    {
        if(employeeService.findById(employee.getId()) == null)
            throw new EmployeeNotFoundException("Employee with id: " + employee.getId() + " not found");
        return employeeService.save(employee);
    }

    //add mapping for PATCH /employees/{emplyeeId} - patch employee ... partial update
    @PatchMapping("/employees/{employeeId}")
    public Employee patchEmployee(@PathVariable long employeeId,
                                  @RequestBody Map<String,Object> patchPayload)
    {
        Employee tempEmployee = employeeService.findById(employeeId);

        // throw exception if employee not found in database
        if(tempEmployee == null)
            throw new EmployeeNotFoundException("Employee with id: " + employeeId + " not found");
        // throw exception if patch payload (request body updates) contains id

        if(patchPayload.containsKey("id"))
            throw new RuntimeException("Invalid Payload : employee id not allowd");

        //apply the partial patch updates method defined in next step
        Employee patchedEmployee=apply(patchPayload,tempEmployee);

        //save the new updated employee in database and return results as JSON
        return employeeService.save(patchedEmployee);
    }

    //implement apply method used in patch mapping
    private Employee apply(Map<String, Object> patchPayload, Employee tempEmployee) {

        //convert employee object comming from db to a JSON object node
        ObjectNode employeeJsonNode = objectMapper.convertValue(tempEmployee,ObjectNode.class);

        //convert patchPayload map comming from http patch request to a json node
        ObjectNode patchJsonNode = objectMapper.convertValue(patchPayload,ObjectNode.class);

        //merge the patch updates into employee object node
        employeeJsonNode.setAll(patchJsonNode);

        //convert the new updated employee object node to employee object and return it
        return objectMapper.convertValue(employeeJsonNode,Employee.class);
    }

    //add mapping for DELETE /employees/{idEmployee} - delete an existing employee
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable long employeeId)
    {

        Employee employeeToDelete = employeeService.findById(employeeId);

        //check if employee doesnt exist in db ,throw eexception
        if(employeeToDelete == null)
            throw new EmployeeNotFoundException("Employee with id: " + employeeId + " not found");

        //delete the emplyee from db and return string message
        employeeService.delete(employeeId);
        return "Employee with id: " + employeeId + " deleted";
    }
}
