create database q_jiang;

create table big_directory(
	big_id char(5) primary key,
	big_title varchar(30) not null,
	big_content varchar(200),
	big_01 varchar(200)
);

insert into big_directory value("1", "�찲��", "�찲����̫����", "�Ұ������찲�ţ��찲����̫������ΰ��..."); 