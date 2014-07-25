GRANT ALL PRIVILEGES ON sample_db.* TO adminUser@localhost IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON sample_db.* TO adminUser@172.28.% IDENTIFIED BY 'password';
FLUSH PRIVILEGES;

INSERT INTO sample_user (user_name,user_pwd,user_status,user_age,insert_date,update_date) VALUES (
'admin','5f4dcc3b5aa765d61d8327deb882cf99','1','20',now(),now())