package com.ycompany.cwms.base.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the project_user database table.
 * 
 */
@Embeddable
public class ProjectUserPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private long project_ID;

	@Column(insertable=false, updatable=false)
	private long user_ID;

	public ProjectUserPK() {
	}
	public long getProject_ID() {
		return this.project_ID;
	}
	public void setProject_ID(long project_ID) {
		this.project_ID = project_ID;
	}
	public long getUser_ID() {
		return this.user_ID;
	}
	public void setUser_ID(long user_ID) {
		this.user_ID = user_ID;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ProjectUserPK)) {
			return false;
		}
		ProjectUserPK castOther = (ProjectUserPK)other;
		return 
			(this.project_ID == castOther.project_ID)
			&& (this.user_ID == castOther.user_ID);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.project_ID ^ (this.project_ID >>> 32)));
		hash = hash * prime + ((int) (this.user_ID ^ (this.user_ID >>> 32)));
		
		return hash;
	}
}