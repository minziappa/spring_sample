package io.sample.bean;

import java.util.Map;

import org.apache.commons.dbcp.BasicDataSource;

public class SlaveDbMappingBean {

	private Map<String, BasicDataSource> selectedSlaveDb;

	public Map<String, BasicDataSource> getSelectedSlaveDb() {
		return selectedSlaveDb;
	}

	public void setSelectedSlaveDb(Map<String, BasicDataSource> selectedSlaveDb) {
		this.selectedSlaveDb = selectedSlaveDb;
	}

}