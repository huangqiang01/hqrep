
var param = {
	funNo: "1001"
};

Qutils.Qget(param, function(data){
	var results = Qutils.checkDate(data),
		res_lenth = results && results.length;
	for(var i = 0; i < res_lenth; i++){
		
	}
});

