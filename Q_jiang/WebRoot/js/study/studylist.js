
// 查询文章title列表
var param = {
	funNo: "10100"
}
Qutils.Qajax(param, function(data){
	var results = Qutils.checkData(data),
	resLength = results.length,
	str = "";
	for(var i = 0; i < resLength; i++){
		
		str += "<div><span><a href='javascript:void(0)'></a></span></div>";
	}
}, {type: "get"});