"use strict";

// 获取页面传参
var id = Qutils.getParam("id");

// 查询文章内容
var param = {
	funNo: "10102",
	id: id
}
Qutils.Qajax(param, function(data) {
	var results = Qutils.checkData(data),
		str = "",
		item = results[0];
	if (item){
		str += "<div class='title'><p>" + item.textTital + "</p>";
		str += "<span>" + item.releaseDate + "</span></div>";
		str += "<div class='content'>" + item.content + "</div>";
	}
	$(".article").html(str);
	
}, {type: "get"});