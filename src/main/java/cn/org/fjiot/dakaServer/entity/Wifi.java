/**   
* @Title: Wifi.java 
* @Package cn.org.fjiot.dakaServer.entity 
* @Description: TODO
* @author zhengshaojian fjiot   
* @date 2017年12月12日 下午2:30:12 
* @version V1.0   
*/
package cn.org.fjiot.dakaServer.entity;

import java.io.Serializable;

/** 
* @ClassName: Wifi 
* @Description: TODO
* @author zhengshaojian fjiot 
* @date 2017年12月12日 下午2:30:12 
*  
*/
public class Wifi implements Serializable {

	/** 
	* @Fields serialVersionUID : TODO
	*/ 
	private static final long serialVersionUID = 1L;

	private String id;

	private String name;

	private String mac;

	private String remark;

	private String companyId;

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

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

}
