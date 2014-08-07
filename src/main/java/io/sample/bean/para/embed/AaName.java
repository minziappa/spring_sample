package io.sample.bean.para.embed;

import io.sample.annotation.Array;

import javax.validation.constraints.NotNull;

public class AaName {

    @NotNull(message = "aa is the not null error.")
    @Array(message = "aa must be array")
	private String [] aa;

	public String[] getAa() {
		return aa;
	}

	public void setAa(String[] aa) {
		this.aa = aa;
	}

}
