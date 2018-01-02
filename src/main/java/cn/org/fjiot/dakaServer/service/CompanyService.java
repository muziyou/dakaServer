/**   
* @Title: CompanyService.java 
* @Package cn.org.fjiot.dakaServer.service 
* @Description: TODO
* @author zhengshaojian fjiot   
* @date 2017年12月12日 下午3:10:34 
* @version V1.0   
*/
package cn.org.fjiot.dakaServer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.org.fjiot.dakaServer.entity.Company;
import cn.org.fjiot.dakaServer.mapper.CompanyMapper;
import cn.org.fjiot.dakaServer.util.AjaxResult;
import cn.org.fjiot.dakaServer.util.Util;

/** 
* @ClassName: CompanyService 
* @Description: TODO
* @author zhengshaojian fjiot 
* @date 2017年12月12日 下午3:10:34 
*  
*/
@Service
public class CompanyService {
	
	@Autowired
	CompanyMapper companyMapper;
	
	public AjaxResult addCompany(Company company) {
		String code = "0";
		String message = "";
		String companyName = company.getName();
		if (Util.isNull(companyName)) {
			message = "请输入公司名称";
			return new AjaxResult(code, message);
		}
		List<Company> companies = companyMapper.listCompanyByName(companyName);
		for (Company company2 : companies) {
			if (company2.getName().equals(companyName)) {
				message = "该公司已存在，请重新输入";
				return new AjaxResult(code, message);
			}
		}
		code = "1";
		message = "新增成功";
		company.setEnable("0");
		companyMapper.addCompany(company);
		return new AjaxResult(code, message);
	}
	
	public AjaxResult deleteCompany(Company company) {
		String code = "0";
		String message = "";
		String companyId = company.getId();
		if (Util.isNull(companyId)) {
			message = "该公司不存在";
			return new AjaxResult(code, message);
		}
		Company company2 = companyMapper.companyById(companyId);
		if (null == company2) {
			message = "该公司不存在";
			return new AjaxResult(code, message);
		}
		code = "1";
		message = "删除成功";
		companyMapper.deleteCompany(company);
		return new AjaxResult(code, message);
	}
	
	public AjaxResult editCompany(Company company) {
		String code = "0";
		String message = "";
		String companyId = company.getId();
		if (Util.isNull(companyId)) {
			message = "该公司不存在";
			return new AjaxResult(code, message);
		}
		Company company2 = companyMapper.companyById(companyId);
		if (null == company2) {
			message = "该公司不存在";
			return new AjaxResult(code, message);
		}
		code = "1";
		message = "修改成功";
		companyMapper.editCompany(company);
		return new AjaxResult(code, message);
	}
	
	public AjaxResult listCompany(String name) {
		List<Company> companies = new ArrayList<Company>();
		if (Util.isNull(name)) {
			companies = companyMapper.listCompany();
		} else {
			companies = companyMapper.listCompanyByName(name);
		}
		String code = "1";
		String message = "查询成功";
		return new AjaxResult(code, message, companies);
	}
	
	public Company companyById(String id) {
		return companyMapper.companyById(id);
	}

}
