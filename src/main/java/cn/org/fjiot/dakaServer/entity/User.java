/**   
* @Title: User.java 
* @Package cn.org.fjiot.dakaServer.entity 
* @Description: TODO
* @author zhengshaojian fjiot   
* @date 2017年12月12日 下午2:31:11 
* @version V1.0   
*/
package cn.org.fjiot.dakaServer.entity;

import java.io.Serializable;

/** 
* @ClassName: User 
* @Description: TODO
* @author zhengshaojian fjiot 
* @date 2017年12月12日 下午2:31:11 
*  
*/
public class User implements Serializable {

	/** 
	* @Fields serialVersionUID : TODO
	*/ 
	private static final long serialVersionUID = 1L;

	private String id;

	private String name;

	private String password;

	private String phone;

	private String permission;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
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
