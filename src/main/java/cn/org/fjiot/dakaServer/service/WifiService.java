/**   
* @Title: WifiService.java 
* @Package cn.org.fjiot.dakaServer.service 
* @Description: TODO
* @author zhengshaojian fjiot   
* @date 2017年12月12日 下午3:10:41 
* @version V1.0   
*/
package cn.org.fjiot.dakaServer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.org.fjiot.dakaServer.entity.Wifi;
import cn.org.fjiot.dakaServer.mapper.WifiMapper;
import cn.org.fjiot.dakaServer.util.AjaxResult;
import cn.org.fjiot.dakaServer.util.Util;

/** 
* @ClassName: WifiService 
* @Description: TODO
* @author zhengshaojian fjiot 
* @date 2017年12月12日 下午3:10:41 
*  
*/
@Service
public class WifiService {
	
	@Autowired
	WifiMapper wifiMapper;

	public AjaxResult addWifi(Wifi wifi) {
		String code = "0";
		String message = "";
		if (Util.isNull(wifi.getName(), wifi.getMac(), wifi.getCompanyId())) {
			message = "wifi信息有误，请重新输入";
			return new AjaxResult(code, message);
		}
		Wifi wifi2 = wifiMapper.listWifiByMac(wifi.getMac());
		if (null != wifi2) {
			message = "该wifi已存在，请重新输入";
			return new AjaxResult(code, message);
		}
		code = "1";
		message = "增加成功";
		wifiMapper.addWifi(wifi);
		return new AjaxResult(code, message);
	}

	public AjaxResult deleteWifi(Wifi wifi) {
		String code = "0";
		String message = "";
		String wifiId = wifi.getId();
		if (Util.isNull(wifiId)) {
			message = "该Wifi不存在";
			return new AjaxResult(code, message);
		}
		Wifi wifi2 = wifiMapper.wifiById(wifiId);
		if (null == wifi2) {
			message = "该Wifi不存在";
			return new AjaxResult(code, message);
		}
		code = "1";
		message = "删除成功";
		wifiMapper.deleteWifi(wifi);
		return new AjaxResult(code, message);
	}

	public AjaxResult editWifi(Wifi wifi) {
		String code = "0";
		String message = "";
		String wifiId = wifi.getId();
		if (Util.isNull(wifiId)) {
			message = "该Wifi不存在";
			return new AjaxResult(code, message);
		}
		Wifi wifi2 = wifiMapper.wifiById(wifiId);
		if (null == wifi2) {
			message = "该Wifi不存在";
			return new AjaxResult(code, message);
		}
		code = "1";
		message = "修改成功";
		wifiMapper.editWifi(wifi);
		return new AjaxResult(code, message);
	}

	public AjaxResult listWifi(String name) {
		List<Wifi> wifis = new ArrayList<Wifi>();
		if (Util.isNull(name)) {
			wifis = wifiMapper.listWifi();
		} else {
			wifis = wifiMapper.listWifiByName(name);
		}
		String code = "1";
		String message = "查询成功";
		return new AjaxResult(code, message, wifis);
	}

	public Wifi wifiByMacNameAndCompanyId(String mac, String name, String companyId) {
		return wifiMapper.wifiByMacNameAndCompanyId(mac, name, companyId);
	}

}
