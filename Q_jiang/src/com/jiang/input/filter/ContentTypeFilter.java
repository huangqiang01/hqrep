package com.jiang.input.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class ContentTypeFilter implements Filter {
	
	private String charset = "UTF-8";
	private FilterConfig config; 

	@Override
	public void destroy() {
        charset = null;
        config = null;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//����������Ӧ�ַ����� 
        request.setCharacterEncoding(charset);
        response.setCharacterEncoding(charset);
        //�����ӵĴ���
        HttpServletRequest req = (HttpServletRequest)request;
        
        if (req.getMethod().equalsIgnoreCase("get")){
            req = new GetHttpServletRequestWrapper(req, charset);
        }
        
        //���ݸ�Ŀ��servlet��jsp��ʵ����ʱ��װ����������ã�������ԭʼ��HttpServletRequest����
        chain.doFilter(req, response);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		 this.config = config;
         String charset = config.getServletContext().getInitParameter("charset");
         if( charset != null && charset.trim().length() != 0){
             this.charset = charset;
         }
	}
}
