package backend.project.services;

import backend.project.entities.Employee;
import backend.project.entities.EmployeeProject;


import java.util.List;

public interface EmployeeProjectService {

    public List<EmployeeProject> listAll();
    public List<EmployeeProject>  findByEmployee_Id(Long id);
    public List<EmployeeProject>  findByProject_Id(Long id);

    EmployeeProject findById(Long id);
    public List<Employee>  findEmployees_ByProject_Id(Long id);

    public void delete(Long id);
    public EmployeeProject save(EmployeeProject employeeProject);
}
