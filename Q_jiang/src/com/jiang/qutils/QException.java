package com.jiang.qutils;

import java.io.IOException;

public class QException extends Exception {
	
	private static final long serialVersionUID = -1868588148729708991L;
	// 异常结果输出
	QOutput out = new QOutput();
	
	public QException(String no, String msg) throws IOException{
		super(msg);
		out.outPut(no, msg);
	}
}
