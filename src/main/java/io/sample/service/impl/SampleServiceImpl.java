package io.sample.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.HashMap;
import java.util.Map;

import io.sample.bean.SampleBean;
import io.sample.bean.model.UserModel;
import io.sample.bean.para.CsvFilePara;
import io.sample.bean.para.InsertUserPara;
import io.sample.dao.MasterDao;
import io.sample.dao.SlaveDao;
import io.sample.service.SampleService;

import org.apache.commons.codec.binary.Base64;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class SampleServiceImpl implements SampleService {

	final Logger logger = LoggerFactory.getLogger(SampleServiceImpl.class);

	@Autowired
	private SqlSession masterDao;
	@Autowired
	private SqlSession masterBatchDao;
	@Autowired
	private SqlSession slaveDao;
	@Autowired
	private Md5PasswordEncoder passwordEncoder;

	private boolean saveCsvFile(CsvFilePara csvFilePara) throws Exception {

		String strReadResult = null;

		MultipartFile file = csvFilePara.getCsvFile();
		InputStream in = null;
		InputStreamReader isr = null;
		LineNumberReader lnReader = null;

		if(file == null) {
			return false;
		}
		
		try {
			in = file.getInputStream();
			isr = new InputStreamReader(in);
			lnReader = new LineNumberReader(isr);

			int i=0;
			while((strReadResult = lnReader.readLine()) != null) {
				String [] strCell = strReadResult.split(",");
				Map<String, Object> mapData = new HashMap<String, Object>();

				mapData.put("dataTitle", file.getOriginalFilename());
				mapData.put("dataDummy1", strCell[0]);
				mapData.put("dataDummy2", strCell[1]);
				mapData.put("dataDummy3", strCell[2]);

				masterBatchDao.getMapper(MasterDao.class).insertData(mapData);
				logger.info(" count = > " + i);
				i++;
			}

		} catch (IOException e) {
			logger.error("Exception error", e);
			// masterBatchDao.rollback();
		} finally {
			if(lnReader != null) {
				lnReader.close();
			}
			if(isr != null) {
				isr.close();
			}
			if(in != null) {
				in.close();
			}
		}
		
		return true;
	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	@Override
	public boolean insertSample(InsertUserPara insertUserPara) throws Exception {

		int intResult = 0;
		byte[] byteName = null;

		MultipartFile file = insertUserPara.getUserImg();

		if(file != null) {
			String strName = file.getOriginalFilename();
			logger.info("Image name >>> " + strName);
			byteName = file.getBytes();			
		}

		String encodedPwd = passwordEncoder.encodePassword(insertUserPara.getUserPwd(), null);
		logger.info("encodedPwd is >>> " + encodedPwd);

		Map<String, Object> mapSample = new HashMap<String, Object>();
		mapSample.put("userName", insertUserPara.getUserName());
		mapSample.put("userPwd", encodedPwd);
		mapSample.put("userStatus", insertUserPara.getUserStatus());
		mapSample.put("userAge", insertUserPara.getUserAge());
		mapSample.put("userImg", byteName);

		try {
			intResult = masterDao.getMapper(MasterDao.class).insertSample(mapSample);
		} catch (Exception e) {
			logger.error("Exception error", e);
		}
		if(intResult < 1) {
			logger.error("insertSample error, userName={}", insertUserPara.getUserName());
			return false;
		}

		return true;
	}

	@Override
	public SampleBean selectSampleByName(String name) throws Exception {
		SampleBean sample = null;
		UserModel userModel = null;

		Map<String, Object> mapSelect = new HashMap<String, Object>();
		mapSelect.put("userName", name);

		try {
			userModel = slaveDao.getMapper(SlaveDao.class).selectSampleByName(mapSelect);
		} catch (Exception e) {
			logger.error("Exception error", e);
		}

		if(userModel != null) {
			sample = new SampleBean();
			sample.setUserModel(userModel);
			if(userModel.getUserImg() != null) {
				byte[] imgBytesAsBase64 = Base64.encodeBase64(userModel.getUserImg());
				String imgDataAsBase64 = new String(imgBytesAsBase64);
				String imgAsBase64 = "data:image/png;base64," + imgDataAsBase64;
				sample.setUserImage(imgAsBase64);
			}
		}

		return sample;
	}

	@Override
	public boolean deleteSampleByName(String name) throws Exception {
		int intResult = 0;

		Map<String, Object> mapSample = new HashMap<String, Object>();
		mapSample.put("userName", name);

		try {
			intResult = masterDao.getMapper(MasterDao.class).deleteSampleByName(mapSample);
		} catch (Exception e) {
			logger.error("Exception error", e);
		}
		if(intResult < 1) {
			logger.error("deleteSampleByName error, userName={}", name);
			return false;
		}

		return true;
	}

	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	public boolean syncSaveCsvFile(CsvFilePara csvFilePara) throws Exception {
		return saveCsvFile(csvFilePara);
	}

	@Async
	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	public void asyncSaveCsvFile(CsvFilePara csvFilePara) throws Exception {
		saveCsvFile(csvFilePara);
	}

}