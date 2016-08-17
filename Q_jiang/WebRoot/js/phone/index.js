"use strict";

// 初始化页面参数
	// 当前页
var currentPage = 1,
	// 是否加载下一页
	isAddNext = true,
	// 是否最后一页
	isLastPage = false,
	$window = $(window),
	$page = $(".page"),
	// window 的高度
	winHeight = $window.height(),
	imgWidth = $window.width() * 0.99,
	// 页面内容的高度
	pageHeight = null,
	// 图片信息集合
	imgArr = [];

// 添加标题动态
$(".title").addClass("active");

// 查询照片
getPhotoInfo(currentPage);

// 页面滚动事件
$window.on("scroll", function(){
	requestAnimationFrame(function(){
		var scrollTop = $window.scrollTop(),
			winH = winHeight;
		// 加载下一页
		if (isAddNext && pageHeight - winHeight - 320 <= scrollTop){
			isAddNext = false;
			currentPage++;
			getPhotoInfo(currentPage);
		}
		// 懒加载图片
		lazyAddImg(scrollTop + winH);
	});
});

/**
 * 获取照片信息
 * @param {Object} currentPage
 */
function getPhotoInfo(currentPage){
	var param = {
		funNo: "10200",
		currentPage: currentPage
	};
	Qutils.Qajax(param, function(data){
		var results = Qutils.checkData(data),
			resLenth = results && results.length,
			str = "";
		var imgW = imgWidth;
		for(var i = 0; i < resLenth; i++){
			var item = results[i],
				imgH = item.imgHeight / item.imgWidth * imgW,
				imgId = "img" + currentPage + i;
			str += "<div class='img'><p><strong>"+item.imgName+"</strong>&nbsp;&nbsp;&nbsp;&nbsp;<span>"+item.shotTypes+"</span></p>";
			str += "<div class='show-img lazy'><img id="+imgId+" data-img="+item.imgUrl+" style='height: "+imgH+"px' src='' />";
			str += "<span class='img-info'><ul><li class='iconfont exposure icon-rili'>"+item.imgInfo+"</li>";
			str += "<li class='iconfont time icon-xiangji'>"+item.imgDate+" "+item.imgTime+"</li></ul></span>";
			str += "<div class='load-img'></div></div><div class='introduce'><p>"+item.introduce+"</p></div></div>";
		}
		
		if (currentPage === 1){
			$(".img-content").html(str);
			// 懒加载图片的集合
			getImgArr();
			// 第一次加载
			lazyAddImg(winHeight);
		} else {
			$(".img-content").append(str);
			// 懒加载图片的集合
			getImgArr();
		}
		
		pageHeight = $page.height();
		if (resLenth < 10){
			isLastPage = true;
			isAddNext = false;
		} else {
			isAddNext = true;
		}
		// 绑定点击图片事件
		clickImg();
	}, {type: "get"});
}

/**
 * 获取需要懒加载图片的集合
 */
function getImgArr(){
	$(".lazy").each(function(){
		var imgInfo = {},
			$this = $(this);
		imgInfo.target = $this;
		imgInfo.top = $this.position().top;
		imgArr.push(imgInfo);
		$this.removeClass("lazy");
	});
}

/**
 * 懒加载显示图片
 * @param {Object} scrollTop
 */
function lazyAddImg(scrollTop){
	var arr = imgArr;
	var imgArrLength = arr.length;
	if (imgArrLength <= 0){
		if (isLastPage){
			$window.off("scroll");
		}
		return false;
	}
	for(var i = 0; i < imgArrLength; i++){
		var item = arr[0],
			top = item.top;
		if (top < scrollTop){
			var $target = item.target,
				$img = $target.find("img"),
				img = new Image();
			img.src = $img.attr("data-img");
			img.id = $img.attr("id");
			// 删除已经加载的图片
			arr.splice(0, 1);
			img.onload = function(){
				var _img = this,
					$_img = $("#" + _img.id);
				$_img.attr("src", _img.src);
				$_img.siblings(".load-img").addClass("hide");
			};
		} else {
			break;
		}
	}
}

/**
 * 点击图片，显示照片相关信息
 */
function clickImg(){
	$(".load-img").off("click");
	$(".load-img").on("click", function(){
		var $this = $(this);
		if (!$this.hasClass("hide")){
			return false;
		}
		var $imgInfo = $this.siblings(".img-info");
		$imgInfo.removeClass("active hide");
		$imgInfo.addClass("active");
		var showInfo = setTimeout(function(){
			if (showInfo){
				clearTimeout(showInfo);
				showInfo = null;
			}
			$imgInfo.addClass("hide");
		}, 6000);
	});
}



