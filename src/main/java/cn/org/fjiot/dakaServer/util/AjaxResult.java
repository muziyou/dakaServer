package cn.org.fjiot.dakaServer.util;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class AjaxResult {
	/**
	 * 是否成功	1：成功	0：失败
	 */
	private String code;
	/**
	 * 返回信息
	 */
	private String message;
	/**
	 * 返回数据
	 */
	private Object data;

	public AjaxResult() {
		
	}
	
	public AjaxResult(String code) {
		this.code = code;
	}
	
	public AjaxResult(String code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public AjaxResult(String code, String message, Object data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
