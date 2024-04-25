package backend.project.repositories;

import backend.project.entities.EmployeeProject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeProjectRepository extends JpaRepository<EmployeeProject, Long> {

    List<EmployeeProject> findByEmployee_Id(Long id);
    List<EmployeeProject> findByProject_Id(Long id);


}
