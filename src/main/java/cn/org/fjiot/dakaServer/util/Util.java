/**   
* @Title: Util.java 
* @Package cn.org.fjiot.dakaServer.util 
* @Description: TODO
* @author zhengshaojian fjiot   
* @date 2017年12月12日 下午7:59:24 
* @version V1.0   
*/
package cn.org.fjiot.dakaServer.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/** 
* @ClassName: Util 
* @Description: TODO
* @author zhengshaojian fjiot 
* @date 2017年12月12日 下午7:59:24 
*  
*/
public class Util {
	
	public static boolean isNull(String... strings) {
		boolean isNull = false;
		for (String string : strings) {
			if (null == string || "".equals(string)) {
				isNull = true;
			}
		}
		return isNull;
	}
	
	public static String getToken() {
		String time = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
		String uuid = UUID.randomUUID().toString().replace("-", "").substring(28);
		String token = "NO" + time + uuid;
		return token;
	}

}
