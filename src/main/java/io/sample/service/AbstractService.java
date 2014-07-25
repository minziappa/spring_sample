package io.sample.service;

import io.sample.bean.SlaveDbMappingBean;

import java.util.Map;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractService {

	protected static int INT_DB_NUM = 0;

	@Autowired
	private SqlSession slaveAdminDao;
	@Autowired
	private SlaveDbMappingBean slaveDbMappingBean;

	protected BasicDataSource getSelectedDb(int slaveCnt) {
		BasicDataSource dispersionDb = null;

		// Select a Db
		Map<String, BasicDataSource> mapSelectedDb = slaveDbMappingBean.getSelectedSlaveDb();

		// SlaveDao slave = slaveAdminDao.getMapper(SlaveDao.class);

		INT_DB_NUM = INT_DB_NUM + 1;
		INT_DB_NUM = INT_DB_NUM % slaveCnt;
		dispersionDb = (BasicDataSource)mapSelectedDb.get(INT_DB_NUM);

		return dispersionDb;
	}

}