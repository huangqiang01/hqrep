create database app;

use app;

/********��ؽ���********/
create table presentations(
	id int(4) primary key auto_increment,
	prName varchar(20),
	prContent text,
	isShow varchar(4),
	reserve varchar(80)
);

insert into presentations values(0,'��վ����','�Ұ������찲�ţ��찲����̫����','1', '');