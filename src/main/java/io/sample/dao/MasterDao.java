package io.sample.dao;

import java.sql.SQLException;
import java.util.Map;

public interface MasterDao {

	public int insertSample(Map<String, Object> map) throws SQLException;
	public int insertData(Map<String, Object> map) throws SQLException;
	public int deleteSampleByName(Map<String, Object> map) throws SQLException;

}