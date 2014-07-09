package io.sample.service;

import io.sample.bean.SampleBean;
import io.sample.bean.model.UserModel;
import io.sample.bean.para.InsertUserPara;
import io.sample.bean.para.SamplePara;

public interface SampleService {

	public boolean insertSample(InsertUserPara insertUserPara) throws Exception;
	public UserModel selectSample(String sampleId) throws Exception;
	public SampleBean getSampleData(SamplePara samplePara) throws Exception;

}