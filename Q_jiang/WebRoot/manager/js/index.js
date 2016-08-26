"use strict";

// 登录按钮
$("#sbuBtn").on("click", function(e){
	var name = $("#name").val(),
		password = $("#password").val(),
		check = $("#check").val();
	if (checkInput(name, password, check)){
		var param = {
			funNo: "11000",
			name: name,
			password: password,
			check: check
		};
		Qutils.Qajax(param, function(data){
			if (data.error_no === "0"){
				Qutils.goPage("addPhoto");
			} else {
				alert(data.error_info);
			}
		});
	}
	e.stopPropagation();
});

// 键盘事件
$(window).on("keyup", function(e){
	if (e.keyCode === 13){
		
	}
});

/**
 * 验证信息输入的合法性
 * @param {Object} name
 * @param {Object} password
 * @param {Object} check
 */
function checkInput(name, password, check){
	var mark = false;
	if (!name){
		alert("用户名不能为空");
		mark = false;
	} else if (!password){
		alert("密码不能为空");
		mark = false;
	} else if (!check){
		alert("不能为空");
		mark = false;
	} else {
		mark = true;
	}
	return mark;
}

