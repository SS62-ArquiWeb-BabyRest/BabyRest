package backend.project.controllers;

import backend.project.dtos.DTOProjectSummary;
import backend.project.entities.Employee;
import backend.project.entities.Project;
import backend.project.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @GetMapping("/projects/summary")
    public ResponseEntity<List<DTOProjectSummary>> getProjectsSummary() {
        List<DTOProjectSummary> dtoProjectSummaryList = projectService.listProjectsSummary();
        return new ResponseEntity<List<DTOProjectSummary>>(dtoProjectSummaryList, HttpStatus.OK);
    }

    @GetMapping("/projects")
    public ResponseEntity<List<Project>> getProjects() {
        List<Project> projects  = projectService.listAll();
        return new ResponseEntity<List<Project>>(projects, HttpStatus.OK);
    }


}
