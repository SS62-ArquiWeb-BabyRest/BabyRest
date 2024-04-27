package backend.repositories;
import backend.entities.Employee;
import backend.entities.EmployeeProject;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EmployeeProjectRepository extends JpaRepository<EmployeeProject, Long> {

    List<EmployeeProject> findByEmployee_Id(Long id);
    List<EmployeeProject> findByProject_Id(Long id);


}
