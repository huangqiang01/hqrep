//初始显示图片
var initImg = 0,
	// 图片切换定时器
	changeImgInter = null,
	// 隐藏图片定时器
	hideImgInter = null,
	// 移除默认图片属性的定时器
	removeDfImg = null;

// 初始化图片的默认位置和动态效果
var defaultLocation = ["init0", "init1", "init2"],
	showEffect = ["opacity-show", "translate-show", "rotate-tran-show"],
	hideEffect = ["rotate-tran-hide", "opacity-hide", "translate-hide"];

// 获取首页最新评价
//showNewSugg();
// 获取首页推荐文章
getRecommendContent();
// 获取首页banner图片
var param = {
		funNo: "10000"
	},
	img_length = 0,
	img_url = 0;

Qutils.Qajax(param, function(data) {
	var results = Qutils.checkData(data),
		res_lenth = results && results.length;
	img_length = res_lenth;
	img_url = res_lenth;
	for(var i = 0; i < res_lenth; i++) {
		var item = results[i],
			img = new Image();
		img.src = item.addr;
		img.className = "data-img-" + i;
		addImg(img);
	}
}, {type: "get"});

/**
 * 获取首页推荐的内容
 */
function getRecommendContent(){
	var param = {
		funNo: "10101"
	}
	Qutils.Qajax(param, function(data){
		var results = Qutils.checkData(data),
			res_length = results.length,
			str = "";
		if (res_length > 0){
			for(var i = 0; i < res_length; i++){
				var item = results[i];
				str += "<div class='lan'><span class='title'><a href='javascript:void(0)' data-id="+item.id+">"+item.textTital+"</a><em>"+item.releaseDate+"</em></span>";
				str += "<div class='article'><p>"+item.sAbstract+"</p></div><ul class='clearfix'>";
				str += "<li><a href='javascript:void(0)' class='zan' data-id="+item.id+">赞(<e>"+item.zan+"</e>)</a></li><li><a href='javascript:void(0)' class='addpin' data-id="+item.id+">插一脚</a></li>";
				str += "<li><a href='javascript:void(0)' class='report' data-id="+item.id+">举报</a></li></ul></div>";
			}
		}
		$(".neirong").html(str);
		// 点击
		bindListClick();
	}, {type: "get"});
	
}

/**
 * 绑定推荐点击事件
 */
function bindListClick(){
	// title
	$(".neirong .title>a").on("click", function(e) {
		var id = $(this).attr("data-id");
		Qutils.goPage("html/study/stcontent", {id: id});
		e.stopPropagation();
	});
	// 赞
	$(".zan").on("click", function(e) {
		var $this = $(this),
			id = $this.attr("data-id");
		// 点赞
		addZan(id, $this);
		e.stopPropagation();
	});
	// 插一脚
	$(".addpin").on("click", function(e) {
		var id = $(this).attr("data-id");
//		Qutils.goPage("html/study/stcontent", {id: id});
		e.stopPropagation();
	});
	// 举报
	$(".report").on("click", function(e) {
		var id = $(this).attr("data-id");
//		Qutils.goPage("html/study/stcontent", {id: id});
		e.stopPropagation();
	});
}

/**
 * 判断图片是否加载完成
 * @param {Object} img
 * @param {Object} length
 */
function addImg(img) {
	img.onload = function() {
		img_url--;
		$("." + img.className).attr("src", img.src);
		if(img_url === 0) {
			// 显示第一个图片
			changeImg1(0, 2);
			// 自动切换图片
			autoChangeImg();
			// 手动图片切换效果
			changeImg();
		}
	}
}

/**
 * 图片自动切换
 * --重置图片却换定时器
 */
function autoChangeImg() {
	if(changeImgInter) {
		clearInterval(changeImgInter);
		changeImgInter = null;
	}
	changeImgInter = setInterval(function() {
		var random = getRandom(2);
		showNextImg(random);
	}, 5000);
}

/**
 * 生成动画随机数
 * 动画随机数[0-2]
 */
function getRandom(range) {
	var r = range ? range : 3;
	var random = Math.random();
	return Math.floor(random * r);
}

/**
 * 增加图片切换效果
 */
function changeImg() {
	$(".s-left").on("click", function(e) {
		// 重置图片却换定时器
		autoChangeImg();
		var random = getRandom();
		// 隐藏当前页面
		hideCurrentImg(initImg, random);
		initImg--;
		if(initImg < 0) {
			initImg = img_length - 1;
		}
		// 显示下一个页面
		changeImg1(initImg, random);
		e.stopPropagation();
	});

	$(".s-right").on("click", function(e) {
		// 重置图片却换定时器
		autoChangeImg();
		showNextImg(getRandom());
		e.stopPropagation();
	});
}

/**
 * 显示下一个图片
 * 手动--自动
 */
function showNextImg(random) {
	// 隐藏当前页面
	hideCurrentImg(initImg, random);
	initImg++;
	if(initImg >= img_length) {
		initImg = 0;
	}
	// 显示下一个页面
	changeImg1(initImg, random);
}

/**
 * 隐藏当前页面的动画
 */
function hideCurrentImg(img, random) {
	var hideEff = hideEffect[random],
		$img = $(".data-img-" + img),
		dataShow = $img.attr("data-show");
	$img.addClass(hideEff);
	$img.removeClass(dataShow + " active");
	hideImgInter = setTimeout(function() {
		if(hideImgInter) {
			clearTimeout(hideImgInter);
			hideImgInter = null;
		}
		$img.removeClass(hideEff);
	}, 800);
}

/**
 * 切换图片
 */
function changeImg1(nextImg, random) {
	var $nextImg = $(".data-img-" + nextImg),
		defClass = defaultLocation[random],
		showClass = showEffect[random];
	$nextImg.addClass(defClass + " " + showClass + " active");
	$nextImg.attr("data-show", showClass);
	// 显示图片效果
	removeDfImg = setTimeout(function() {
		if(removeDfImg) {
			clearTimeout(removeDfImg);
			removeDfImg = null;
		}
		$nextImg.removeClass(defClass);
	}, 400);
}
/**
 * 显示最新评论
 */
function showNewSugg() {
	var param = {
		funNo: "10003",
		isFirstPage: "1"
	};
	Qutils.Qajax(param, function(data) {
		var results = Qutils.checkData(data),
			res_lenth = results && results.length,
			str = "";
		for(var i = 0; i < res_lenth; i++) {
			var item = results[i];
			str += "<p><a href='javascript:void(0)'>";
			str += item.evalContent;
			str += "</a></p>";
		}
		$("#newEvaluate").html(str);
		// 点击评论
		$("#newEvaluate>p").on("click", function(e) {
			Qutils.goPage("html/firstimpress.html");
			e.stopPropagation();
		});
	}, {type: "get"});
}

/**
 * 点赞
 */
function addZan(id, $this){
	var param = {
		funNo: "10300",
		id: id
	}
	Qutils.Qajax(param, function(data){
		if (data.error_no === "0"){
			var $e = $this.find("e"),
				zan = +$e.html();
			$e.html(zan + 1);
		} else {
			alert(error_info);
		}
	});
}
