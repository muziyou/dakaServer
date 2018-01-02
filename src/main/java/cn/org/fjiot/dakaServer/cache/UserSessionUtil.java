/**   
* @Title: UserSessionUtil.java 
* @Package cn.org.fjiot.hdSoftServer.cache 
* @Description: TODO
* @author zhengshaojian fjiot   
* @date 2017年12月1日 下午3:32:59 
* @version V1.0   
*/
package cn.org.fjiot.dakaServer.cache;

import java.util.HashMap;
import java.util.Map;

/** 
* @ClassName: UserSessionUtil 
* @Description: TODO
* @author zhengshaojian fjiot 
* @date 2017年12月1日 下午3:32:59 
*  
*/
public class UserSessionUtil {
	
	private static Map<String, UserSession> userSessionMap = new HashMap<String, UserSession>();
	
	public static void removeUserSession(String token) {
		userSessionMap.remove(token);
	}
	
	public static UserSession getUserSession(String token) {
		UserSession userSession = null;
		if (userSessionMap.containsKey(token)) {
			userSession = userSessionMap.get(token);
		} else {
			userSession = new UserSession();
			userSessionMap.put(token, userSession);
		}
		return userSession;
	}
	
	public static boolean containUserSession(String token) {
		return userSessionMap.containsKey(token);
	}

}
