GRANT ALL PRIVILEGES ON sample_db.* TO adminUser@localhost IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON sample_db.* TO adminUser@172.28.% IDENTIFIED BY 'password';
FLUSH PRIVILEGES;