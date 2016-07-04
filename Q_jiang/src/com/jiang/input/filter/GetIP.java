package com.jiang.input.filter;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;
/**
 * 
 * ��������ȡ�ͻ���IP
 * @author Q
 * @created 2016��7��4�� ����10:32:17
 * @since
 */
public class GetIP {

	public String getIpAddr(HttpServletRequest request) {
		
		String ipAddress = request.getHeader("x-forwarded-for");
		
		if (ipAddress == null || ipAddress.length() == 0
				|| "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0
				|| "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0
				|| "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getRemoteAddr();

			// ������Ҫ�ǻ�ȡ������ip,���п���
			if (ipAddress.equals("127.0.0.1")
					|| ipAddress.endsWith("0:0:0:0:0:0:1")) {
				// ��������ȡ�������õ�IP
				InetAddress inet = null;
				try {
					inet = InetAddress.getLocalHost();
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
				ipAddress = inet.getHostAddress();
			}

		}

		// ����ͨ�����������������һ��IPΪ�ͻ�����ʵIP,���IP����','�ָ�
		if (ipAddress != null && ipAddress.length() > 15) { // "***.***.***.***".length()
															// = 15
			if (ipAddress.indexOf(",") > 0) {
				ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
			}
		}
		// ��������Ҳ��,����ͨ�����������������һ��IPΪ�ͻ�����ʵIP,���IP����','�ָ�
		// return
		// ipAddress!=null&&!"".equals(ipAddress)?ipAddress.split(",")[0]:null;
		return ipAddress;
	}
}
