package com.ycompany.cwms.base.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the workflow_instance_step_status database table.
 * 
 */
@Entity
@Table(name="workflow_instance_step_status")
@NamedQuery(name="WorkflowInstanceStepStatus.findAll", query="SELECT w FROM WorkflowInstanceStepStatus w")
public class WorkflowInstanceStepStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private WorkflowInstanceStepStatusPK id;

	private String workflow_Instance_Step_Status;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="User_ID", insertable=false, updatable=false)
	private User user;

	//bi-directional many-to-one association to WorkflowInstanceStep
	@ManyToOne
	@JoinColumn(name="Workflow_Instance_Step_ID", insertable=false, updatable=false)
	private WorkflowInstanceStep workflowInstanceStep;

	public WorkflowInstanceStepStatus() {
	}

	public WorkflowInstanceStepStatusPK getId() {
		return this.id;
	}

	public void setId(WorkflowInstanceStepStatusPK id) {
		this.id = id;
	}

	public String getWorkflow_Instance_Step_Status() {
		return this.workflow_Instance_Step_Status;
	}

	public void setWorkflow_Instance_Step_Status(String workflow_Instance_Step_Status) {
		this.workflow_Instance_Step_Status = workflow_Instance_Step_Status;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public WorkflowInstanceStep getWorkflowInstanceStep() {
		return this.workflowInstanceStep;
	}

	public void setWorkflowInstanceStep(WorkflowInstanceStep workflowInstanceStep) {
		this.workflowInstanceStep = workflowInstanceStep;
	}

}