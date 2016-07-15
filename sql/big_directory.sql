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
insert into studyTitle values(0, 1, 1, '', 'javascript ֮�������', 'js�������ݵķ����кܶ��֣�var arr = new Array();var arr = new Array([10]);var arr = new Array([1,2,3,4]);var arr = [];�������һ�ַ�������õģ�Ҳ����򵥵ġ���Ȼ������ĸ�ֵ��һ��Ҫ�ڴ��������ʱ����ɣ���Ϊ����ĳ����ǿ����������ģ����Կ����ڴ�����ɺ��ٸ�ֵ��arr[0] = ��������;arr[1] = 2;��Ϊjavascript ����������Ϊ�����ͣ����ԣ������ڴ洢���ݵ�ʱ�����������ǿ��Ի�ϴ洢�ġ���һ������������Դ�Number��String��Boolean��Object(JSON��Array...)��null��undefined�ȵȡ�', '2016-07-15', '12', '', '');


create table sContent(
	id int(4) primary key auto_increment,
	studyId int(4),
	content text,
	referencePoint text,
	reserve varchar(80)
);
insert into sContent values(0, 1, '<p><strong>1.����Ĵ���</strong></p><p>js�������ݵķ����кܶ��֣�</p><p class="pre"><span class="odd"><span class="keywords">var</span>&nbsp;&nbsp;arr&nbsp;&nbsp;=&nbsp;&nbsp;<span class="keywords">new</span>&nbsp;&nbsp;Array();&nbsp;&nbsp;<span class=comments>//&nbsp;&nbsp;[]</span> </span><span class="even"><span class="keywords">var</span>&nbsp;&nbsp;arr&nbsp;&nbsp;=&nbsp;&nbsp;<span class="keywords">new</span>&nbsp;&nbsp;Array([10]);&nbsp;&nbsp;<span class=comments>//����һ�����ݵĳ���,����������</span> </span><span class="odd"><span class="keywords">var</span>&nbsp;&nbsp;arr&nbsp;&nbsp;=&nbsp;&nbsp;<span class="keywords">new</span>&nbsp;&nbsp;Array([1,2,3,4]);&nbsp;&nbsp;<span class=comments>//&nbsp;&nbsp;������ֵ������</span> </span><span class="even"><span class="keywords">var</span>&nbsp;&nbsp;arr&nbsp;&nbsp;=&nbsp;&nbsp;[];&nbsp;&nbsp;<span class=comments>//&nbsp;&nbsp;ֱ�Ӷ���һ�����飬Ҳ���Ը�ֵ��ʼ������var&nbsp;&nbsp;arr&nbsp;&nbsp;=&nbsp;&nbsp;[1,2,3];</span> </span></p><p>�������һ�ַ�������õģ�Ҳ����򵥵ġ���Ȼ������ĸ�ֵ��һ��Ҫ�ڴ��������ʱ����ɣ���Ϊ����ĳ����ǿ����������ģ����Կ����ڴ�����ɺ��ٸ�ֵ��</p><p class="pre"><span class="odd">arr[0]&nbsp;&nbsp;=&nbsp;&nbsp;��������;&nbsp;&nbsp;<span class=comments>//&nbsp;&nbsp;[��������]</span> </span><span class="even">arr[1]&nbsp;&nbsp;=&nbsp;&nbsp;2;&nbsp;&nbsp;<span class=comments>//&nbsp;&nbsp;[��������,&nbsp;&nbsp;2]</span> </span></p><p>��Ϊjavascript ����������Ϊ�����ͣ����ԣ������ڴ洢���ݵ�ʱ�����������ǿ��Ի�ϴ洢�ġ���һ������������Դ�Number��String��Boolean��Object(JSON��Array...)��null��undefined�ȵȡ�</p><p><strong>2.�����ȡֵ</strong></p><p>������õ�ȡֵ��ʽ����ͨ��keyȥȡ��Ӧ��ֵ��</p><p class="pre"><span class="odd"><span class="keywords">var</span>&nbsp;&nbsp;names&nbsp;&nbsp;=&nbsp;&nbsp;[<span class=string>"����"</span>,&nbsp;&nbsp;<span class=string>"����"</span>,&nbsp;&nbsp;<span class=string>"����"</span>,&nbsp;&nbsp;<span class=string>"����"</span>]; </span><span class="even"><span class="keywords">var</span>&nbsp;&nbsp;name&nbsp;&nbsp;=&nbsp;&nbsp;names[0];&nbsp;&nbsp;<span class=comments>//&nbsp;&nbsp;����</span> </span><span class="odd"><span class="keywords">var</span>&nbsp;&nbsp;name&nbsp;&nbsp;=&nbsp;&nbsp;names[2];&nbsp;&nbsp;<span class=comments>//&nbsp;&nbsp;����</span> </span></p><p>��Ȼ����������֪��ֵ���ĸ�λ�õ�����½��еĲ�����������ڸ���һ��δ֪�����飬��������Щֵ����ȫȻ��֪����Ӧ������ȡ������Ҫ��ֵ�ˣ�Ī�ţ������������Ǿ������������磬��Ҫ��һ��δ֪��������ȡ�������ġ���λ�ã�</p><p class="pre"><span class="odd"><span class=comments>//&nbsp;&nbsp;var&nbsp;&nbsp;names&nbsp;&nbsp;=&nbsp;&nbsp;["����",&nbsp;&nbsp;"����",&nbsp;&nbsp;"����",&nbsp;&nbsp;"����"];</span> </span><span class="even"><span class="keywords">var</span>&nbsp;&nbsp;&nbsp;&nbsp;namesLength&nbsp;&nbsp;=&nbsp;&nbsp;names.length, </span><span class="odd">&nbsp;&nbsp;&nbsp;&nbsp;index&nbsp;&nbsp;=&nbsp;&nbsp;0; </span><span class="even">for(<span class="keywords">var</span>&nbsp;&nbsp;i&nbsp;&nbsp;=&nbsp;&nbsp;0;&nbsp;&nbsp;i&nbsp;&nbsp;<&nbsp;&nbsp;namesLength;&nbsp;&nbsp;i++){ </span><span class="odd">&nbsp;&nbsp;&nbsp;&nbsp;<span class="keywords">if</span>&nbsp;&nbsp;(names[i]&nbsp;&nbsp;===&nbsp;&nbsp;<span class=string>"����"</span>){ </span><span class="even">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;index&nbsp;&nbsp;=&nbsp;&nbsp;i; </span><span class="odd">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="keywords">break</span>; </span><span class="even">&nbsp;&nbsp;&nbsp;&nbsp;} </span><span class="odd">} </span><span class="even"><span class="keywords">console</span>.<span class="keywords">log</span>(index);&nbsp;&nbsp;<span class=comments>//&nbsp;&nbsp;1</span> </span><span class=comments>//&nbsp;&nbsp;ʹ��for...in..�������飬Ҳ��õ�ͬ����Ч��</span></p>', '', '');



select textTital,releaseDate,zan,content,referencePoint from studyTitle as st inner join sContent as sc on st.id=sc.studyId where sc.id=1;













