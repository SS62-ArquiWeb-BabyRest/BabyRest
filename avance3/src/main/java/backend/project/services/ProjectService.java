package backend.project.services;

import backend.project.dtos.DTOProjectSummary;
import backend.project.entities.Employee;
import backend.project.dtos.DTOProjectSummary;
import backend.project.entities.Project;

import java.util.List;

public interface ProjectService {
    public List<Project> listAll();
    public List<Employee> listEmployeeByProject_Id(Long id);

    public List<DTOProjectSummary> listProjectsSummary();
}
