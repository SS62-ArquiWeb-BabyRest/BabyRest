package backend.services;

//import backend.entities.Employee;
import backend.entities.EmployeeProject;
import backend.entities.NineraUniversitario;


import java.util.List;

public interface EmployeeProjectService {

    public List<EmployeeProject> listAll();
    public List<EmployeeProject>  findByEmployee_Id(Long id);
    public List<EmployeeProject>  findByProject_Id(Long id);

    EmployeeProject findById(Long id);
    public List<NineraUniversitario>  findEmployees_ByProject_Id(Long id);

    public void delete(Long id);
    public EmployeeProject save(EmployeeProject employeeProject);
}
