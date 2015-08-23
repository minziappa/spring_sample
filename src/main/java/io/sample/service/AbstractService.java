package io.sample.service;

import io.sample.bean.SlaveDbMappingBean;

import java.util.Map;

import org.apache.commons.dbcp.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class AbstractService {

	protected static int INT_DB_NUM = 0;

	@Autowired
	@Qualifier("sqlSessionSlaveFactory")
	public SqlSessionFactoryBean sqlSessionSlaveFactory;
	@Autowired
	private SlaveDbMappingBean slaveDbMappingBean;
	private Map<String, BasicDataSource> mappingDb;

	protected BasicDataSource getDispersionDb() {
		mappingDb = slaveDbMappingBean.getSelectedSlaveDb();

		INT_DB_NUM = INT_DB_NUM + 1;
		INT_DB_NUM = INT_DB_NUM % mappingDb.size();

		return (BasicDataSource) mappingDb.get(String.valueOf(INT_DB_NUM));
	}

}