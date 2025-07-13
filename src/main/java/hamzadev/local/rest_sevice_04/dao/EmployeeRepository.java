package hamzadev.local.rest_sevice_04.dao;

import hamzadev.local.rest_sevice_04.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    // thats it ... no need to write any code for basic crud methods
}
