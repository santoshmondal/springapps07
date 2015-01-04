package com.rediff.hibernate.refernce;

import java.io.Serializable;

public class Syllabus extends BasePojo implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long sy_id;
	private String name;

	public Long getSy_id() {
		return sy_id;
	}

	public void setSy_id(Long sy_id) {
		this.sy_id = sy_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
