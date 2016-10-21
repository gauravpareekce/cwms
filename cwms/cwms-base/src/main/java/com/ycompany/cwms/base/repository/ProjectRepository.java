package com.ycompany.cwms.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ycompany.cwms.base.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long>{

}
