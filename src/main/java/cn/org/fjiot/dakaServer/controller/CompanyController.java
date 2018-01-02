/**   
* @Title: CompanyController.java 
* @Package cn.org.fjiot.dakaServer.controller 
* @Description: TODO
* @author zhengshaojian fjiot   
* @date 2017年12月12日 下午3:12:11 
* @version V1.0   
*/
package cn.org.fjiot.dakaServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.org.fjiot.dakaServer.entity.Company;
import cn.org.fjiot.dakaServer.service.CompanyService;
import cn.org.fjiot.dakaServer.util.AjaxResult;

/** 
* @ClassName: CompanyController 
* @Description: 管理员权限：增加、查看、修改、删除公司信息，管理公司权限
* @author zhengshaojian fjiot 
* @date 2017年12月12日 下午3:12:11 
*  
*/
@Controller
@RequestMapping("/company")
public class CompanyController {
	
	@ResponseBody
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public AjaxResult test() {
		return new AjaxResult("1", "test", "testObject");
	}
	
	@Autowired
	CompanyService companyService;
	
	@ResponseBody
	@RequestMapping(value="/addCompany", method=RequestMethod.GET)
	public AjaxResult addCompany(Company company) {
		return companyService.addCompany(company);
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteCompany", method=RequestMethod.GET)
	public AjaxResult deleteCompany(Company company) {
		return companyService.deleteCompany(company);
	}
	
	@ResponseBody
	@RequestMapping(value="/editCompany", method=RequestMethod.GET)
	public AjaxResult editCompany(Company company) {
		return companyService.editCompany(company);
	}
	
	@ResponseBody
	@RequestMapping(value="/listCompany", method=RequestMethod.GET)
	public AjaxResult listCompany(String companyName) {
		return companyService.listCompany(companyName);
	}

}
