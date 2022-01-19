package com.neosoft.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.model.Project;
import com.neosoft.repository.ProjectRepository;


@RestController
public class ProjectController {
	
	@Autowired
	private ProjectRepository  projectRepository;

	@GetMapping("/project")
	public List<Project> getAllProjects(){
		return projectRepository.findAll();
	}
	
	@PostMapping("/project")
	public Project createPost(@Validated @RequestBody Project project) {
		return projectRepository.save(project);
	}
}
