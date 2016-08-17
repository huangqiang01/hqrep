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
insert into studyTitle values(0, 1, 1, '', '我爱北京天安门,天安门上太阳升', '我爱北京天安门，天安门上太阳升，伟大领袖毛主席，指引我们向前进，我爱北京天安门，天安门上太阳升，伟大领袖毛主席，指引我们向前进。', '2016-07-15', '12', '', '');
insert into studyTitle values(0, 1, 1, '0', '我爱北京天安门,天安门上太阳升1', '', '2016-07-15', '12', '', '');
insert into studyTitle values(0, 1, 1, '2', '我爱北京天安门,天安门上太阳升2', '111111111我爱北京天安门，天安门上太阳升，伟大领袖毛主席，指引我们向前进，我爱北京天安门，天安门上太阳升，伟大领袖毛主席，指引我们向前进。', '2016-07-15', '12', '', '');

create table sContent(
	id int(4) primary key auto_increment,
	studyId int(4),
	content text,
	referencePoint text,
	reserve varchar(80)
);
insert into sContent values(0, 1, '1970年9月这首歌发表在上海出版的《红小兵歌曲》上，1971年由中央人民广播电台播出，1972年中央新闻电影制片厂拍摄的北京“五一”游园会专题文艺节目把《我爱北京天安门》搬上银幕，随后录制了唱片，1972年，被编入国务院文艺组主编的《战地新歌》第一辑。歌曲越唱越红，被编成各种版本的儿童舞蹈。后来被改编成各种样式、体裁的乐曲（如手风琴、木琴独奏曲等）。1981年被辑入广东花城出版社《抒情歌曲集》。', '', '');
insert into sContent values(0, 2, '这首儿歌经反复使用、加工而成为歌诵性抒情歌曲中的标志性作品，进入了代表那个时代精神的经典作品的行列。美国总统里根访华前，美国艺术团在北京演出的第一个合唱节目，就是《我爱北京天安门》。', '', '');
insert into sContent values(0, 3, '1970年9月这首歌发表在上海出版的《红小兵歌曲》上，1971年由中央人民广播电台播出，1972年中央新闻电影制片厂拍摄的北京“五一”游园会专题文艺节目把《我爱北京天安门》搬上银幕，随后录制了唱片，1972年，被编入国务院文艺组主编的《战地新歌》第一辑。歌曲越唱越红，被编成各种版本的儿童舞蹈。后来被改编成各种样式、体裁的乐曲（如手风琴、木琴独奏曲等）。1981年被辑入广东花城出版社《抒情歌曲集》。这首儿歌经反复使用、加工而成为歌诵性抒情歌曲中的标志性作品，进入了代表那个时代精神的经典作品的行列。美国总统里根访华前，美国艺术团在北京演出的第一个合唱节目，就是《我爱北京天安门》。金月苓文革后（1977年）就读于中央音乐学院，与谭盾、陈佐湟等日后成为著名作曲家、指挥家的学生同学，毕业后任中国唱片公司上海公司音乐编辑。据1999年的报道，金月苓已创作有各类抒情歌曲二、三百首，其中一些作品获得全国音乐比赛的各种奖项。', '', '');



select textTital,releaseDate,zan,content,referencePoint from studyTitle as st inner join sContent as sc on st.id=sc.studyId where sc.id=1;

/**************照片***************/
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

insert into photo values(0, 0, '小树', '手机', 'f/10.0, 1/125s, ISO:200', '../../photo/sapling.jpg', '960', '640', '2016-07-15', '10:09:45', '清晨的小树，在阳关的照射下，绿油油的', '1', '');
insert into photo values(0, 0, '清晨', '手机', 'f/4.5, 1/2s, ISO:100', '../../photo/morning.jpg', '960', '720', '2016-07-15', '05:45:45', '海滩的清晨，太阳将冲出层层乌云，放出万丈光芒', '0', '');
insert into photo values(0, 0, '小玩具', '相机', 'f/16.0, 1/4s, ISO:250', '../../photo/plaything.jpg', '960', '640', '2016-08-15', '10:10:45', '微笑的玩具，真可爱', '1', '');
insert into photo values(0, 0, '小树', '手机', 'f/10.0, 1/125s, ISO:200', '../../photo/sapling.jpg', '960', '640', '2016-07-15', '10:09:45', '清晨的小树，在阳关的照射下，绿油油的', '1', '');
insert into photo values(0, 0, '清晨', '手机', 'f/4.5, 1/2s, ISO:100', '../../photo/morning.jpg', '960', '720', '2016-07-15', '05:45:45', '海滩的清晨，太阳将冲出层层乌云，放出万丈光芒', '1', '');
insert into photo values(0, 0, '小玩具', '相机', 'f/16.0, 1/4s, ISO:250', '../../photo/plaything.jpg', '960', '640', '2016-08-15', '10:10:45', '微笑的玩具，真可爱', '1', '');
insert into photo values(0, 0, '小玩具', '相机', 'f/16.0, 1/4s, ISO:250', '../../photo/plaything.jpg', '960', '640', '2016-08-15', '10:10:45', '微笑的玩具，真可爱', '1', '');
insert into photo values(0, 0, '小树', '手机', 'f/10.0, 1/125s, ISO:200', '../../photo/sapling.jpg', '960', '640', '2016-07-15', '10:09:45', '清晨的小树，在阳关的照射下，绿油油的', '1', '');
insert into photo values(0, 0, '清晨', '手机', 'f/4.5, 1/2s, ISO:100', '../../photo/morning.jpg', '960', '720', '2016-07-15', '05:45:45', '海滩的清晨，太阳将冲出层层乌云，放出万丈光芒', '1', '');
insert into photo values(0, 0, '小玩具', '相机', 'f/16.0, 1/4s, ISO:250', '../../photo/plaything.jpg', '960', '640', '2016-08-15', '10:10:45', '微笑的玩具，真可爱', '1', '');
insert into photo values(0, 0, '小玩具', '相机', 'f/16.0, 1/4s, ISO:250', '../../photo/plaything.jpg', '960', '640', '2016-08-15', '10:10:45', '微笑的玩具，真可爱', '1', '');
insert into photo values(0, 0, '小树', '手机', 'f/10.0, 1/125s, ISO:200', '../../photo/sapling.jpg', '960', '640', '2016-07-15', '10:09:45', '清晨的小树，在阳关的照射下，绿油油的', '1', '');
insert into photo values(0, 0, '清晨', '手机', 'f/4.5, 1/2s, ISO:100', '../../photo/morning.jpg', '960', '720', '2016-07-15', '05:45:45', '海滩的清晨，太阳将冲出层层乌云，放出万丈光芒', '1', '');
insert into photo values(0, 0, '小玩具', '相机', 'f/16.0, 1/4s, ISO:250', '../../photo/plaything.jpg', '960', '640', '2016-08-15', '10:10:45', '微笑的玩具，真可爱', '1', '');
insert into photo values(0, 0, '小玩具', '相机', 'f/16.0, 1/4s, ISO:250', '../../photo/plaything.jpg', '960', '640', '2016-08-15', '10:10:45', '微笑的玩具，真可爱', '1', '');
insert into photo values(0, 0, '小树', '手机', 'f/10.0, 1/125s, ISO:200', '../../photo/sapling.jpg', '960', '640', '2016-07-15', '10:09:45', '清晨的小树，在阳关的照射下，绿油油的', '1', '');
insert into photo values(0, 0, '清晨', '手机', 'f/4.5, 1/2s, ISO:100', '../../photo/morning.jpg', '960', '720', '2016-07-15', '05:45:45', '海滩的清晨，太阳将冲出层层乌云，放出万丈光芒', '1', '');
insert into photo values(0, 0, '小玩具', '相机', 'f/16.0, 1/4s, ISO:250', '../../photo/plaything.jpg', '960', '640', '2016-08-15', '10:10:45', '微笑的玩具，真可爱', '1', '');
insert into photo values(0, 0, '小玩具', '相机', 'f/16.0, 1/4s, ISO:250', '../../photo/plaything.jpg', '960', '640', '2016-08-15', '10:10:45', '微笑的玩具，真可爱', '1', '');
insert into photo values(0, 0, '小树', '手机', 'f/10.0, 1/125s, ISO:200', '../../photo/sapling.jpg', '960', '640', '2016-07-15', '10:09:45', '清晨的小树，在阳关的照射下，绿油油的', '1', '');
insert into photo values(0, 0, '清晨', '手机', 'f/4.5, 1/2s, ISO:100', '../../photo/morning.jpg', '960', '720', '2016-07-15', '05:45:45', '海滩的清晨，太阳将冲出层层乌云，放出万丈光芒', '1', '');
insert into photo values(0, 0, '小玩具', '相机', 'f/16.0, 1/4s, ISO:250', '../../photo/plaything.jpg', '960', '640', '2016-08-15', '10:10:45', '微笑的玩具，真可爱', '1', '');




















