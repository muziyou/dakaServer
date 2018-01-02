/**   
* @Title: Company.java 
* @Package cn.org.fjiot.dakaServer.entity 
* @Description: TODO
* @author zhengshaojian fjiot   
* @date 2017年12月12日 下午2:29:05 
* @version V1.0   
*/
package cn.org.fjiot.dakaServer.entity;

import java.io.Serializable;

/** 
* @ClassName: Company 
* @Description: TODO
* @author zhengshaojian fjiot 
* @date 2017年12月12日 下午2:29:05 
*  
*/
public class Company implements Serializable {
	
	/** 
	* @Fields serialVersionUID : TODO
	*/ 
	private static final long serialVersionUID = 1L;

	private String id;
	
	private String name;
	
	private String enable;
	
	private String remark;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
