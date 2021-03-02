package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ProjectRepo;
import com.app.exceptions.ProjectIdException;
import com.app.pojos.Project;

@Service
public class ProjectService {
	@Autowired
	private ProjectRepo projRepo;

	public Project saveOrUpdate(Project p) {
		try {
			return projRepo.save(p);
		} catch (Exception e) {
			throw new ProjectIdException("Project id " + p.getProjectIdentifier().toUpperCase() + " already error");
		}

	}
	
	public Project findProjectByIdentifier(String projectId) {
		System.out.println("in project sevice get project"+projectId);
		 Project project=projRepo.findByProjectIdentifier(projectId.toUpperCase());
		 if(project==null) {
			 throw new ProjectIdException("Project id "+projectId+" does not exist");
		 }
		 
		 return project;
	}
	
	public Iterable<Project>findAllProject(){
		return projRepo.findAll();
	}
	
	public void deleteProjectByIdentifier(String projectId) {
		Project project=projRepo.findByProjectIdentifier(projectId.toUpperCase());
		 if(project==null) {
			 throw new ProjectIdException("Project id "+projectId+" does not exist");
		 }
		projRepo.delete(project);
	}
}