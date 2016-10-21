package com.ycompany.cwms.base.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the project_user database table.
 * 
 */
@Entity
@Table(name="project_user")
@NamedQuery(name="ProjectUser.findAll", query="SELECT p FROM ProjectUser p")
public class ProjectUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProjectUserPK id;

	private String role;

	//bi-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name="Project_ID", insertable=false, updatable=false)
	private Project project;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="User_ID", insertable=false, updatable=false)
	private User user;

	public ProjectUser() {
	}

	public ProjectUserPK getId() {
		return this.id;
	}

	public void setId(ProjectUserPK id) {
		this.id = id;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}