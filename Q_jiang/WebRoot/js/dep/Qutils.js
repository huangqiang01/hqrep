"use strict";
if (typeof jQuery === "undefined") {
	throw new Error("Qutils's JavaScript requires jQuery");
}

!(function() {
	/**
	 * des加密源码
	 */
	var Aes={};Aes.cipher=function(n,j){var o=4;var k=j.length/o-1;var l=[[],[],[],[]];for(var m=0;m<4*o;m++){l[m%4][Math.floor(m/4)]=n[m]}l=Aes.addRoundKey(l,j,0,o);for(var p=1;p<k;p++){l=Aes.subBytes(l,o);l=Aes.shiftRows(l,o);l=Aes.mixColumns(l,o);l=Aes.addRoundKey(l,j,p,o)}l=Aes.subBytes(l,o);l=Aes.shiftRows(l,o);l=Aes.addRoundKey(l,j,k,o);var i=new Array(4*o);for(var m=0;m<4*o;m++){i[m]=l[m%4][Math.floor(m/4)]}return i};Aes.keyExpansion=function(m){var o=4;var q=m.length/4;var l=q+6;var n=new Array(o*(l+1));var k=new Array(4);for(var p=0;p<q;p++){var r=[m[4*p],m[4*p+1],m[4*p+2],m[4*p+3]];n[p]=r}for(var p=q;p<(o*(l+1));p++){n[p]=new Array(4);for(var i=0;i<4;i++){k[i]=n[p-1][i]}if(p%q==0){k=Aes.subWord(Aes.rotWord(k));for(var i=0;i<4;i++){k[i]^=Aes.rCon[p/q][i]}}else{if(q>6&&p%q==4){k=Aes.subWord(k)}}for(var i=0;i<4;i++){n[p][i]=n[p-q][i]^k[i]}}return n};Aes.subBytes=function(c,f){for(var h=0;h<4;h++){for(var g=0;g<f;g++){c[h][g]=Aes.sBox[c[h][g]]}}return c};Aes.shiftRows=function(j,g){var c=new Array(4);for(var i=1;i<4;i++){for(var h=0;h<4;h++){c[h]=j[i][(h+i)%g]}for(var h=0;h<4;h++){j[i][h]=c[h]}}return j};Aes.mixColumns=function(b,i){for(var a=0;a<4;a++){var k=new Array(4);var l=new Array(4);for(var c=0;c<4;c++){k[c]=b[c][a];l[c]=b[c][a]&128?b[c][a]<<1^283:b[c][a]<<1}b[0][a]=l[0]^k[1]^l[1]^k[2]^k[3];b[1][a]=k[0]^l[1]^k[2]^l[2]^k[3];b[2][a]=k[0]^k[1]^l[2]^k[3]^l[3];b[3][a]=k[0]^l[0]^k[1]^k[2]^l[3]}return b};Aes.addRoundKey=function(j,h,l,c){for(var k=0;k<4;k++){for(var i=0;i<c;i++){j[k][i]^=h[l*4+i][k]}}return j};Aes.subWord=function(d){for(var c=0;c<4;c++){d[c]=Aes.sBox[d[c]]}return d};Aes.rotWord=function(e){var f=e[0];for(var d=0;d<3;d++){e[d]=e[d+1]}e[3]=f;return e};Aes.sBox=[99,124,119,123,242,107,111,197,48,1,103,43,254,215,171,118,202,130,201,125,250,89,71,240,173,212,162,175,156,164,114,192,183,253,147,38,54,63,247,204,52,165,229,241,113,216,49,21,4,199,35,195,24,150,5,154,7,18,128,226,235,39,178,117,9,131,44,26,27,110,90,160,82,59,214,179,41,227,47,132,83,209,0,237,32,252,177,91,106,203,190,57,74,76,88,207,208,239,170,251,67,77,51,133,69,249,2,127,80,60,159,168,81,163,64,143,146,157,56,245,188,182,218,33,16,255,243,210,205,12,19,236,95,151,68,23,196,167,126,61,100,93,25,115,96,129,79,220,34,42,144,136,70,238,184,20,222,94,11,219,224,50,58,10,73,6,36,92,194,211,172,98,145,149,228,121,231,200,55,109,141,213,78,169,108,86,244,234,101,122,174,8,186,120,37,46,28,166,180,198,232,221,116,31,75,189,139,138,112,62,181,102,72,3,246,14,97,53,87,185,134,193,29,158,225,248,152,17,105,217,142,148,155,30,135,233,206,85,40,223,140,161,137,13,191,230,66,104,65,153,45,15,176,84,187,22];Aes.rCon=[[0,0,0,0],[1,0,0,0],[2,0,0,0],[4,0,0,0],[8,0,0,0],[16,0,0,0],[32,0,0,0],[64,0,0,0],[128,0,0,0],[27,0,0,0],[54,0,0,0]];Aes.Ctr={};Aes.Ctr.encrypt=function(N,T,C){var M=16;if(!(C==128||C==192||C==256)){return""}N=Utf8.encode(N);T=Utf8.encode(T);var L=C/8;var Q=new Array(L);for(var E=0;E<L;E++){Q[E]=isNaN(T.charCodeAt(E))?0:T.charCodeAt(E)}var b=Aes.cipher(Q,Aes.keyExpansion(Q));b=b.concat(b.slice(0,L-16));var R=new Array(M);var D=(new Date()).getTime();var P=D%1000;var S=Math.floor(D/1000);var H=Math.floor(Math.random()*65535);for(var E=0;E<2;E++){R[E]=(P>>>E*8)&255}for(var E=0;E<2;E++){R[E+2]=(H>>>E*8)&255}for(var E=0;E<4;E++){R[E+4]=(S>>>E*8)&255}var J="";for(var E=0;E<8;E++){J+=String.fromCharCode(R[E])}var A=Aes.keyExpansion(b);var F=Math.ceil(N.length/M);var K=new Array(F);for(var i=0;i<F;i++){for(var B=0;B<4;B++){R[15-B]=(i>>>B*8)&255}for(var B=0;B<4;B++){R[15-B-4]=(i/4294967296>>>B*8)}var O=Aes.cipher(R,A);var G=i<F-1?M:(N.length-1)%M+1;var I=new Array(G);for(var E=0;E<G;E++){I[E]=O[E]^N.charCodeAt(i*M+E);I[E]=String.fromCharCode(I[E])}K[i]=I.join("")}var c=J+K.join("");c=Base64.encode(c);return c};Aes.Ctr.decrypt=function(i,I,y){var B=16;if(!(y==128||y==192||y==256)){return""}i=Base64.decode(i);I=Utf8.encode(I);var A=y/8;var E=new Array(A);for(var z=0;z<A;z++){E[z]=isNaN(I.charCodeAt(z))?0:I.charCodeAt(z)}var c=Aes.cipher(E,Aes.keyExpansion(E));c=c.concat(c.slice(0,A-16));var H=new Array(8),b=i.slice(0,8);for(var z=0;z<8;z++){H[z]=b.charCodeAt(z)}var w=Aes.keyExpansion(c);var G=Math.ceil((i.length-8)/B);var F=new Array(G);for(var v=0;v<G;v++){F[v]=i.slice(8+v*B,8+v*B+B)}i=F;var K=new Array(i.length);for(var v=0;v<G;v++){for(var x=0;x<4;x++){H[15-x]=((v)>>>x*8)&255}for(var x=0;x<4;x++){H[15-x-4]=(((v+1)/4294967296-1)>>>x*8)&255}var C=Aes.cipher(H,w);var J=new Array(i[v].length);for(var z=0;z<i[v].length;z++){J[z]=C[z]^i[v].charCodeAt(z);J[z]=String.fromCharCode(J[z])}K[v]=J.join("")}var D=K.join("");D=Utf8.decode(D);return D};var Base64={};Base64.code="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=";Base64.encode=function(u,s){s=(typeof s=="undefined")?false:s;var B,E,F,c,t,x,y,A,z=[],C="",v,e,w;var D=Base64.code;e=s?u.encodeUTF8():u;v=e.length%3;if(v>0){while(v++<3){C+="=";e+="\0"}}for(v=0;v<e.length;v+=3){B=e.charCodeAt(v);E=e.charCodeAt(v+1);F=e.charCodeAt(v+2);c=B<<16|E<<8|F;t=c>>18&63;x=c>>12&63;y=c>>6&63;A=c&63;z[v/3]=D.charAt(t)+D.charAt(x)+D.charAt(y)+D.charAt(A)}w=z.join("");w=w.slice(0,w.length-C.length)+C;return w};Base64.decode=function(s,B){B=(typeof B=="undefined")?false:B;var z,C,D,r,v,x,y,c,w=[],d,t;var A=Base64.code;t=B?s.decodeUTF8():s;for(var u=0;u<t.length;u+=4){r=A.indexOf(t.charAt(u));v=A.indexOf(t.charAt(u+1));x=A.indexOf(t.charAt(u+2));y=A.indexOf(t.charAt(u+3));c=r<<18|v<<12|x<<6|y;z=c>>>16&255;C=c>>>8&255;D=c&255;w[u/4]=String.fromCharCode(z,C,D);if(y==64){w[u/4]=String.fromCharCode(z,C)}if(x==64){w[u/4]=String.fromCharCode(z)}}d=w.join("");return B?d.decodeUTF8():d};var Utf8={};Utf8.encode=function(d){var c=d.replace(/[\u0080-\u07ff]/g,function(a){var b=a.charCodeAt(0);return String.fromCharCode(192|b>>6,128|b&63)});c=c.replace(/[\u0800-\uffff]/g,function(a){var b=a.charCodeAt(0);return String.fromCharCode(224|b>>12,128|b>>6&63,128|b&63)});return c};Utf8.decode=function(c){var d=c.replace(/[\u00e0-\u00ef][\u0080-\u00bf][\u0080-\u00bf]/g,function(a){var b=((a.charCodeAt(0)&15)<<12)|((a.charCodeAt(1)&63)<<6)|(a.charCodeAt(2)&63);return String.fromCharCode(b)});d=d.replace(/[\u00c0-\u00df][\u0080-\u00bf]/g,function(a){var b=(a.charCodeAt(0)&31)<<6|a.charCodeAt(1)&63;return String.fromCharCode(b)});return d};

	/*
	 * 创建一个工具的对象，并对次对象赋给window，以便其他地方调用
	 */
	var Qutils = function() {},
		// 加解密的key
		pas_key = "hq work",

		// ajax请求参数
		ajaxs = {
			timeout: 1000 * 60,
			dataType: "json",
			beforeSend: null,
			complete: null,
			//			success: function(){},
			//			error: function(){},
			//			dataFilter: function(data, "json"){}
		};

	Qutils.prototype = {
		/**
		 * 跳转到指定页面
		 */
		goPage: function(url, param, is_hide) {
			var str = "";
			if (!/\.html$/i.test(url)) {
				url += ".html";
			}
			var abs_str = absoluteUrl(url),
				param_str = "";
			if (param) {
				if (is_hide) {
					// 对传输的数据进行加密处理
					param_str = Aes.Ctr.encrypt(JSON.stringify(param), pas_key, 256);
				} else {
					var key = "",
						val = "";
					for (key in param) {
						val = param[key];
						val = val ? val : " ";
						str += "" + key + "=" + val + "&";
					}
					str = str.substr(0, str.lastIndexOf("&"));
					// 对参数进行加密
					str = "?" + Aes.Ctr.encrypt(str, pas_key, 256);
				}
			}
			sessionStorage[abs_str] = param_str;
			window.location.href = (url + str);
		},

		/**
		 * 获取页面传递的参数
		 */
		getParam: function(key) {
			/**
			 * 判断页面是否有隐藏参数
			 */
			var param = {},
				pathname = window.location.pathname,
				session_val = sessionStorage[pathname];
			if (session_val) {
				// 对传输的数据进行加密处理
				param = JSON.parse(Aes.Ctr.decrypt(session_val, pas_key, 256));
			} else {
				// 对传输的数据进行加密处理
				var url = Aes.Ctr.decrypt(window.location.href.split(".html?")[1], pas_key, 256);
				if (url) {
					var arr = url.split("&"),
						url_length = arr.length,
						arr_a = [];
					for (var i = 0; i < url_length; i++) {
						arr_a = arr[i].split("=");
						param[arr_a[0]] = arr_a[1];
					}
				}
			}
			return key ? param[key] : param;
		},

		/**
		 * 对本地保存加密
		 */
		setLStorage: function(key, val) {
			// 加密，保存
			window.localStorage[key] = Aes.Ctr.encrypt(val, pas_key, 256);
		},

		/**
		 * 对本地保存解密
		 */
		getLStorage: function(key) {
			// 解密
			return Aes.Ctr.decrypt(window.localStorage[key], pas_key, 256);
		},

//		/**
//		 * ajax 提交数据
//		 */
//		Qpost: function(param, success) {
//			var ajaxP = {
////				url: "/" + param.funNo + "?num=" + Math.random(), // 生产修改
//				url: "/Q_jiang/" + param.funNo + "?num=" + Math.random(), // 生产修改
//				type: "post",
//				success: success,
//				data: param
//			};
//			$.ajax($.extend(ajaxs, ajaxP));
//		},
//		
//		/**
//		 * ajax 查询数据
//		 */
//		Qget: function(param, success) {
//			var ajaxP = {
////				url: "/" + param.funNo + "?num=" + Math.random(), // 生产修改
//				url: "/Q_jiang/" + param.funNo + "?num=" + Math.random(), // 生产修改
//				type: "get",
//				success: success,
//				data: param
//			};
//			$.ajax($.extend(ajaxs, ajaxP));
//		},
		
		Qajax: function(param, success, aJson){
			var ajaxP = {
				url: "/" + param.funNo + "?num=" + Math.random(), // 生产修改
//				url: "/Q_jiang/" + param.funNo + "?num=" + Math.random(), // 生产修改
				async: true,
				type: "post",
				success: success,
				data: param
			};
//			var s = ajaxs;
//			var ss = $.extend(ajaxs, ajaxP);
//			var sss = $.extend(ajaxs, ajaxP, aJson);
			$.ajax($.extend(ajaxs, ajaxP, aJson));
		},
		
		
		

		/**
		 * 获取当前时间，并将格式转化为yyyy-MM-dd DD:mm:ss
		 */
		Qcurrent: function() {
			var cur = new Date(),
				month = (cur.getMonth() + 1).toString(),
				day = cur.getDate().toString(),
				hours = cur.getHours().toString(),
				minutes = cur.getMinutes().toString(),
				seconds = cur.getSeconds().toString();
			month = month.length === 1 ? "0" + month : month;
			day = day.length === 1 ? "0" + day : day;
			hours = hours.length === 1 ? "0" + hours : hours;
			minutes = minutes.length === 1 ? "0" + minutes : minutes;
			seconds = seconds.length === 1 ? "0" + seconds : seconds;
			return cur.getFullYear() + "-" + month + "-" + day + " " + hours + ":" + minutes + ":" + seconds;
		},

		/**
		 * 判断数据结果
		 */
		checkData: function(data) {
			if (data.error_no === "0") {
				return data.results;
			} else {
				alert(data.error_info);
				return false;
			}
		},

		/**
		 * 判断当前设备是否pc端
		 */

		isPC: function() {
			var userAgent = navigator.userAgent.toLowerCase(),
				Agents = ["android", "iphone", "symbianos", "windows phone", "ipad", "ipod"],
				agents_length = Agents.length,
				flag = true;
			for (var v = 0; v < agents_length; v++) {
				if (userAgent.indexOf(Agents[v]) > 0) {
					flag = false;
					break;
				}
			}
			return flag ? "pc" : "phone";
		}
	};

	/**
	 * 获取指定页面的绝对路径
	 */
	function absoluteUrl(url) {
		var assign_url = "";
		// 当前页面的路径
		var cur = window.location.pathname;
		var cur_arr = cur.split("/");
		var cur_arr_length = cur_arr.length;
		var abs_arr = url.split("/");
		var abs0 = abs_arr[0];
		if (abs0 === "") {
			assign_url = url;
		} else if (abs0 === "..") {
			var abs_length = url.match(/\.\.\//g).length;
			abs_arr.splice(0, abs_length);
			cur_arr.splice(cur_arr_length - abs_length - 1, abs_length + 1, abs_arr.join("/"));
			assign_url = cur_arr.join("/");
		} else {
			cur_arr.splice(cur_arr_length - 1, 1, url.replace(/^\.\//, ""));
			assign_url = cur_arr.join("/");
		}
		return assign_url;
	}

	//	function success(data){
	//		alert(data);
	//	}
	window.Qutils = new Qutils;
})();