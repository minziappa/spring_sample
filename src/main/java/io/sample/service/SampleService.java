package io.sample.service;

import io.sample.bean.SampleBean;
import io.sample.bean.para.CsvFilePara;
import io.sample.bean.para.InsertUserPara;

public interface SampleService {

	public boolean insertSample(InsertUserPara insertUserPara) throws Exception;
	public SampleBean selectSampleByName(String name) throws Exception;
	public boolean deleteSampleByName(String name) throws Exception;

	public boolean syncSaveCsvFile(CsvFilePara csvFilePara) throws Exception;
	public void asyncSaveCsvFile(CsvFilePara csvFilePara) throws Exception;
	public byte[] downLoadCsvFile() throws Exception;

}