package backend.servicesimpl;

import backend.entities.Employee;
import backend.entities.EmployeeProject;
import backend.entities.Project;
import backend.exceptions.ResourceNotFoundException;
import backend.repositories.EmployeeProjectRepository;
import backend.repositories.EmployeeRepository;
import backend.repositories.ProjectRepository;
import backend.services.EmployeeProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeProjectServiceImpl implements EmployeeProjectService {
    @Autowired
    EmployeeProjectRepository employeeProjectRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    ProjectRepository projectRepository;

    @Override
    public List<EmployeeProject> listAll() {
        List<EmployeeProject> employeeProjects = employeeProjectRepository.findAll();

        for (EmployeeProject ep: employeeProjects) {
            ep.getEmployee().setEmployeeProjects(null);
            ep.getProject().setEmployeeProjects(null);
        }

        return employeeProjects;
    }

    @Override
    public List<EmployeeProject> findByEmployee_Id(Long id) {
        List<EmployeeProject> employeeProjects = employeeProjectRepository.findByEmployee_Id(id);
        for (EmployeeProject ep: employeeProjects) {
            ep.getEmployee().setEmployeeProjects(null);
            ep.getProject().setEmployeeProjects(null);
        }

        return employeeProjects;
    }

    @Override
    public List<EmployeeProject> findByProject_Id(Long id) {
        List<EmployeeProject> employeeProjects = employeeProjectRepository.findByProject_Id(id);
        for (EmployeeProject ep: employeeProjects) {
            ep.getEmployee().setEmployeeProjects(null);
            ep.getProject().setEmployeeProjects(null);
        }


        return employeeProjects;
    }

    @Override
    public EmployeeProject findById(Long id) {
        EmployeeProject employeeProjectFound = employeeProjectRepository.findById(id).orElse(null);
        if (employeeProjectFound == null) {
            throw new ResourceNotFoundException("There are no Employee Project with the id: "+String.valueOf(id));
        }
        return employeeProjectFound;
    }

    @Override
    public List<Employee> findEmployees_ByProject_Id(Long id) {
        List<EmployeeProject> employeeProjects = employeeProjectRepository.findByProject_Id(id);
        List<Employee> employeeList = new ArrayList<>();
        for (EmployeeProject ep: employeeProjects) {
            ep.getEmployee().setEmployeeProjects(null);
            employeeList.add(ep.getEmployee());
        }

        return employeeList;
    }

    @Override
    public void delete(Long id) {
        EmployeeProject employeeProject = findById(id);
        employeeProjectRepository.delete(employeeProject);
    }

    @Override
    public EmployeeProject save(EmployeeProject employeeProject) {
        Employee employee=employeeRepository.findById(employeeProject.getEmployee().getId()).get();
        Project project=projectRepository.findById(employeeProject.getProject().getId()).get();
        employeeProject.setEmployee(employee);
        employeeProject.setProject(project);
        return employeeProjectRepository.save(employeeProject);
    }


}
