package com.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.pojos.Project;
import com.app.pojos.ProjectTask;
import com.app.service.IProjectService;
import com.app.service.IProjectTaskService;

@SpringBootTest
class TestProjectService {
	@Autowired
	private IProjectService service;
	
	@Autowired
	private IProjectTaskService projectTaskService;

	@Test
	public void testGetProjectByIdentifier()
	{
		Project p=service.getProjectByIdentifier("ABCD","ajit@gmail.com");
		assertEquals("Sample Project", p.getProjectName());
	}
	
	@Test
	public void testGetPTByProjectSequence()
	{
		ProjectTask pt=projectTaskService.getPTByProjectSequence("ABCD","ABCD-1","ajit@gmail.com");
		assertEquals("TO_DO", pt.getStatus());
	}
	
	

}
