package com.rediff.hibernate.refernce;

import java.io.Serializable;
import java.util.Date;

/**
 *
 */
public class BasePojo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Boolean deleted;
	private Date ctime;
	private Date utime;

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public Date getCtime() {
		return ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}

	public Date getUtime() {
		return utime;
	}

	public void setUtime(Date utime) {
		this.utime = utime;
	}

}
