// 定义变量
var $nowTime = $("#nowTime"),
	$submitI = $("#submitI"),
	$text = $("#text"),
	// 提交类型0-评价，1-建议
	subMark = 0,
	// 当前分页
	nowPage = 1;


// 获取留言
getNewMessage();


// 时间刷新
$nowTime.text(formatDate());
setInterval(function(){
	$nowTime.text(formatDate());
}, 1000);

// 选择留言类别
$("#selectBar>a").on("click", function(e){
	var $this = $(this);
	if ($this.attr("class")){
		return false;
	}
	$this.attr("data-leave") === "0" ? ($submitI.text("提交评价"), subMark = 0) : ($submitI.text("提交建议"), subMark = 1);
	$this.addClass("active").siblings("a").removeClass("active");
	e.stopPropagation();
});

// 提交
$submitI.on("click", function(e){
	var text = $text.val();
	if (text.replace(/ /g, "").length < 5){
		alert("提交的内容必需大于5个字符");
		return false;
	}
	// 提交内容
	submitContent(text);
	e.stopPropagation();
});

/**
 * 获取最新留言
 */
function getNewMessage(){
	var param = {
		funNo: "1003",
		startPage: nowPage
	};
	Qutils.Qget(param, function(data){
		var results = Qutils.checkData(data),
			res_lenth = results && results.length,
			str = "";
		for(var i = 0; i < res_lenth; i++){
			var item = results[i];
			str += "<div class='evaluate'><p class='name'>" + item.edate + " " + item.etime + "</span><p class='neirong'> "+item.evalContent+"</p></div>";
		}
		$(".intro-content").html(str);
	});
	
}

/**
 * 获取当前时间，转为yyyy-MM-dd HH:mm:ss格式
 */
function formatDate(){
	var nowTime = new Date(),
		arr = new Array();
		// 年
		arr.push(nowTime.getFullYear());
		arr.push("-");
		// 月
		arr.push(twoDigit(nowTime.getMonth() + 1));
		arr.push("-");
		// 日
		arr.push(twoDigit(nowTime.getDate()));
		arr.push(" ");
		// 时
		arr.push(twoDigit(nowTime.getHours()));
		arr.push(":");
		// 分
		arr.push(twoDigit(nowTime.getMinutes()));
		arr.push(":");
		// 秒
		arr.push(twoDigit(nowTime.getSeconds()));
	return arr.join("");
}

/**
 * 判断时间是否两位数，如果不是，则补充
 */
function twoDigit(digit){
	return digit < 10 ? "0" + digit : digit;
}

/**
 * 提交输入的内容
 */
function submitContent(text){
	var arrT = $nowTime.text().split(" "),
		param = {
			funNo: "1002",
			date: arrT[0],
			time: arrT[1],
			subMark: subMark,
			text: text
		}
		
	Qutils.Qpost(param, function(data){
		alert(data.error_info);
		if (data.error_no === "0"){
			$text.val("");
			// 刷新最新留言
			getNewMessage();
		}
	});
}
