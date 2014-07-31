CREATE TABLE sample_data
(
	data_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
	data_title VARCHAR(45) NOT NULL,
	data_dummy1 VARCHAR(45) NOT NULL,
	data_dummy2 VARCHAR(45) NOT NULL,
	data_dummy3 VARCHAR(45) NOT NULL,
	insert_date TIMESTAMP NOT NULL,
	update_date TIMESTAMP NOT NULL,
	PRIMARY KEY (data_id)
) ENGINE=innoDB DEFAULT CHARSET=utf8;