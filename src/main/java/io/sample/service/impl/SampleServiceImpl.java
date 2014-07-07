package io.sample.service.impl;

import java.util.HashMap;
import java.util.Map;

import io.sample.bean.SampleBean;
import io.sample.bean.model.UserModel;
import io.sample.bean.para.SamplePara;
import io.sample.dao.MasterDao;
import io.sample.dao.SlaveDao;
import io.sample.service.SampleService;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SampleServiceImpl implements SampleService {

	final Logger logger = LoggerFactory.getLogger(SampleServiceImpl.class);

	@Autowired
	private SqlSession masterAdminDao;
	@Autowired
	private SqlSession slaveAdminDao;

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	@Override
	public boolean insertSample(SamplePara samplePara) throws Exception {

		int intResult = 0;

		Map<String, Object> mapSample = new HashMap<String, Object>();
		mapSample.put("userName", samplePara.getUserName());
		mapSample.put("userAge", samplePara.getUserAge());
		mapSample.put("userAge", samplePara.getUserImg());

		try {
			intResult = masterAdminDao.getMapper(MasterDao.class).insertSample(mapSample);
		} catch (Exception e) {
			logger.error("Exception error", e);
		}
		if(intResult < 1) {
			logger.error("insertSample error, sampleName={}", samplePara.getUserName());
			return false;
		}

		return true;
	}

	@Override
	public UserModel selectSample(String userId) throws Exception {

		UserModel userModel = null;

		Map<String, Object> mapSelect = new HashMap<String, Object>();
		mapSelect.put("userId", userId);

		try {
			userModel = slaveAdminDao.getMapper(SlaveDao.class).selectSample(mapSelect);
		} catch (Exception e) {
			logger.error("Exception error", e);
		}

		return userModel;
	}

	@Override
	public SampleBean getSampleData(SamplePara samplePara) throws Exception {

		SampleBean sampleBean = new SampleBean();
		sampleBean.setName("Joon");
		sampleBean.setPara("test");

		logger.info("SampleId >> " + sampleBean.getPara());
		
		return sampleBean;
	}

}