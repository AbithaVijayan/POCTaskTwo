package com.neosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neosoft.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

}
