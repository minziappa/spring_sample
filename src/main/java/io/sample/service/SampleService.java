package io.sample.service;

import java.util.List;

import io.sample.bean.SampleBean;
import io.sample.bean.model.UserModel;
import io.sample.bean.para.CsvFilePara;
import io.sample.bean.para.InsertUserPara;
import io.sample.bean.para.SelectUserPara;
import io.sample.bean.para.UserPara;

public interface SampleService {

	public boolean insertSample(InsertUserPara insertUserPara) throws Exception;
	public List<SampleBean> selectSampleList(UserPara userPara) throws Exception;
	public int getSampleListSum() throws Exception;
	public UserModel selectSampleByName(String name) throws Exception;
	public List<SampleBean> selectSampleByName(SelectUserPara selectUserPara) throws Exception;
	public List<SampleBean> selectSampleByDate(SelectUserPara selectUserPara) throws Exception;
	public boolean deleteSampleByName(String name) throws Exception;

	public boolean syncSaveCsvFile(CsvFilePara csvFilePara) throws Exception;
	public void asyncSaveCsvFile(CsvFilePara csvFilePara) throws Exception;
	public byte[] makeCsvFile() throws Exception;
	public byte[] makePdfFile() throws Exception;

}