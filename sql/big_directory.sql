create database q_jiang;

create table big_directory(
	big_id char(5) primary key,
	big_title varchar(30) not null,
	big_content varchar(200),
	big_01 varchar(200)
);

insert into big_directory value("1", "天安门", "天安门上太阳升", "我爱北京天安门，天安门上太阳升，伟大..."); 