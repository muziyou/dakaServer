/**   
* @Title: UserController.java 
* @Package cn.org.fjiot.dakaServer.controller 
* @Description: TODO
* @author zhengshaojian fjiot   
* @date 2017年12月12日 下午3:12:18 
* @version V1.0   
*/
package cn.org.fjiot.dakaServer.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.org.fjiot.dakaServer.entity.Record;
import cn.org.fjiot.dakaServer.entity.User;
import cn.org.fjiot.dakaServer.entity.Wifi;
import cn.org.fjiot.dakaServer.service.UserService;
import cn.org.fjiot.dakaServer.util.AjaxResult;

/** 
* @ClassName: UserController 
* @Description: 普通权限：注册，登录，退出，签到，请假，查看自己的记录      管理员权限：修改用户信息，查看所有数据，删除用户
* @author zhengshaojian fjiot 
* @date 2017年12月12日 下午3:12:18 
*  
*/
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@ResponseBody
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public AjaxResult register(User user) {
		return userService.register(user);
	}

	@ResponseBody
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public AjaxResult login(User user) {
		return userService.login(user);
	}

	@ResponseBody
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public AjaxResult logout(String token) {
		return userService.logout(token);
	}

	@ResponseBody
	@RequestMapping(value="/daka", method=RequestMethod.GET)
	public AjaxResult daka(String token,Wifi wifi) {
		return userService.daka(token, wifi);
	}

	@ResponseBody
	@RequestMapping(value="/dakaTest", method=RequestMethod.GET)
	public void daka() {
		Date now = new Date();
		String dateWeekTime = new SimpleDateFormat("yyyy年MM月dd日-E-HH时mm分ss秒").format(now);
		System.out.println(dateWeekTime);
		String[] datas = dateWeekTime.split("-");
		String date = datas[0];
		String week = datas[1];
		String time = datas[2];
		String remark = "";
		String detail = "";
		int i1 = time.compareToIgnoreCase("07时30分00秒");
		int i2 = time.compareToIgnoreCase("08时00分00秒");
		int i3 = time.compareToIgnoreCase("08时30分00秒");
		int j1 = time.compareToIgnoreCase("12时00分00秒");
		int j2 = time.compareToIgnoreCase("12时30分00秒");
		int m1 = time.compareToIgnoreCase("13时00分00秒");
		int m2 = time.compareToIgnoreCase("13时30分00秒");
		int m3 = time.compareToIgnoreCase("14时00分00秒");
		int n1 = time.compareToIgnoreCase("17时30分00秒");
		int n2 = time.compareToIgnoreCase("22时00分00秒");
		System.out.println(i1+","+i2+","+i3+","+j1+","+j2+","+m1+","+m2+","+m3+","+n1+","+n2);
		if (i1 > 0 && i2 <= 0) {
			System.out.println("早上上班，打卡");
			remark = "早上上班";
			detail = "打卡";
		} else if (i2 > 0 && i3 <= 0) {
			System.out.println("早上上班，迟到");
			remark = "早上上班";
			detail = "迟到";
		} else if (j1 > 0 && j2 <= 0) {
			System.out.println("早上下班，打卡");
			remark = "早上下班";
			detail = "打卡";
		} else if (m1 > 0 && m2 <= 0) {
			System.out.println("下午上班，打卡");
			remark = "下午上班";
			detail = "打卡";
		} else if (m2 > 0 && m3 <= 0) {
			System.out.println("下午上班，迟到");
			remark = "下午上班";
			detail = "迟到";
		} else if (n1 > 0 && n2 <= 0) {
			System.out.println("下午下班，打卡");
			remark = "下午下班";
			detail = "打卡";
		} else {//(i1 <= 0) || (i3 > 0 && j1 <= 0) || (j2 > 0 && m1 <= 0) || (m3 > 0 && n1 <= 0) || (n2 > 0)
			System.out.println("非打卡时间，不用打卡");
		}
		Record record = new Record();
		record.setDate(date);
		record.setWeek(week);
		record.setTime(time);
		record.setDetail(detail);
		record.setRemark(remark);
//		record.setUserId(userId);
	}

	@ResponseBody
	@RequestMapping(value="/qingjia", method=RequestMethod.GET)
	public AjaxResult qingjia() {
		return userService.qingjia();
	}

	@ResponseBody
	@RequestMapping(value="/record", method=RequestMethod.GET)
	public AjaxResult record(String token) {
		return userService.record(token);
	}

	@ResponseBody
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public AjaxResult edit(User user) {
		return userService.edit(user);
	}

	@ResponseBody
	@RequestMapping(value="/recordOther", method=RequestMethod.GET)
	public AjaxResult recordOther() {
		return userService.recordOther();
	}

	@ResponseBody
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public AjaxResult delete(User user) {
		return userService.delete(user);
	}

}
