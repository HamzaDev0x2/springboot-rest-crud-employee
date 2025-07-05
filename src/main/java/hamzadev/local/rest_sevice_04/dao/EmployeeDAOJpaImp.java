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
}
