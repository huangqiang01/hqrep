package com.myapp.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.myapp.bean.Userinfo;

/**
 * ģ��     �˴�����ҵ��Ĵ����
 * 
 */
public class GetDataImpl {

	//ģ��     ��ȡ ����
	public Map<String, String> getUserinfo(String username,String password){
		
		Map<String,String> map = new HashMap<String,String>();
		//ģ���ȡ���ݿ�����
		if(username.equals("zhangsan")&&password.equals("111")){
			Userinfo userinfo = new Userinfo();
			userinfo.setUserid("1");
			userinfo.setUsername("zhangsan");
			userinfo.setPassword("111");
			userinfo.setInfo("�Ұ������찲�ţ��찲����̫����");
			
			/*---------------------------------------------�߼�����ʼ---------------------------*/
			//
			//
			//
			//
			//
			//
			//
			/*---------------------------------------------�߼��������---------------------------*/
			
			//ģ�⴦�����߼��� �������ݷ���HashMap ��
			map.put("id", userinfo.getUserid());
			map.put("name", userinfo.getUsername());
			map.put("pass", userinfo.getPassword());
			map.put("info", userinfo.getInfo());
		}else{
			map.put("errorInfo", "�û������������");
		}
		return map;
	}
}
