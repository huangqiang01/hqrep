package com.jiang.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jiang.bean.Userinfo;

/**
 * ģ��     �˴�����ҵ��Ĵ����
 * 
 */
public class GetDataImpl {

	//ģ��     ��ȡ ����
	public List getUserinfo(String username,String password){
		List list = new ArrayList();
		Map<String,String> map = new HashMap<String,String>();
		//ģ���ȡ���ݿ�����
		if(username.equals("����")&&password.equals("111")){
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
		list.add(map);
		list.add(map);
		list.add(map);
		list.add(map);
		return list;
	}
}
