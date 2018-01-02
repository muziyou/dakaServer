/**   
* @Title: WifiController.java 
* @Package cn.org.fjiot.dakaServer.controller 
* @Description: TODO
* @author zhengshaojian fjiot   
* @date 2017年12月12日 下午3:12:25 
* @version V1.0   
*/
package cn.org.fjiot.dakaServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.org.fjiot.dakaServer.entity.Wifi;
import cn.org.fjiot.dakaServer.service.WifiService;
import cn.org.fjiot.dakaServer.util.AjaxResult;

/** 
* @ClassName: WifiController 
* @Description: 管理员权限：增加、查看、修改、删除wifi信息，设置wifi与公司的关系
* @author zhengshaojian fjiot 
* @date 2017年12月12日 下午3:12:25 
*  
*/
@Controller
@RequestMapping("/wifi")
public class WifiController {
	
	@Autowired
	WifiService wifiService;
	
	@ResponseBody
	@RequestMapping(value="/addWifi", method=RequestMethod.GET)
	public AjaxResult addWifi(Wifi wifi) {
		return wifiService.addWifi(wifi);
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteWifi", method=RequestMethod.GET)
	public AjaxResult deleteWifi(Wifi wifi) {
		return wifiService.deleteWifi(wifi);
	}
	
	@ResponseBody
	@RequestMapping(value="/editWifi", method=RequestMethod.GET)
	public AjaxResult editWifi(Wifi wifi) {
		return wifiService.editWifi(wifi);
	}
	
	@ResponseBody
	@RequestMapping(value="/listWifi", method=RequestMethod.GET)
	public AjaxResult listWifi(String name) {
		return wifiService.listWifi(name);
	}

}
