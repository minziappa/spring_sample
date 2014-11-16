package io.sample.bean.model;

import java.util.List;

import io.paging.bean.PagingBean;
import io.sample.bean.SampleBean;

public class SampleModel {

	private SampleBean sample;
	private List<SampleBean> sampleList;
	private UserModel userModel;
	private String filePath;
	private String navi;
	/** Paging **/
    private PagingBean paging;
    /** Show the message to page.**/
    private String errorMessage;

	public SampleBean getSample() {
		return sample;
	}

	public void setSample(SampleBean sample) {
		this.sample = sample;
	}

	public List<SampleBean> getSampleList() {
		return sampleList;
	}

	public void setSampleList(List<SampleBean> sampleList) {
		this.sampleList = sampleList;
	}

	public UserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}

	public String getNavi() {
		return navi;
	}

	public void setNavi(String navi) {
		this.navi = navi;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public PagingBean getPaging() {
		return paging;
	}

	public void setPaging(PagingBean paging) {
		this.paging = paging;
	}

}
