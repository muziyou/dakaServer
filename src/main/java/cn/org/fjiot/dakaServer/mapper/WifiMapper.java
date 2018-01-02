/**   
* @Title: WifiMapper.java 
* @Package cn.org.fjiot.dakaServer.mapper 
* @Description: TODO
* @author zhengshaojian fjiot   
* @date 2017年12月12日 下午2:33:14 
* @version V1.0   
*/
package cn.org.fjiot.dakaServer.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.org.fjiot.dakaServer.entity.Wifi;

/** 
* @ClassName: WifiMapper 
* @Description: TODO
* @author zhengshaojian fjiot 
* @date 2017年12月12日 下午2:33:14 
*  
*/
public interface WifiMapper {
	
	public List<Wifi> listWifi();

	/** 
	* @Title: listWifiByMac 
	* @Description: TODO
	* @param @param mac
	* @param @return    设定文件 
	* @return Wifi    返回类型 
	* @throws 
	*/
	public Wifi listWifiByMac(String mac);

	/** 
	* @Title: addWifi 
	* @Description: TODO
	* @param @param wifi    设定文件 
	* @return void    返回类型 
	* @throws 
	*/
	public void addWifi(Wifi wifi);

	/** 
	* @Title: deleteWifi 
	* @Description: TODO
	* @param @param wifi    设定文件 
	* @return void    返回类型 
	* @throws 
	*/
	public void deleteWifi(Wifi wifi);

	/** 
	* @Title: editWifi 
	* @Description: TODO
	* @param @param wifi    设定文件 
	* @return void    返回类型 
	* @throws 
	*/
	public void editWifi(Wifi wifi);

	/** 
	* @Title: listWifiByName 
	* @Description: TODO
	* @param @param name
	* @param @return    设定文件 
	* @return List<Wifi>    返回类型 
	* @throws 
	*/
	public List<Wifi> listWifiByName(String name);

	/** 
	* @Title: wifiById 
	* @Description: TODO
	* @param @return    设定文件 
	* @return Wifi    返回类型 
	* @throws 
	*/
	public Wifi wifiById(String id);

	/** 
	* @Title: wifiByMacNameAndCompanyId 
	* @Description: TODO
	* @param @param mac
	* @param @param name
	* @param @param companyId
	* @param @return    设定文件 
	* @return Wifi    返回类型 
	* @throws 
	*/
	public Wifi wifiByMacNameAndCompanyId(@Param("mac")String mac, @Param("name")String name, @Param("companyId")String companyId);

}
