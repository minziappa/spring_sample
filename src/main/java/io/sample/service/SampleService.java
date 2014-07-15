package io.sample.service;

import io.sample.bean.SampleBean;
import io.sample.bean.para.InsertUserPara;

public interface SampleService {

	public boolean insertSample(InsertUserPara insertUserPara) throws Exception;
	public SampleBean selectSampleByName(String name) throws Exception;
	public boolean deleteSampleByName(String name) throws Exception;

}