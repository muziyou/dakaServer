/**   
* @Title: UserMapper.java 
* @Package cn.org.fjiot.dakaServer.mapper 
* @Description: TODO
* @author zhengshaojian fjiot   
* @date 2017年12月12日 下午2:32:52 
* @version V1.0   
*/
package cn.org.fjiot.dakaServer.mapper;

import org.apache.ibatis.annotations.Param;

import cn.org.fjiot.dakaServer.entity.User;

/** 
* @ClassName: UserMapper 
* @Description: TODO
* @author zhengshaojian fjiot 
* @date 2017年12月12日 下午2:32:52 
*  
*/
public interface UserMapper {

	/** 
	* @Title: userByPhone 
	* @Description: TODO
	* @param @param phone
	* @param @return    设定文件 
	* @return User    返回类型 
	* @throws 
	*/
	public User userByPhone(String phone);

	/** 
	* @Title: addUser 
	* @Description: TODO
	* @param @param user    设定文件 
	* @return void    返回类型 
	* @throws 
	*/
	public void addUser(User user);

	/** 
	* @Title: userByNameAndPassowrd 
	* @Description: TODO
	* @param @param name
	* @param @param password
	* @param @return    设定文件 
	* @return User    返回类型 
	* @throws 
	*/
	public User userByNameAndPassowrd(@Param("name")String name, @Param("password")String password);

	/** 
	* @Title: userById 
	* @Description: TODO
	* @param @param id
	* @param @return    设定文件 
	* @return User    返回类型 
	* @throws 
	*/
	public User userById(String id);

	/** 
	* @Title: deleteUser 
	* @Description: TODO
	* @param @param user    设定文件 
	* @return void    返回类型 
	* @throws 
	*/
	public void deleteUser(User user);

	/** 
	* @Title: updateUser 
	* @Description: TODO
	* @param @param user    设定文件 
	* @return void    返回类型 
	* @throws 
	*/
	public void updateUser(User user);

}
