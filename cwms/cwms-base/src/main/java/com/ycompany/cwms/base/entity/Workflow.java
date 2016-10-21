package com.ycompany.cwms.base.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the workflow database table.
 * 
 */
@Entity
@NamedQuery(name="Workflow.findAll", query="SELECT w FROM Workflow w")
public class Workflow implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long workflow_ID;

	//bi-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name="Project_ID")
	private Project project;

	//bi-directional many-to-one association to WorkflowInstance
	@OneToMany(mappedBy="workflow")
	private List<WorkflowInstance> workflowInstances;

	//bi-directional many-to-one association to WorkflowStep
	@OneToMany(mappedBy="workflow")
	private List<WorkflowStep> workflowSteps;

	public Workflow() {
	}

	public long getWorkflow_ID() {
		return this.workflow_ID;
	}

	public void setWorkflow_ID(long workflow_ID) {
		this.workflow_ID = workflow_ID;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public List<WorkflowInstance> getWorkflowInstances() {
		return this.workflowInstances;
	}

	public void setWorkflowInstances(List<WorkflowInstance> workflowInstances) {
		this.workflowInstances = workflowInstances;
	}

	public WorkflowInstance addWorkflowInstance(WorkflowInstance workflowInstance) {
		getWorkflowInstances().add(workflowInstance);
		workflowInstance.setWorkflow(this);

		return workflowInstance;
	}

	public WorkflowInstance removeWorkflowInstance(WorkflowInstance workflowInstance) {
		getWorkflowInstances().remove(workflowInstance);
		workflowInstance.setWorkflow(null);

		return workflowInstance;
	}

	public List<WorkflowStep> getWorkflowSteps() {
		return this.workflowSteps;
	}

	public void setWorkflowSteps(List<WorkflowStep> workflowSteps) {
		this.workflowSteps = workflowSteps;
	}

	public WorkflowStep addWorkflowStep(WorkflowStep workflowStep) {
		getWorkflowSteps().add(workflowStep);
		workflowStep.setWorkflow(this);

		return workflowStep;
	}

	public WorkflowStep removeWorkflowStep(WorkflowStep workflowStep) {
		getWorkflowSteps().remove(workflowStep);
		workflowStep.setWorkflow(null);

		return workflowStep;
	}

}