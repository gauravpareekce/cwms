package com.ycompany.cwms.base.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the workflow_step database table.
 * 
 */
@Entity
@Table(name="workflow_step")
@NamedQuery(name="WorkflowStep.findAll", query="SELECT w FROM WorkflowStep w")
public class WorkflowStep implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long workflow_Step_ID;

	private BigDecimal project_ID;

	//bi-directional many-to-one association to WorkflowInstanceStep
	@OneToMany(mappedBy="workflowStep")
	private List<WorkflowInstanceStep> workflowInstanceSteps;

	//bi-directional many-to-one association to Workflow
	@ManyToOne
	@JoinColumn(name="Workflow_ID")
	private Workflow workflow;

	public WorkflowStep() {
	}

	public long getWorkflow_Step_ID() {
		return this.workflow_Step_ID;
	}

	public void setWorkflow_Step_ID(long workflow_Step_ID) {
		this.workflow_Step_ID = workflow_Step_ID;
	}

	public BigDecimal getProject_ID() {
		return this.project_ID;
	}

	public void setProject_ID(BigDecimal project_ID) {
		this.project_ID = project_ID;
	}

	public List<WorkflowInstanceStep> getWorkflowInstanceSteps() {
		return this.workflowInstanceSteps;
	}

	public void setWorkflowInstanceSteps(List<WorkflowInstanceStep> workflowInstanceSteps) {
		this.workflowInstanceSteps = workflowInstanceSteps;
	}

	public WorkflowInstanceStep addWorkflowInstanceStep(WorkflowInstanceStep workflowInstanceStep) {
		getWorkflowInstanceSteps().add(workflowInstanceStep);
		workflowInstanceStep.setWorkflowStep(this);

		return workflowInstanceStep;
	}

	public WorkflowInstanceStep removeWorkflowInstanceStep(WorkflowInstanceStep workflowInstanceStep) {
		getWorkflowInstanceSteps().remove(workflowInstanceStep);
		workflowInstanceStep.setWorkflowStep(null);

		return workflowInstanceStep;
	}

	public Workflow getWorkflow() {
		return this.workflow;
	}

	public void setWorkflow(Workflow workflow) {
		this.workflow = workflow;
	}

}