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

// 查询首页banner
var param = {
	funNo: "1000"
};
var img_length = 0,
	img_url = 0;
Qutils.Qget(param, function(data) {
	var results = Qutils.checkData(data),
		res_lenth = results && results.length;
	img_length = res_lenth;
	img_url = res_lenth;
	for (var i = 0; i < res_lenth; i++) {
		var item = results[i],
			img = new Image();
		img.src = item.addr;
		img.className = "data-img-" + i;
		addImg(img);
	}
});

/**
 * 生成动画随机数
 * 动画随机数[0-2]
 */
function getRandom(range){
	var r =  range ? range : 3;
	var random = Math.random();
	return Math.floor(random * r);
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
		if (img_url === 0){
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
function autoChangeImg(){
	if (changeImgInter) {
		clearInterval(changeImgInter);
		changeImgInter = null;
	}
	changeImgInter = setInterval(function(){
		var random = getRandom(2);
		showNextImg(random);
	}, 5000);
}



/**
 * 增加图片切换效果
 */
function changeImg(){
	$(".s-left").on("click", function(e){
		// 重置图片却换定时器
		autoChangeImg();
		var random = getRandom();
		// 隐藏当前页面
		hideCurrentImg(initImg, random);
		initImg--;
		if (initImg < 0){
			initImg = img_length - 1;
		}
		// 显示下一个页面
		changeImg1(initImg, random);
		e.stopPropagation();
	});
	
	$(".s-right").on("click", function(e){
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
function showNextImg(random){
	// 隐藏当前页面
	hideCurrentImg(initImg, random);
	initImg++;
	if (initImg >= img_length){
		initImg = 0;
	}
	// 显示下一个页面
	changeImg1(initImg, random);
}


/**
 * 隐藏当前页面的动画
 */
function hideCurrentImg(img, random){
	var hideEff = hideEffect[random],
		$img = $(".data-img-" + img),
		dataShow = $img.attr("data-show");
	$img.addClass(hideEff);
	$img.removeClass(dataShow + " active");
	hideImgInter = setTimeout(function(){
		clearTimeout(hideImgInter);
		$img.removeClass(hideEff);
	}, 1400);
}

/**
 * 切换图片
 */
function changeImg1(nextImg, random){
	var $nextImg = $(".data-img-" + nextImg),
		defClass = defaultLocation[random],
		showClass = showEffect[random];
	$nextImg.addClass(defClass+" "+showClass+" active");
	$nextImg.attr("data-show", showClass);
	// 显示图片效果
	removeDfImg = setTimeout(function(){
		clearTimeout(removeDfImg);
		$nextImg.removeClass(defClass);
	}, 400);
	
}




