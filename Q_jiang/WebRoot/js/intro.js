
var allIntro = {},
	curIntro = {};


var param = {
	funNo: "10001"
};

Qutils.Qget(param, function(data){
	var results = Qutils.checkData(data),
		res_lenth = results && results.length,
		str = '<ul class="clearfix">';
	for(var i = 0; i < res_lenth; i++){
		var item = results[i];
		i === 0 
		? (str += '<li class="active" data-id=' + item.id + '><a href="javascript:void(0)" >'+item.prName+'</a></li>',curIntro = item) 
		: (str += '<li data-id=' + item.id + '><a href="javascript:void(0)">'+item.prName+'</a></li>');
		allIntro[item.id] = item;
	}
	str += '</ul>';
	$(".side-bar").html(str);
	// 绑定菜单选择事件
	bindSelectBar();
	// 显示介绍内容
	$(".intro-content").html(curIntro.prContent).show();
});

/**
 * 绑定菜单选择事件
 */
function bindSelectBar(){
	$(".side-bar li").on("click", function(e){
		var $this = $(this);
		if ($this.attr("class")){
			return false;
		}
		$this.addClass("active").siblings("li").removeClass("active");
		curIntro = allIntro[$this.attr("data-id")];
		$(".intro-content").html(curIntro.prContent);
		e.stopPropagation();
	});
}

/**
 * 显示菜单相应的介绍内容
 */
function showIntro(){
	$(".intro-content").html(curIntro.prContent);
}

