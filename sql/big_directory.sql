create database app;

use app;

/********相关介绍********/
create table presentations(
	id int(4) primary key auto_increment,
	prName varchar(20),
	prContent text,
	isShow varchar(4),
	reserve varchar(80)
);

insert into presentations values(0,'网站介绍','我爱北京天安门，天安门上太阳升','1', '');