/**   
* @Title: RecordMapper.java 
* @Package cn.org.fjiot.dakaServer.mapper 
* @Description: TODO
* @author zhengshaojian fjiot   
* @date 2017年12月13日 上午11:28:23 
* @version V1.0   
*/
package cn.org.fjiot.dakaServer.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.org.fjiot.dakaServer.entity.Record;

/** 
* @ClassName: RecordMapper 
* @Description: TODO
* @author zhengshaojian fjiot 
* @date 2017年12月13日 上午11:28:23 
*  
*/
public interface RecordMapper {
	
	public void addRecord(Record record);
	
	public List<Record> listRecord();

	public Record recordByUserIdDateRemark(@Param("userId")String userId, @Param("date")String date, @Param("remark")String remark);
	
	public List<Record> listRecordByQuery();

}
