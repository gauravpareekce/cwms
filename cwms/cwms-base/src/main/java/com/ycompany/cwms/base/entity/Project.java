package com.ycompany.cwms.base.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the project database table.
 * 
 */
@Entity
@NamedQuery(name="Project.findAll", query="SELECT p FROM Project p")
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long project_ID;

	/*//bi-directional many-to-one association to ProjectUser
	@OneToMany(mappedBy="project")
	private List<ProjectUser> projectUsers;*/

	//bi-directional many-to-one association to Workflow
	@OneToMany(mappedBy="project")
	private List<Workflow> workflows;

	public Project() {
	}

	public long getProject_ID() {
		return this.project_ID;
	}

	public void setProject_ID(long project_ID) {
		this.project_ID = project_ID;
	}

	/*public List<ProjectUser> getProjectUsers() {
		return this.projectUsers;
	}

	public void setProjectUsers(List<ProjectUser> projectUsers) {
		this.projectUsers = projectUsers;
	}

	public ProjectUser addProjectUser(ProjectUser projectUser) {
		getProjectUsers().add(projectUser);
		//projectUser.setProject(this);

		return projectUser;
	}

	public ProjectUser removeProjectUser(ProjectUser projectUser) {
		getProjectUsers().remove(projectUser);
	//	projectUser.setProject(null);

		return projectUser;
	}*/

	public List<Workflow> getWorkflows() {
		return this.workflows;
	}

	public void setWorkflows(List<Workflow> workflows) {
		this.workflows = workflows;
	}

	public Workflow addWorkflow(Workflow workflow) {
		getWorkflows().add(workflow);
		workflow.setProject(this);

		return workflow;
	}

	public Workflow removeWorkflow(Workflow workflow) {
		getWorkflows().remove(workflow);
		workflow.setProject(null);

		return workflow;
	}

}