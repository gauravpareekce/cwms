package com.ycompany.cwms.base.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the workflow_instance_step database table.
 * 
 */
@Entity
@Table(name="workflow_instance_step")
@NamedQuery(name="WorkflowInstanceStep.findAll", query="SELECT w FROM WorkflowInstanceStep w")
public class WorkflowInstanceStep implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long workflow_Instance_Step_ID;

	private BigDecimal project_ID;

	private BigDecimal workflow_ID;

	//bi-directional many-to-one association to WorkflowInstance
	@ManyToOne
	@JoinColumn(name="WorkflowInstance_ID")
	private WorkflowInstance workflowInstance;

	//bi-directional many-to-one association to WorkflowStep
	@ManyToOne
	@JoinColumn(name="Workflow_Step_ID")
	private WorkflowStep workflowStep;

	//bi-directional many-to-one association to WorkflowInstanceStepStatus
	@OneToMany(mappedBy="workflowInstanceStep")
	private List<WorkflowInstanceStepStatus> workflowInstanceStepStatuses;

	public WorkflowInstanceStep() {
	}

	public long getWorkflow_Instance_Step_ID() {
		return this.workflow_Instance_Step_ID;
	}

	public void setWorkflow_Instance_Step_ID(long workflow_Instance_Step_ID) {
		this.workflow_Instance_Step_ID = workflow_Instance_Step_ID;
	}

	public BigDecimal getProject_ID() {
		return this.project_ID;
	}

	public void setProject_ID(BigDecimal project_ID) {
		this.project_ID = project_ID;
	}

	public BigDecimal getWorkflow_ID() {
		return this.workflow_ID;
	}

	public void setWorkflow_ID(BigDecimal workflow_ID) {
		this.workflow_ID = workflow_ID;
	}

	public WorkflowInstance getWorkflowInstance() {
		return this.workflowInstance;
	}

	public void setWorkflowInstance(WorkflowInstance workflowInstance) {
		this.workflowInstance = workflowInstance;
	}

	public WorkflowStep getWorkflowStep() {
		return this.workflowStep;
	}

	public void setWorkflowStep(WorkflowStep workflowStep) {
		this.workflowStep = workflowStep;
	}

	public List<WorkflowInstanceStepStatus> getWorkflowInstanceStepStatuses() {
		return this.workflowInstanceStepStatuses;
	}

	public void setWorkflowInstanceStepStatuses(List<WorkflowInstanceStepStatus> workflowInstanceStepStatuses) {
		this.workflowInstanceStepStatuses = workflowInstanceStepStatuses;
	}

	public WorkflowInstanceStepStatus addWorkflowInstanceStepStatus(WorkflowInstanceStepStatus workflowInstanceStepStatus) {
		getWorkflowInstanceStepStatuses().add(workflowInstanceStepStatus);
		workflowInstanceStepStatus.setWorkflowInstanceStep(this);

		return workflowInstanceStepStatus;
	}

	public WorkflowInstanceStepStatus removeWorkflowInstanceStepStatus(WorkflowInstanceStepStatus workflowInstanceStepStatus) {
		getWorkflowInstanceStepStatuses().remove(workflowInstanceStepStatus);
		workflowInstanceStepStatus.setWorkflowInstanceStep(null);

		return workflowInstanceStepStatus;
	}

}