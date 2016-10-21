package com.ycompany.cwms.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ycompany.cwms.base.entity.WorkflowInstance;

public interface WorkflowInstanceRepository extends JpaRepository<WorkflowInstance, Long> {

}
