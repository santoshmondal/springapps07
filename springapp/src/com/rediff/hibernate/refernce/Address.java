package com.rediff.hibernate.refernce;

import java.io.Serializable;

public class Address extends BasePojo implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long aid;
	private String city;

	public Long getAid() {
		return aid;
	}

	public void setAid(Long aid) {
		this.aid = aid;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
