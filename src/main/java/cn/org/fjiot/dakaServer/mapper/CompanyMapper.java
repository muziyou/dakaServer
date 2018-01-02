/**   
* @Title: CompanyMapper.java 
* @Package cn.org.fjiot.dakaServer.mapper 
* @Description: TODO
* @author zhengshaojian fjiot   
* @date 2017年12月12日 下午2:33:02 
* @version V1.0   
*/
package cn.org.fjiot.dakaServer.mapper;

import java.util.List;

import cn.org.fjiot.dakaServer.entity.Company;

/** 
* @ClassName: CompanyMapper 
* @Description: TODO
* @author zhengshaojian fjiot 
* @date 2017年12月12日 下午2:33:02 
*  
*/
public interface CompanyMapper {

	/** 
	* @Title: listCompany 
	* @Description: TODO
	* @param @return    设定文件 
	* @return List<Company>    返回类型 
	* @throws 
	*/
	public List<Company> listCompany();

	/** 
	* @Title: addCompany 
	* @Description: TODO
	* @param @param company    设定文件 
	* @return void    返回类型 
	* @throws 
	*/
	public void addCompany(Company company);

	/** 
	* @Title: deleteCompany 
	* @Description: TODO
	* @param @param company    设定文件 
	* @return void    返回类型 
	* @throws 
	*/
	public void deleteCompany(Company company);

	/** 
	* @Title: editCompany 
	* @Description: TODO
	* @param @param company    设定文件 
	* @return void    返回类型 
	* @throws 
	*/
	public void editCompany(Company company);

	/** 
	* @Title: listCompanyByName 
	* @Description: TODO
	* @param     设定文件 
	* @return void    返回类型 
	* @throws 
	*/
	public List<Company> listCompanyByName(String name);

	/** 
	* @Title: companyById 
	* @Description: TODO
	* @param @param companyId
	* @param @return    设定文件 
	* @return Company    返回类型 
	* @throws 
	*/
	public Company companyById(String id);

}
