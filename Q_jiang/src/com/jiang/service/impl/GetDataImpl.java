package com.jiang.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jiang.bean.Userinfo;

/**
 * 模拟     此处进行业务的处理层
 * 
 */
public class GetDataImpl {

	//模拟     获取 数据
	public List getUserinfo(String username,String password){
		List list = new ArrayList();
		Map<String,String> map = new HashMap<String,String>();
		//模拟获取数据库数据
		if(username.equals("张三")&&password.equals("111")){
			Userinfo userinfo = new Userinfo();
			userinfo.setUserid("1");
			userinfo.setUsername("zhangsan");
			userinfo.setPassword("111");
			userinfo.setInfo("我爱北京天安门，天安门上太阳升");
			
			/*---------------------------------------------逻辑处理开始---------------------------*/
			//
			//
			//
			//
			//
			//
			//
			/*---------------------------------------------逻辑处理结束---------------------------*/
			
			//模拟处理完逻辑后 ，将数据放入HashMap 中
			map.put("id", userinfo.getUserid());
			map.put("name", userinfo.getUsername());
			map.put("pass", userinfo.getPassword());
			map.put("info", userinfo.getInfo());
		}else{
			map.put("errorInfo", "用户名或密码错误");
		}
		list.add(map);
		list.add(map);
		list.add(map);
		list.add(map);
		return list;
	}
}
