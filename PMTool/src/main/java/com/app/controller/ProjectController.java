package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Project;
import com.app.service.ProjectService;
import com.app.service.MapValidationErrorService;

@RestController
@RequestMapping("/api/project")
@CrossOrigin
public class ProjectController {
	@Autowired
	private ProjectService projService;
	@Autowired
	private MapValidationErrorService validationErrorService;

	@PostMapping
	public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result) {
		ResponseEntity<?> errorMap = validationErrorService.MapValidationService(result);
		if (errorMap != null) {
			return errorMap;
		}
		projService.saveOrUpdateProject(project);
		return new ResponseEntity<Project>(project, HttpStatus.CREATED);
	}
	
	@GetMapping("/{projectId}")
	public ResponseEntity<?>getProjectById(@PathVariable String projectId){
		Project project=projService.findProjectByIdentifier(projectId);
		return new ResponseEntity<>(project,HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public Iterable<Project>getAllproject(){
		return projService.findAllProject();
	}
	
	@DeleteMapping("/{projectId}")
	public ResponseEntity<?>deleteProjectbyIdentifier(@PathVariable String projectId){
		projService.deleteProjectByIdentifier(projectId);
		return new ResponseEntity<>("Project with id "+projectId+" deleted",HttpStatus.OK);
	}
}

