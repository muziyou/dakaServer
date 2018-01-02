/**   
* @Title: UserSession.java 
* @Package cn.org.fjiot.hdSoftServer.cache 
* @Description: TODO
* @author zhengshaojian fjiot   
* @date 2017年12月1日 下午3:32:42 
* @version V1.0   
*/
package cn.org.fjiot.dakaServer.cache;

import java.util.HashMap;
import java.util.Map;

/** 
* @ClassName: UserSession 
* @Description: TODO
* @author zhengshaojian fjiot 
* @date 2017年12月1日 下午3:32:42 
*  
*/
public class UserSession {
	
	private Map<String, Object> attribute = null;
	
	public UserSession() {
		attribute = new HashMap<String, Object>();
	}
	
	public void setAttribute(String key, Object value) {
		attribute.put(key, value);
	}
	
	public Object getAttribute(String key) {
		return attribute.get(key);
	}
	
	public void removeAttribute(String key) {
		attribute.remove(key);
	}

}
