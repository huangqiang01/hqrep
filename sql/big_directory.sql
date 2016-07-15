create database app;

use app;


/********首页banner********/
create table bannerImg(
	id int(4) primary key auto_increment,
	addr varchar(80),
	iName varchar(60),
	iExplain varchar(200),
	isShow varchar(4),
	showOrder varchar(4),
	reserve varchar(80)
);

insert into bannerImg values(0,'img/banner-1.jpg','天空','我爱北京天安门，天安门上太阳升','1','0','');
insert into bannerImg values(0,'img/banner-2.jpg','天空1','我爱北京天安门，天安门上太阳升1','1','0','');
insert into bannerImg values(0,'img/banner-3.jpg','天空2','我爱北京天安门，天安门上太阳升2','1','0','');


/********相关介绍********/
create table presentations(
	id int(4) primary key auto_increment,
	prName varchar(20),
	prContent text,
	isShow varchar(4),
	reserve varchar(80)
);

insert into presentations values(0,'网站介绍','<p>这个我第一次也是第一个为自己写的网站，写一个属于自己的网站的计划在几年前就已经形成了，但是一直忙于工作的事，没有时间真正的去投入。最近新换了一家公司，在完成公司的任务外，自己的自由时间也比较多，所以想继续完成自己的网站。</p><p>对于自己的网站，主要还是放一些自己喜欢的东西——生活照片、工作知识以及爱好的事物等等。</p><p>网站的界面（UI）是自己设计的，对于一个对<a target="_blank" title="http://baike.baidu.com/link?url=kxGcnK8xO_-gYiZiyxDRN6Cp4YLn0q288RXz1no0UfbIXW-ESnP57VoSa_p8dx__dAROx7D5wzmLtVAyCX-HXlMjHitO1zDgqy_sZg7uG13" href="http://baike.baidu.com/link?url=kxGcnK8xO_-gYiZiyxDRN6Cp4YLn0q288RXz1no0UfbIXW-ESnP57VoSa_p8dx__dAROx7D5wzmLtVAyCX-HXlMjHitO1zDgqy_sZg7uG13">美（Good-looking|Beautiful|Pretty）</a>没有定义的人来说，这个是一个很头痛的事--!，网站的色调主要取自于<a href="javascript:void(0)" title="丘比龙">丘比龙①</a>的配色，但是，在做完界面（UI）之后，我发现这个风格...，唉...，算了。也许在网站风格上面，我这里还有很多要改进的地方，这个东西，对我来说，切实是一个很大的挑战。</p><p>为什么要写一个属于自己的网站？这个可能是自己的爱好，也可能是对自己能力的测试，也可能是为了分享自己的学习的内容等等。不管怎么样，它都是对自己的一个挑战，至少你要涉及界面（UI），前端，后端数据（接口，数据收集）这3个方面。</p><br /><div class="annotation clearfix"><img src="../img/qiubilong.gif" /><span>①丘比龙：丘比龙是吕鹏在2004年设计的卡通人物，传说丘比龙是丘比特的弟弟，丘比龙的胸前也有一颗爱之心的印记。虽然他有两只翅膀，但因为喜欢吃甜甜圈，导致身体太胖，所以飞不起来。</span></div>','1', '');
insert into presentations values(0,'个人介绍','<p>这个人很懒，什么都没有留下</p>','1', '');
insert into presentations values(0,'其他','<p>我爱北京天安门，天安门上太阳升</p>','1', '');

/*****网站评价*******/
create table websiteEvaluation(
	id int(4) primary key auto_increment,
	etime varchar(20),
	edate varchar(20),
	evalContent text,
	ip varchar(60),
	reserve varchar(80)
);
/*****网站建议*******/
create table websiteSuggest(
	id int(4) primary key auto_increment,
	etime varchar(20),
	edate varchar(20),
	suggestContent text,
	ip varchar(60),
	reserve varchar(80)
);

/***********内容分类************/
create table classification(
	id int(4) primary key auto_increment,
	className varchar(40),
	reserve varchar(80)
);
insert into classification values(0, '笔记', '');
insert into classification values(0, '生活', '');
insert into classification values(0, '业余', '');
insert into classification values(0, '其他', '');

/**************内容系列分类***************/
create table seriesClass(
	id int(4) primary key auto_increment,
	classId int(4),
	seriesName varchar(40),
	reserve varchar(80)
);
insert into seriesClass values(0, 1, 'js', '');
insert into seriesClass values(0, 1, 'css', '');
insert into seriesClass values(0, 1, '综合', '');
insert into seriesClass values(0, 2, '记录', '');
insert into seriesClass values(0, 3, '招聘', '');
insert into seriesClass values(0, 4, '摘抄', '');



/**************学习***************/
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
insert into studyTitle values(0, 1, 1, '', 'javascript 之数组操作', 'js创建数据的方法有很多种：var arr = new Array();var arr = new Array([10]);var arr = new Array([1,2,3,4]);var arr = [];其中最后一种方法是最常用的，也是最简单的。当然，数组的赋值不一定要在创建数组的时候完成，因为数组的长度是可以自增长的，所以可以在创建完成后再赋值：arr[0] = “张三”;arr[1] = 2;因为javascript 的数据类型为弱类型，所以，数组在存储数据的时候，数据类型是可以混合存储的。即一个数组里面可以存Number，String，Boolean，Object(JSON，Array...)，null，undefined等等。', '2016-07-15', '12', '', '');


create table sContent(
	id int(4) primary key auto_increment,
	studyId int(4),
	content text,
	referencePoint text,
	reserve varchar(80)
);
insert into sContent values(0, 1, '<p><strong>1.数组的创建</strong></p><p>js创建数据的方法有很多种：</p><p class="pre"><span class="odd"><span class="keywords">var</span>&nbsp;&nbsp;arr&nbsp;&nbsp;=&nbsp;&nbsp;<span class="keywords">new</span>&nbsp;&nbsp;Array();&nbsp;&nbsp;<span class=comments>//&nbsp;&nbsp;[]</span> </span><span class="even"><span class="keywords">var</span>&nbsp;&nbsp;arr&nbsp;&nbsp;=&nbsp;&nbsp;<span class="keywords">new</span>&nbsp;&nbsp;Array([10]);&nbsp;&nbsp;<span class=comments>//定义一个数据的长度,但不是上限</span> </span><span class="odd"><span class="keywords">var</span>&nbsp;&nbsp;arr&nbsp;&nbsp;=&nbsp;&nbsp;<span class="keywords">new</span>&nbsp;&nbsp;Array([1,2,3,4]);&nbsp;&nbsp;<span class=comments>//&nbsp;&nbsp;定义有值的数组</span> </span><span class="even"><span class="keywords">var</span>&nbsp;&nbsp;arr&nbsp;&nbsp;=&nbsp;&nbsp;[];&nbsp;&nbsp;<span class=comments>//&nbsp;&nbsp;直接定义一个数组，也可以赋值初始参数：var&nbsp;&nbsp;arr&nbsp;&nbsp;=&nbsp;&nbsp;[1,2,3];</span> </span></p><p>其中最后一种方法是最常用的，也是最简单的。当然，数组的赋值不一定要在创建数组的时候完成，因为数组的长度是可以自增长的，所以可以在创建完成后再赋值：</p><p class="pre"><span class="odd">arr[0]&nbsp;&nbsp;=&nbsp;&nbsp;“张三”;&nbsp;&nbsp;<span class=comments>//&nbsp;&nbsp;[“张三”]</span> </span><span class="even">arr[1]&nbsp;&nbsp;=&nbsp;&nbsp;2;&nbsp;&nbsp;<span class=comments>//&nbsp;&nbsp;[“张三”,&nbsp;&nbsp;2]</span> </span></p><p>因为javascript 的数据类型为弱类型，所以，数组在存储数据的时候，数据类型是可以混合存储的。即一个数组里面可以存Number，String，Boolean，Object(JSON，Array...)，null，undefined等等。</p><p><strong>2.数组的取值</strong></p><p>数组最常用的取值方式就是通过key去取对应的值，</p><p class="pre"><span class="odd"><span class="keywords">var</span>&nbsp;&nbsp;names&nbsp;&nbsp;=&nbsp;&nbsp;[<span class=string>"张三"</span>,&nbsp;&nbsp;<span class=string>"李四"</span>,&nbsp;&nbsp;<span class=string>"王二"</span>,&nbsp;&nbsp;<span class=string>"麻子"</span>]; </span><span class="even"><span class="keywords">var</span>&nbsp;&nbsp;name&nbsp;&nbsp;=&nbsp;&nbsp;names[0];&nbsp;&nbsp;<span class=comments>//&nbsp;&nbsp;张三</span> </span><span class="odd"><span class="keywords">var</span>&nbsp;&nbsp;name&nbsp;&nbsp;=&nbsp;&nbsp;names[2];&nbsp;&nbsp;<span class=comments>//&nbsp;&nbsp;王二</span> </span></p><p>当然，这是在你知道值在哪个位置的情况下进行的操作。如果现在给你一个未知的数组，里面有哪些值，你全然不知，那应该怎样取到你想要的值了？莫慌，接下来，我们就来看看。假如，你要从一个未知的数组中取出“李四”的位置：</p><p class="pre"><span class="odd"><span class=comments>//&nbsp;&nbsp;var&nbsp;&nbsp;names&nbsp;&nbsp;=&nbsp;&nbsp;["张三",&nbsp;&nbsp;"李四",&nbsp;&nbsp;"王二",&nbsp;&nbsp;"麻子"];</span> </span><span class="even"><span class="keywords">var</span>&nbsp;&nbsp;&nbsp;&nbsp;namesLength&nbsp;&nbsp;=&nbsp;&nbsp;names.length, </span><span class="odd">&nbsp;&nbsp;&nbsp;&nbsp;index&nbsp;&nbsp;=&nbsp;&nbsp;0; </span><span class="even">for(<span class="keywords">var</span>&nbsp;&nbsp;i&nbsp;&nbsp;=&nbsp;&nbsp;0;&nbsp;&nbsp;i&nbsp;&nbsp;<&nbsp;&nbsp;namesLength;&nbsp;&nbsp;i++){ </span><span class="odd">&nbsp;&nbsp;&nbsp;&nbsp;<span class="keywords">if</span>&nbsp;&nbsp;(names[i]&nbsp;&nbsp;===&nbsp;&nbsp;<span class=string>"李四"</span>){ </span><span class="even">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;index&nbsp;&nbsp;=&nbsp;&nbsp;i; </span><span class="odd">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="keywords">break</span>; </span><span class="even">&nbsp;&nbsp;&nbsp;&nbsp;} </span><span class="odd">} </span><span class="even"><span class="keywords">console</span>.<span class="keywords">log</span>(index);&nbsp;&nbsp;<span class=comments>//&nbsp;&nbsp;1</span> </span><span class=comments>//&nbsp;&nbsp;使用for...in..遍历数组，也会得到同样的效果</span></p>', '', '');



select textTital,releaseDate,zan,content,referencePoint from studyTitle as st inner join sContent as sc on st.id=sc.studyId where sc.id=1;













