package com.ycompany.cwms.base.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the workflow_instance database table.
 * 
 */
@Entity
@Table(name="workflow_instance")
@NamedQuery(name="WorkflowInstance.findAll", query="SELECT w FROM WorkflowInstance w")
public class WorkflowInstance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long workflowInstance_ID;

	private BigDecimal project_ID;

	//bi-directional many-to-one association to Workflow
	@ManyToOne
	@JoinColumn(name="Workflow_ID")
	private Workflow workflow;

	//bi-directional many-to-one association to WorkflowInstanceStep
	@OneToMany(mappedBy="workflowInstance")
	private List<WorkflowInstanceStep> workflowInstanceSteps;

	public WorkflowInstance() {
	}

	public long getWorkflowInstance_ID() {
		return this.workflowInstance_ID;
	}

	public void setWorkflowInstance_ID(long workflowInstance_ID) {
		this.workflowInstance_ID = workflowInstance_ID;
	}

	public BigDecimal getProject_ID() {
		return this.project_ID;
	}

	public void setProject_ID(BigDecimal project_ID) {
		this.project_ID = project_ID;
	}

	public Workflow getWorkflow() {
		return this.workflow;
	}

	public void setWorkflow(Workflow workflow) {
		this.workflow = workflow;
	}

	public List<WorkflowInstanceStep> getWorkflowInstanceSteps() {
		return this.workflowInstanceSteps;
	}

	public void setWorkflowInstanceSteps(List<WorkflowInstanceStep> workflowInstanceSteps) {
		this.workflowInstanceSteps = workflowInstanceSteps;
	}

	public WorkflowInstanceStep addWorkflowInstanceStep(WorkflowInstanceStep workflowInstanceStep) {
		getWorkflowInstanceSteps().add(workflowInstanceStep);
		workflowInstanceStep.setWorkflowInstance(this);

		return workflowInstanceStep;
	}

	public WorkflowInstanceStep removeWorkflowInstanceStep(WorkflowInstanceStep workflowInstanceStep) {
		getWorkflowInstanceSteps().remove(workflowInstanceStep);
		workflowInstanceStep.setWorkflowInstance(null);

		return workflowInstanceStep;
	}

}