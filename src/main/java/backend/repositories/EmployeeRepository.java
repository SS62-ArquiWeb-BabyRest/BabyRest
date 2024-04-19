package backend.repositories;

import backend.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    List<Employee> findByCityOrderByNameDesc(String city);

    List<Employee> findByCityAndName(String city, String name);

    List<Employee> findByNameContaining(String name);

    @Query(value="SELECT * FROM employees WHERE city=?1 AND salary<=?2", nativeQuery = true)
    List<Employee> findByCityAndLowerSalary(String city, Double salary);

    //JPQL Java Persistant Query Language
    @Query(value="SELECT e FROM Employee e WHERE e.city=?1 AND e.salary<=?2 ", nativeQuery = false)
    List<Employee> findByCityAndLowerSalaryJPQL(String city, Double salary);

    List<Employee> findByCityAndSalaryLessThan(String city, Double salary);

    List<Employee> findBySalaryBetween(Double salaryMin, Double salaryMax);

}
