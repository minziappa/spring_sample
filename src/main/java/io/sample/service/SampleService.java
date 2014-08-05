package io.sample.service;

import java.util.List;

import io.sample.bean.SampleBean;
import io.sample.bean.para.CsvFilePara;
import io.sample.bean.para.InsertUserPara;
import io.sample.bean.para.SelectUserPara;

public interface SampleService {

	public boolean insertSample(InsertUserPara insertUserPara) throws Exception;
	public List<SampleBean> selectSampleByName(SelectUserPara selectUserPara) throws Exception;
	public boolean deleteSampleByName(String name) throws Exception;

	public boolean syncSaveCsvFile(CsvFilePara csvFilePara) throws Exception;
	public void asyncSaveCsvFile(CsvFilePara csvFilePara) throws Exception;
	public byte[] downLoadCsvFile() throws Exception;

}