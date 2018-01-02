/**   
* @Title: UserService.java 
* @Package cn.org.fjiot.dakaServer.service 
* @Description: TODO
* @author zhengshaojian fjiot   
* @date 2017年12月12日 下午3:10:22 
* @version V1.0   
*/
package cn.org.fjiot.dakaServer.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.org.fjiot.dakaServer.cache.UserSession;
import cn.org.fjiot.dakaServer.cache.UserSessionUtil;
import cn.org.fjiot.dakaServer.entity.Company;
import cn.org.fjiot.dakaServer.entity.Record;
import cn.org.fjiot.dakaServer.entity.User;
import cn.org.fjiot.dakaServer.entity.Wifi;
import cn.org.fjiot.dakaServer.mapper.UserMapper;
import cn.org.fjiot.dakaServer.util.AjaxResult;
import cn.org.fjiot.dakaServer.util.Util;

/** 
* @ClassName: UserService 
* @Description: TODO
* @author zhengshaojian fjiot 
* @date 2017年12月12日 下午3:10:22 
*  
*/
@Service
public class UserService {
	
	@Autowired
	UserMapper userMapper;
	
	@Autowired
	CompanyService companyService;
	
	@Autowired
	WifiService wifiService;
	
	@Autowired
	RecordService recordService;
	
	public AjaxResult register(User user) {
		String code = "0";
		String message = "";
		if (Util.isNull(user.getName(), user.getPassword(), user.getPhone(), user.getCompanyId())) {
			message = "用户信息有误，请重新输入";
			return new AjaxResult(code, message);
		}
		User user2 = userMapper.userByPhone(user.getPhone());
		if (null != user2) {
			message = "该手机已注册，请联系管理员";
			return new AjaxResult(code, message);
		}
		code = "1";
		message = "注册成功";
		user.setPermission("0");
		userMapper.addUser(user);
		return new AjaxResult(code, message);
	}

	public AjaxResult login(User user) {
		String code = "0";
		String message = "";
		if (Util.isNull(user.getName(), user.getPassword())) {
			message = "用户信息有误，请重新输入";
			return new AjaxResult(code, message);
		}
		User user2 = userMapper.userByNameAndPassowrd(user.getName(), user.getPassword());
		if (null == user2) {
			message = "该用户不存在，请联系管理员";
			return new AjaxResult(code, message);
		} else {
			user = user2;
		}
		Company company = companyService.companyById(user.getCompanyId());
		if (null == company || "0".equals(company.getEnable())) {
			message = "该公司被禁用，请联系管理员";
			return new AjaxResult(code, message);
		}
		code = "1";
		message = "登录成功";
		String token = Util.getToken();
		UserSession userSession = UserSessionUtil.getUserSession(token);
		userSession.setAttribute("token", token);
		userSession.setAttribute("user", user);
		userSession.setAttribute("company", company);
		return new AjaxResult(code, message, token);
	}

	public AjaxResult logout(String token) {
		String code = "1";
		String message = "登出成功";
		UserSessionUtil.removeUserSession(token);
		return new AjaxResult(code, message);
	}

	public AjaxResult daka(String token,Wifi wifi) {
		Date now = new Date();
		String code = "0";
		String message = "";
		UserSession userSession = UserSessionUtil.getUserSession(token);
		User user = (User) userSession.getAttribute("user");
		if (Util.isNull(wifi.getMac(), wifi.getName())) {
			message = "无效wifi，请选择正确wifi";
			return new AjaxResult(code, message);
		}
		Wifi wifi2 = wifiService.wifiByMacNameAndCompanyId(wifi.getMac(), wifi.getName(), user.getCompanyId());
		if (null == wifi2) {
			message = "无效wifi，请选择正确wifi";
			return new AjaxResult(code, message);
		}
		//进入打卡操作,手机标识还未识别
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
		//礼拜六日先不考虑
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
			message = "非打卡时间，不用打卡";
			return new AjaxResult(code, message);
		}
		Record record = new Record();
		record.setDate(date);
		record.setWeek(week);
		record.setTime(time);
		record.setDetail(detail);
		record.setRemark(remark);
		record.setUserId(user.getId());
		Record record2 = recordService.recordByUserIdDateRemark(user.getId(), date, remark);
		if (null != record2) {
			message = "该用户已于:"+record2.getTime()+"进行打卡操作:"+record2.getDetail();
			return new AjaxResult(code, message);
		}
		code = "1";
		message = detail;
		recordService.addRecord(record);
		return new AjaxResult(code, message);
	}

	public AjaxResult qingjia() {
		// TODO Auto-generated method stub
		return null;
	}

	public AjaxResult record(String token) {
		// TODO Auto-generated method stub
		return null;
	}

	public AjaxResult edit(User user) {
		String code = "0";
		String message = "";
		if (Util.isNull(user.getId())) {
			message = "用户信息有误，请重新输入";
			return new AjaxResult(code, message);
		}
		User user2 = userMapper.userById(user.getId());
		if (null == user2) {
			message = "该用户不存在，请重新输入";
			return new AjaxResult(code, message);
		}
		code = "1";
		message = "修改成功";
		userMapper.updateUser(user);
		return new AjaxResult(code, message);
	}

	public AjaxResult recordOther() {
		// TODO Auto-generated method stub
		return null;
	}

	public AjaxResult delete(User user) {
		String code = "0";
		String message = "";
		if (Util.isNull(user.getId())) {
			message = "用户信息有误，请重新输入";
			return new AjaxResult(code, message);
		}
		User user2 = userMapper.userById(user.getId());
		if (null == user2) {
			message = "该用户不存在，请重新输入";
			return new AjaxResult(code, message);
		} else {
			user = user2;
		}
		code = "1";
		message = "删除成功";
		userMapper.deleteUser(user);
		return new AjaxResult(code, message);
	}

}
