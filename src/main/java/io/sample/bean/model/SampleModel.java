package io.sample.bean.model;

import io.sample.bean.SampleBean;

public class SampleModel {

	private SampleBean sample;

    /** Show the message to page.**/
    private String errorMessage;

	public SampleBean getSample() {
		return sample;
	}

	public void setSample(SampleBean sample) {
		this.sample = sample;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
