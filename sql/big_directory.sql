create database app;

use app;


/********��ҳbanner********/
create table bannerImg(
	id int(4) primary key auto_increment,
	addr varchar(80),
	iName varchar(60),
	iExplain varchar(200),
	isShow varchar(4),
	showOrder varchar(4),
	reserve varchar(80)
);

insert into bannerImg values(0,'img/banner-1.jpg','���','�Ұ������찲�ţ��찲����̫����','1','0','');
insert into bannerImg values(0,'img/banner-2.jpg','���1','�Ұ������찲�ţ��찲����̫����1','1','0','');
insert into bannerImg values(0,'img/banner-3.jpg','���2','�Ұ������찲�ţ��찲����̫����2','1','0','');


/********��ؽ���********/
create table presentations(
	id int(4) primary key auto_increment,
	prName varchar(20),
	prContent text,
	isShow varchar(4),
	reserve varchar(80)
);

insert into presentations values(0,'��վ����','<p>����ҵ�һ��Ҳ�ǵ�һ��Ϊ�Լ�д����վ��дһ�������Լ�����վ�ļƻ��ڼ���ǰ���Ѿ��γ��ˣ�����һֱæ�ڹ������£�û��ʱ��������ȥͶ�롣����»���һ�ҹ�˾������ɹ�˾�������⣬�Լ�������ʱ��Ҳ�Ƚ϶࣬�������������Լ�����վ��</p><p>�����Լ�����վ����Ҫ���Ƿ�һЩ�Լ�ϲ���Ķ�������������Ƭ������֪ʶ�Լ����õ�����ȵȡ�</p><p>��վ�Ľ��棨UI�����Լ���Ƶģ�����һ����<a target="_blank" title="http://baike.baidu.com/link?url=kxGcnK8xO_-gYiZiyxDRN6Cp4YLn0q288RXz1no0UfbIXW-ESnP57VoSa_p8dx__dAROx7D5wzmLtVAyCX-HXlMjHitO1zDgqy_sZg7uG13" href="http://baike.baidu.com/link?url=kxGcnK8xO_-gYiZiyxDRN6Cp4YLn0q288RXz1no0UfbIXW-ESnP57VoSa_p8dx__dAROx7D5wzmLtVAyCX-HXlMjHitO1zDgqy_sZg7uG13">����Good-looking|Beautiful|Pretty��</a>û�ж��������˵�������һ����ͷʹ����--!����վ��ɫ����Ҫȡ����<a href="javascript:void(0)" title="�����">�������</a>����ɫ�����ǣ���������棨UI��֮���ҷ���������...����...�����ˡ�Ҳ������վ������棬�����ﻹ�кܶ�Ҫ�Ľ��ĵط������������������˵����ʵ��һ���ܴ����ս��</p><p>ΪʲôҪдһ�������Լ�����վ������������Լ��İ��ã�Ҳ�����Ƕ��Լ������Ĳ��ԣ�Ҳ������Ϊ�˷����Լ���ѧϰ�����ݵȵȡ�������ô���������Ƕ��Լ���һ����ս��������Ҫ�漰���棨UI����ǰ�ˣ�������ݣ��ӿڣ������ռ�����3�����档</p><br /><div class="annotation clearfix"><img src="../img/qiubilong.gif" /><span>����������������������2004����ƵĿ�ͨ�����˵�����������صĵܵܣ����������ǰҲ��һ�Ű�֮�ĵ�ӡ�ǡ���Ȼ������ֻ��򣬵���Ϊϲ��������Ȧ����������̫�֣����Էɲ�������</span></div>','1', '');
insert into presentations values(0,'���˽���','<p>����˺�����ʲô��û������</p>','1', '');
insert into presentations values(0,'����','<p>�Ұ������찲�ţ��찲����̫����</p>','1', '');

/*****��վ����*******/
create table websiteEvaluation(
	id int(4) primary key auto_increment,
	etime varchar(20),
	edate varchar(20),
	evalContent text,
	ip varchar(60),
	reserve varchar(80)
);
/*****��վ����*******/
create table websiteSuggest(
	id int(4) primary key auto_increment,
	etime varchar(20),
	edate varchar(20),
	suggestContent text,
	ip varchar(60),
	reserve varchar(80)
);

/***********���ݷ���************/
create table classification(
	id int(4) primary key auto_increment,
	className varchar(40),
	reserve varchar(80)
);
insert into classification values(0, '�ʼ�', '');
insert into classification values(0, '����', '');
insert into classification values(0, 'ҵ��', '');
insert into classification values(0, '����', '');

/**************����ϵ�з���***************/
create table seriesClass(
	id int(4) primary key auto_increment,
	classId int(4),
	seriesName varchar(40),
	reserve varchar(80)
);
insert into seriesClass values(0, 1, 'js', '');
insert into seriesClass values(0, 1, 'css', '');
insert into seriesClass values(0, 1, '�ۺ�', '');
insert into seriesClass values(0, 2, '��¼', '');
insert into seriesClass values(0, 3, '��Ƹ', '');
insert into seriesClass values(0, 4, 'ժ��', '');



/**************ѧϰ***************/
create table studyTitle(
	id int(4) primary key auto_increment,
	classId int(4),
	seriesId int(4),
	contentListNo varchar(10),
	textTital varchar(40),
	sAbstract text,
	releaseDate varchar(20),
	zan varchar(10),
	notesState varchar(10),
	reserve varchar(80)
);
insert into studyTitle values(0, 1, 1, '', '�Ұ������찲��,�찲����̫����', '�Ұ������찲�ţ��찲����̫������ΰ������ë��ϯ��ָ��������ǰ�����Ұ������찲�ţ��찲����̫������ΰ������ë��ϯ��ָ��������ǰ����', '2016-07-15', '12', '', '');
insert into studyTitle values(0, 1, 1, '0', '�Ұ������찲��,�찲����̫����1', '', '2016-07-15', '12', '', '');
insert into studyTitle values(0, 1, 1, '2', '�Ұ������찲��,�찲����̫����2', '111111111�Ұ������찲�ţ��찲����̫������ΰ������ë��ϯ��ָ��������ǰ�����Ұ������찲�ţ��찲����̫������ΰ������ë��ϯ��ָ��������ǰ����', '2016-07-15', '12', '', '');

create table sContent(
	id int(4) primary key auto_increment,
	studyId int(4),
	content text,
	referencePoint text,
	reserve varchar(80)
);
insert into sContent values(0, 1, '1970��9�����׸跢�����Ϻ�����ġ���С���������ϣ�1971������������㲥��̨������1972���������ŵ�Ӱ��Ƭ������ı�������һ����԰��ר�����ս�Ŀ�ѡ��Ұ������찲�š�������Ļ�����¼���˳�Ƭ��1972�꣬���������Ժ����������ġ�ս���¸衷��һ��������Խ��Խ�죬����ɸ��ְ汾�Ķ�ͯ�赸���������ı�ɸ�����ʽ����õ����������ַ��١�ľ�ٶ������ȣ���1981�걻����㶫���ǳ����硶�������������', '', '');
insert into sContent values(0, 2, '���׶��辭����ʹ�á��ӹ�����Ϊ��������������еı�־����Ʒ�������˴����Ǹ�ʱ������ľ�����Ʒ�����С�������ͳ����û�ǰ�������������ڱ����ݳ��ĵ�һ���ϳ���Ŀ�����ǡ��Ұ������찲�š���', '', '');
insert into sContent values(0, 3, '1970��9�����׸跢�����Ϻ�����ġ���С���������ϣ�1971������������㲥��̨������1972���������ŵ�Ӱ��Ƭ������ı�������һ����԰��ר�����ս�Ŀ�ѡ��Ұ������찲�š�������Ļ�����¼���˳�Ƭ��1972�꣬���������Ժ����������ġ�ս���¸衷��һ��������Խ��Խ�죬����ɸ��ְ汾�Ķ�ͯ�赸���������ı�ɸ�����ʽ����õ����������ַ��١�ľ�ٶ������ȣ���1981�걻����㶫���ǳ����硶����������������׶��辭����ʹ�á��ӹ�����Ϊ��������������еı�־����Ʒ�������˴����Ǹ�ʱ������ľ�����Ʒ�����С�������ͳ����û�ǰ�������������ڱ����ݳ��ĵ�һ���ϳ���Ŀ�����ǡ��Ұ������찲�š����������ĸ��1977�꣩�Ͷ�����������ѧԺ����̷�ܡ������ҵ��պ��Ϊ���������ҡ�ָ�Ӽҵ�ѧ��ͬѧ����ҵ�����й���Ƭ��˾�Ϻ���˾���ֱ༭����1999��ı������������Ѵ����и�������������������ף�����һЩ��Ʒ���ȫ�����ֱ����ĸ��ֽ��', '', '');



select textTital,releaseDate,zan,content,referencePoint from studyTitle as st inner join sContent as sc on st.id=sc.studyId where sc.id=1;

/**************��Ƭ***************/
create table photo(
	id int(4) primary key auto_increment,
	classId int,
	imgName varchar(40),
	shotTypes varchar(40),
	imgInfo varchar(40),
	imgUrl varchar(100),
	imgWidth varchar(10),
	imgHeight varchar(10),
	imgDate varchar(20),
	imgTime varchar(20),
	introduce text,
	isShow varchar(4),
	reserve varchar(80)
);

insert into photo values(0, 0, 'С��', '�ֻ�', 'f/10.0, 1/125s, ISO:200', '../../photo/sapling.jpg', '960', '640', '2016-07-15', '10:09:45', '�峿��С���������ص������£������͵�', '1', '');
insert into photo values(0, 0, '�峿', '�ֻ�', 'f/4.5, 1/2s, ISO:100', '../../photo/morning.jpg', '960', '720', '2016-07-15', '05:45:45', '��̲���峿��̫�������������ƣ��ų����ɹ�â', '0', '');
insert into photo values(0, 0, 'С���', '���', 'f/16.0, 1/4s, ISO:250', '../../photo/plaything.jpg', '960', '640', '2016-08-15', '10:10:45', '΢Ц����ߣ���ɰ�', '1', '');
insert into photo values(0, 0, 'С��', '�ֻ�', 'f/10.0, 1/125s, ISO:200', '../../photo/sapling.jpg', '960', '640', '2016-07-15', '10:09:45', '�峿��С���������ص������£������͵�', '1', '');
insert into photo values(0, 0, '�峿', '�ֻ�', 'f/4.5, 1/2s, ISO:100', '../../photo/morning.jpg', '960', '720', '2016-07-15', '05:45:45', '��̲���峿��̫�������������ƣ��ų����ɹ�â', '1', '');
insert into photo values(0, 0, 'С���', '���', 'f/16.0, 1/4s, ISO:250', '../../photo/plaything.jpg', '960', '640', '2016-08-15', '10:10:45', '΢Ц����ߣ���ɰ�', '1', '');
insert into photo values(0, 0, 'С���', '���', 'f/16.0, 1/4s, ISO:250', '../../photo/plaything.jpg', '960', '640', '2016-08-15', '10:10:45', '΢Ц����ߣ���ɰ�', '1', '');
insert into photo values(0, 0, 'С��', '�ֻ�', 'f/10.0, 1/125s, ISO:200', '../../photo/sapling.jpg', '960', '640', '2016-07-15', '10:09:45', '�峿��С���������ص������£������͵�', '1', '');
insert into photo values(0, 0, '�峿', '�ֻ�', 'f/4.5, 1/2s, ISO:100', '../../photo/morning.jpg', '960', '720', '2016-07-15', '05:45:45', '��̲���峿��̫�������������ƣ��ų����ɹ�â', '1', '');
insert into photo values(0, 0, 'С���', '���', 'f/16.0, 1/4s, ISO:250', '../../photo/plaything.jpg', '960', '640', '2016-08-15', '10:10:45', '΢Ц����ߣ���ɰ�', '1', '');
insert into photo values(0, 0, 'С���', '���', 'f/16.0, 1/4s, ISO:250', '../../photo/plaything.jpg', '960', '640', '2016-08-15', '10:10:45', '΢Ц����ߣ���ɰ�', '1', '');
insert into photo values(0, 0, 'С��', '�ֻ�', 'f/10.0, 1/125s, ISO:200', '../../photo/sapling.jpg', '960', '640', '2016-07-15', '10:09:45', '�峿��С���������ص������£������͵�', '1', '');
insert into photo values(0, 0, '�峿', '�ֻ�', 'f/4.5, 1/2s, ISO:100', '../../photo/morning.jpg', '960', '720', '2016-07-15', '05:45:45', '��̲���峿��̫�������������ƣ��ų����ɹ�â', '1', '');
insert into photo values(0, 0, 'С���', '���', 'f/16.0, 1/4s, ISO:250', '../../photo/plaything.jpg', '960', '640', '2016-08-15', '10:10:45', '΢Ц����ߣ���ɰ�', '1', '');
insert into photo values(0, 0, 'С���', '���', 'f/16.0, 1/4s, ISO:250', '../../photo/plaything.jpg', '960', '640', '2016-08-15', '10:10:45', '΢Ц����ߣ���ɰ�', '1', '');
insert into photo values(0, 0, 'С��', '�ֻ�', 'f/10.0, 1/125s, ISO:200', '../../photo/sapling.jpg', '960', '640', '2016-07-15', '10:09:45', '�峿��С���������ص������£������͵�', '1', '');
insert into photo values(0, 0, '�峿', '�ֻ�', 'f/4.5, 1/2s, ISO:100', '../../photo/morning.jpg', '960', '720', '2016-07-15', '05:45:45', '��̲���峿��̫�������������ƣ��ų����ɹ�â', '1', '');
insert into photo values(0, 0, 'С���', '���', 'f/16.0, 1/4s, ISO:250', '../../photo/plaything.jpg', '960', '640', '2016-08-15', '10:10:45', '΢Ц����ߣ���ɰ�', '1', '');
insert into photo values(0, 0, 'С���', '���', 'f/16.0, 1/4s, ISO:250', '../../photo/plaything.jpg', '960', '640', '2016-08-15', '10:10:45', '΢Ц����ߣ���ɰ�', '1', '');
insert into photo values(0, 0, 'С��', '�ֻ�', 'f/10.0, 1/125s, ISO:200', '../../photo/sapling.jpg', '960', '640', '2016-07-15', '10:09:45', '�峿��С���������ص������£������͵�', '1', '');
insert into photo values(0, 0, '�峿', '�ֻ�', 'f/4.5, 1/2s, ISO:100', '../../photo/morning.jpg', '960', '720', '2016-07-15', '05:45:45', '��̲���峿��̫�������������ƣ��ų����ɹ�â', '1', '');
insert into photo values(0, 0, 'С���', '���', 'f/16.0, 1/4s, ISO:250', '../../photo/plaything.jpg', '960', '640', '2016-08-15', '10:10:45', '΢Ц����ߣ���ɰ�', '1', '');




















