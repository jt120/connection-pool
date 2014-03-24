create database test_pool;
use test_pool;

create table t_sitename (
id int primary key auto_increment,
site_name varchar(200),
site_url varchar(200),
site_address varchar(200),
create_date date,
update_date date
);

source D:/share/develop/workspace/connection-pool/src/main/resources/sql/init.sql