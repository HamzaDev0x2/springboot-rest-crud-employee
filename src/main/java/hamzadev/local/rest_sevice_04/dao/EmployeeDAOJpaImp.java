package hamzadev.local.rest_sevice_04.dao;

import hamzadev.local.rest_sevice_04.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImp implements EmployeeDAO {

    //Define entity manager field
    private final EntityManager entityManager;

    //inject entity manager in constructor
    @Autowired
    public EmployeeDAOJpaImp(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    //implement findAll() method
    @Override
    public List<Employee> findAll() {
        //create the jpql query
        TypedQuery<Employee> theQuery=entityManager.createQuery("SELECT e from Employee e",Employee.class);
        //execute the query and return the result
        return theQuery.getResultList();
    }

    //implement findById(long) method
    @Override
    public Employee findById(long id) {
        //get employee by id
        Employee employee=entityManager.find(Employee.class,id);
        //return employee
        return employee;
    }

    //implement save(Employee) method
    @Override
    public Employee save(Employee employee) {
        //insert or update employee based on id (if id == 0 => insert, else => update)
        Employee gettedEmployee=entityManager.merge(employee);
        //return getted employee (in case of insert , the getted employee has an updated id
        return gettedEmployee;
    }

    //implement delete(long) method
    @Override
    public void delete(long id) {
        //find employee by id
        Employee employee=entityManager.find(Employee.class,id);
        //delete employee
        entityManager.remove(employee);
    }
}
