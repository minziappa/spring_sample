package io.sample.service;

import io.sample.bean.model.UserModel;
import io.sample.bean.para.InsertUserPara;

public interface SampleService {

	public boolean insertSample(InsertUserPara insertUserPara) throws Exception;
	public UserModel selectSample(String sampleId) throws Exception;
	public UserModel selectSampleByName(String name) throws Exception;
	public boolean deleteSampleByName(String name) throws Exception;

}