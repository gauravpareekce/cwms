package com.ycompany.cwms.base.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the workflow_instance_step_status database table.
 * 
 */
@Embeddable
public class WorkflowInstanceStepStatusPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column( insertable=false, updatable=false)
	private long user_ID;

	@Column(insertable=false, updatable=false)
	private long workflow_Instance_Step_ID;

	public WorkflowInstanceStepStatusPK() {
	}
	public long getUser_ID() {
		return this.user_ID;
	}
	public void setUser_ID(long user_ID) {
		this.user_ID = user_ID;
	}
	public long getWorkflow_Instance_Step_ID() {
		return this.workflow_Instance_Step_ID;
	}
	public void setWorkflow_Instance_Step_ID(long workflow_Instance_Step_ID) {
		this.workflow_Instance_Step_ID = workflow_Instance_Step_ID;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof WorkflowInstanceStepStatusPK)) {
			return false;
		}
		WorkflowInstanceStepStatusPK castOther = (WorkflowInstanceStepStatusPK)other;
		return 
			(this.user_ID == castOther.user_ID)
			&& (this.workflow_Instance_Step_ID == castOther.workflow_Instance_Step_ID);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.user_ID ^ (this.user_ID >>> 32)));
		hash = hash * prime + ((int) (this.workflow_Instance_Step_ID ^ (this.workflow_Instance_Step_ID >>> 32)));
		
		return hash;
	}
}