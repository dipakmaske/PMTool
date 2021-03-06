package com.app.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.Project;

@Repository
public interface ProjectRepo extends CrudRepository<Project, Integer>{

	Project findByProjectIdentifier(String projectId);
	
	@Override
	Iterable<Project>findAll();
	
	  Iterable<Project> findAllByProjectLeader(String username);
}
