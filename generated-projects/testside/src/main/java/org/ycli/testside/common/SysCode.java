package org.ycli.testside.common;

public interface SysCode {
	
    String DEL_FLAG_NORMAL = "0";
	String DEL_FLAG_DELETE = "1";
	
	String[] DATE_PARSE_PATTERNS = { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", 
		"yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyyMMddHHmmss" };
}
