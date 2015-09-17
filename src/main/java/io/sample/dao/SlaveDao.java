package io.sample.dao;

import io.sample.bean.model.UserModel;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface SlaveDao {

	public UserModel selectSample(Map<String, Object> map) throws SQLException;
	public UserModel selectUserByName(Map<String, Object> map) throws SQLException;
	public List<UserModel> selectUserList(Map<String, Object> map) throws SQLException;
	public int selectSampleListSum() throws SQLException;
	public List<UserModel> selectUserListByName(Map<String, Object> map) throws SQLException;
	public List<UserModel> selectSampleListByDate(Map<String, Object> map) throws SQLException;

}