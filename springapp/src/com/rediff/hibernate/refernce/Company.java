package com.rediff.hibernate.refernce;

import java.io.Serializable;

public class Company extends BasePojo implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long cid;
	private String name;

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
