package backend.services;

import backend.dtos.DTOProjectSummary;
import backend.entities.Employee;
import backend.entities.Project;

import java.util.List;

public interface ProjectService {
    public List<Project> listAll();
    public List<Employee> listEmployeeByProject_Id(Long id);

    public List<DTOProjectSummary> listProjectsSummary();
}
