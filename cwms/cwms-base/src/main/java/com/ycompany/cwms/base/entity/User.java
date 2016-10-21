package com.ycompany.cwms.base.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long user_ID;

	//bi-directional many-to-one association to ProjectUser
	@OneToMany(mappedBy="user")
	private List<ProjectUser> projectUsers;

	//bi-directional many-to-one association to WorkflowInstanceStepStatus
	@OneToMany(mappedBy="user")
	private List<WorkflowInstanceStepStatus> workflowInstanceStepStatuses;

	public User() {
	}

	public long getUser_ID() {
		return this.user_ID;
	}

	public void setUser_ID(long user_ID) {
		this.user_ID = user_ID;
	}

	public List<ProjectUser> getProjectUsers() {
		return this.projectUsers;
	}

	public void setProjectUsers(List<ProjectUser> projectUsers) {
		this.projectUsers = projectUsers;
	}

	public ProjectUser addProjectUser(ProjectUser projectUser) {
		getProjectUsers().add(projectUser);
		projectUser.setUser(this);

		return projectUser;
	}

	public ProjectUser removeProjectUser(ProjectUser projectUser) {
		getProjectUsers().remove(projectUser);
		projectUser.setUser(null);

		return projectUser;
	}

	public List<WorkflowInstanceStepStatus> getWorkflowInstanceStepStatuses() {
		return this.workflowInstanceStepStatuses;
	}

	public void setWorkflowInstanceStepStatuses(List<WorkflowInstanceStepStatus> workflowInstanceStepStatuses) {
		this.workflowInstanceStepStatuses = workflowInstanceStepStatuses;
	}

	public WorkflowInstanceStepStatus addWorkflowInstanceStepStatus(WorkflowInstanceStepStatus workflowInstanceStepStatus) {
		getWorkflowInstanceStepStatuses().add(workflowInstanceStepStatus);
		workflowInstanceStepStatus.setUser(this);

		return workflowInstanceStepStatus;
	}

	public WorkflowInstanceStepStatus removeWorkflowInstanceStepStatus(WorkflowInstanceStepStatus workflowInstanceStepStatus) {
		getWorkflowInstanceStepStatuses().remove(workflowInstanceStepStatus);
		workflowInstanceStepStatus.setUser(null);

		return workflowInstanceStepStatus;
	}

}