package io.sample.bean;

import java.io.Serializable;

public class SampleBean implements Serializable {

	private static final long serialVersionUID = -2758511412673492544L;

	private String para;
	private String name;

	public String getPara() {
		return para;
	}
	public void setPara(String para) {
		this.para = para;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}