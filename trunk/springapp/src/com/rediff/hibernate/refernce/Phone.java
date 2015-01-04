package com.rediff.hibernate.refernce;

import java.io.Serializable;

public class Phone extends BasePojo implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long pid;
	private String phone_no;

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

}
