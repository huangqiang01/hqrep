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



insert into websiteEvaluation values(0, )

