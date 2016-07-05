//初始显示图片
var initImg = 0,
	// 图片切换定时器
	changeImgInter = null;

// 查询首页banner
var param = {
	funNo: "1000"
};
var img_length = 0;
Qutils.Qget(param, function(data) {
	var results = Qutils.checkData(data),
		res_lenth = results && results.length;
	img_length = res_lenth;
	for (var i = 0; i < res_lenth; i++) {
		var item = results[i],
			img = new Image();
		img.src = item.addr;
		img.className = "data-img-" + i;
		addImg(img);
	}
	// 增加图片切换效果
	changeImg();
});

/**
 * 判断图片是否加载完成
 * @param {Object} img
 * @param {Object} length
 */
function addImg(img) {
	img.onload = function() {
		img_length--;
		$("." + img.className).attr("src", img.src);
		if (img_length === 0){
			autoChangeImg(img_length);
		}
	}
}

/**
 * 图片自动切换
 */
function autoChangeImg(length){
	$(".data-img-0").addClass("rotate-tran-show");
}



/**
 * 增加图片切换效果
 */
function changeImg(){
	$(".s-left").on("click", function(e){
		
		e.stopPropagation();
	});
	
	$(".s-right").on("click", function(e){
		
		e.stopPropagation();
	});
	
}
