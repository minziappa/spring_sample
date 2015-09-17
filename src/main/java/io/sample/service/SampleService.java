package io.sample.service;

import java.util.List;

import io.sample.bean.SampleBean;
import io.sample.bean.model.UserModel;
import io.sample.bean.para.CsvFilePara;
import io.sample.bean.para.InputUserPara;
import io.sample.bean.para.SearchUserPara;
import io.sample.bean.para.UserPara;

public interface SampleService {

	public boolean insertSample(InputUserPara inputUserPara) throws Exception;
	public List<SampleBean> selectUserList(UserPara userPara) throws Exception;
	public int getSampleListSum() throws Exception;
	public UserModel selectUserByName(String name) throws Exception;
	public List<SampleBean> selectUserListByName(SearchUserPara searchUserPara) throws Exception;
	public List<SampleBean> selectSampleByDate(SearchUserPara searchUserPara) throws Exception;
	public boolean deleteSampleByName(String name) throws Exception;

	public boolean syncSaveCsvFile(CsvFilePara csvFilePara) throws Exception;
	public void asyncSaveCsvFile(CsvFilePara csvFilePara) throws Exception;
	public byte[] makeCsvFile() throws Exception;
	public byte[] makePdfFile() throws Exception;

}