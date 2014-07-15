package io.sample.dao;

import io.sample.bean.model.UserModel;

import java.sql.SQLException;
import java.util.Map;

public interface SlaveDao {
	public UserModel selectSample(Map<String, Object> map) throws SQLException;
	public UserModel selectSampleByName(Map<String, Object> map) throws SQLException;
}