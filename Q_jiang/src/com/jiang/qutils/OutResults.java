package com.jiang.qutils;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * �������Բ�ѯ������з�װ����������ѯ˵��
 * @author Q
 * @created 2016��5��13�� ����9:56:59
 * @since
 */
public class OutResults {
	
	// �����ѯ�����Ĭ��Ϊ[]
	private List results = new ArrayList();
	// Ĭ�ϴ����ţ�Ĭ��Ϊ"0"
	private String error_no = "0";
	// Ĭ�ϲ�ѯ���˵��
	private String error_info = "���óɹ�";
	
	public List getResults() {
		return results;
	}
	public void setResults(List results) {
		this.results = results;
	}
	public String getError_no() {
		return error_no;
	}
	public void setError_no(String error_no) {
		this.error_no = error_no;
	}
	public String getError_info() {
		return error_info;
	}
	public void setError_info(String error_info) {
		this.error_info = error_info;
	}
}
