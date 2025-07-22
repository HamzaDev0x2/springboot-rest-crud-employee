package hamzadev.local.rest_sevice_04.dao;

import hamzadev.local.rest_sevice_04.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="members")
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    // thats it ... no need to write any code for basic crud methods
}
