/**   
* @Title: Record.java 
* @Package cn.org.fjiot.dakaServer.entity 
* @Description: TODO
* @author zhengshaojian fjiot   
* @date 2017年12月13日 上午11:27:02 
* @version V1.0   
*/
package cn.org.fjiot.dakaServer.entity;

import java.io.Serializable;

/** 
* @ClassName: Record 
* @Description: TODO
* @author zhengshaojian fjiot 
* @date 2017年12月13日 上午11:27:02 
*  
*/
public class Record implements Serializable {
	
	/** 
	* @Fields serialVersionUID : TODO
	*/ 
	private static final long serialVersionUID = 1L;

	private String id;
	
	private String detail;
	
	private String date;
	
	private String week;
	
	private String time;
	
	private String remark;
	
	private String userId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
