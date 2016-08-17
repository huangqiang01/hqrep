// 查询文章title列表
var param = {
	funNo: "10100"
}
Qutils.Qajax(param, function(data) {
	var results = Qutils.checkData(data),
		resLength = results.length,
		str = "",
		seriesJson = {};
	for(var i = 0; i < resLength; i++) {
		var item = results[i],
			contentListNo = item.contentListNo,
			textTital = item.textTital,
			releaseDate = item.releaseDate,
			id = item.id;
		if (contentListNo === "") {
			seriesJson[id] = {time: releaseDate, title: textTital};
		} else if (contentListNo === "0"){
			var serId = seriesJson[id];
			if (serId){
				serId["time"] = releaseDate;
				serId["title"] = textTital;
				continue;
			}
			seriesJson[id] = {time: releaseDate, title: textTital, series: []};
		} else {
			var serId = seriesJson[contentListNo],
				unitJson = {id: id, time: releaseDate, title: textTital};
			if (!serId){
				seriesJson[contentListNo] = {series: []};
			}
			serId["series"].push(unitJson);
		}
	}
	if (seriesJson !== {}){
		// 显示相关数据
		showSeriesList(seriesJson);
	}
}, {type: "get"});


/**
 * 显示相关数据
 * @param {Object} seriesJson
 */
function showSeriesList(seriesJson){
	var str = "";
	for (var _key in seriesJson){
		var item = seriesJson[_key],
			series = item.series,
			series_length = series && series.length,
			title = item.title,
			time = item.time;
		if (typeof series === "object" && series_length > 0){
			str += "<div class='series'><span class='clearfix'><b></b><a href='javascript:void(0)'>";
			str += title + "</a><em>" + time + "</em></span><ul>";
			for (var i = 0; i < series_length; i++){
				var unit = series[i];
				str += "<li class='clearfix'><a href='javascript:void(0)' data-id=" + unit.id + ">" + unit.title + "</a><em>" + unit.time + "</em></li>"
			}
			str += "</ul></div>";
		} else {
			str += "<div><span><a href='javascript:void(0)' data-id=" + _key + ">";
			str += title + "</a><em>" + time + "</em></span></div>";
		}
	}
	$(".list").html(str);
	// 绑定点击栏目事件
	bindClick();
}

/**
 * 绑定栏目
 */
function bindClick(){
	// 
	$(".series").on("click", function(e){
		$(this).toggleClass("active");
		e.stopPropagation();
	})
	
	//
	$("a").on("click", function(e){
		var id = $(this).attr("data-id");
		if (id){
			Qutils.goPage("stcontent.html", {id: id});
			e.stopPropagation();
		}
	});
}

