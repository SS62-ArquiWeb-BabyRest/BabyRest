package backend.controllers;

import backend.dtos.DTOProjectSummary;
import backend.entities.Project;
import backend.services.ProjectService;
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
