package io.sample.bean.para.embed;

import io.sample.annotation.Array;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AaName {

    @NotNull(message = "bb is the not null error.")
    @Array(message = "aa must be array")
    @Size
	private String [] aa;

	public String[] getAa() {
		return aa;
	}

	public void setAa(String[] aa) {
		this.aa = aa;
	}

}
