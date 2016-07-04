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



insert into websiteEvaluation values(0, )

