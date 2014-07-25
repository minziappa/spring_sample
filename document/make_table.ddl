/* DROP TABLE sample_user; */

CREATE DATABASE sample_db;

CREATE TABLE sample_user
(
	user_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
	user_name VARCHAR(45) NOT NULL,
	user_pwd VARCHAR(250) NOT NULL,
	user_status CHAR(1) NOT NULL,
	user_age VARCHAR(3) NULL,
	user_img MEDIUMBLOB NULL,
	insert_date TIMESTAMP NOT NULL,
	update_date TIMESTAMP NOT NULL,
	PRIMARY KEY (user_id)
) ENGINE=innoDB DEFAULT CHARSET=utf8;

CREATE INDEX sample_user_idx1 ON sample_user(user_name);