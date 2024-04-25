package backend.project.servicesimpl;

import backend.project.dtos.DTOProjectSummary;
import backend.project.entities.Employee;
import backend.project.entities.EmployeeProject;
import backend.project.entities.Project;
import backend.project.repositories.ProjectRepository;
import backend.project.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectRepository projectRepository;


    @Override
    public List<Project> listAll() {
        List<Project> projects = projectRepository.findAll();
        for (Project e: projects) {
            e.setEmployeeProjects(null);
        }
        return projects;
    }

    @Override
    public List<Employee> listEmployeeByProject_Id(Long id) {
        return null;
    }

    @Override
    public List<DTOProjectSummary> listProjectsSummary() {

        List<Project> projects = projectRepository.findAll();
        List<DTOProjectSummary> projectSummaryList = new ArrayList<>();


        for (Project p: projects) {

            String name = p.getName();


            //Opcion 1 - Recorriendo con For la lista de Projects
            /*
            Integer employeesAssignedHomeOffice = 0;
            Integer employeesAssignedCentralOffice = 0;
            Double cost = 0.0;
            Integer effort =0;

            for (EmployeeProject ep: p.getEmployeeProjects()) {
                if (ep.getHomeOffice()) {
                    employeesAssignedHomeOffice++;
                } else {
                    employeesAssignedCentralOffice++;
                }

                effort = effort + ep.getHoursWorked();
                cost = cost + (ep.getEmployee().getSalary()/30.0)/8.0 * ep.getHoursWorked();
            }

             */
            //--Fin Opcion 1

            //Opcion 2 - Utilizando el API Stream
            Integer employeesAssignedHomeOffice = (int)p.getEmployeeProjects().stream().filter(ep->ep.getHomeOffice().equals(true)).count();
            Integer employeesAssignedCentralOffice  = (int)p.getEmployeeProjects().stream().filter(ep->ep.getHomeOffice().equals(false)).count();
            Integer effort = p.getEmployeeProjects().stream().map(ep->ep.getHoursWorked()).reduce(0,Integer::sum);
            Double cost = p.getEmployeeProjects().stream().map(ep->ep.getHoursWorked()*(ep.getEmployee().getSalary()/30/8)).reduce(0.0, Double::sum);
            //--Fin Opcion 2


            DTOProjectSummary dtoProjectSummary = new DTOProjectSummary(name, employeesAssignedHomeOffice,employeesAssignedCentralOffice, cost, effort );
            projectSummaryList.add(dtoProjectSummary);

        }
        return projectSummaryList;
    }
}
