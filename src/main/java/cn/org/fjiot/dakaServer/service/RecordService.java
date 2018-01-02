/**   
* @Title: RecordService.java 
* @Package cn.org.fjiot.dakaServer.service 
* @Description: TODO
* @author zhengshaojian fjiot   
* @date 2017年12月13日 下午3:38:28 
* @version V1.0   
*/
package cn.org.fjiot.dakaServer.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import cn.org.fjiot.dakaServer.entity.Record;
import cn.org.fjiot.dakaServer.entity.User;
import cn.org.fjiot.dakaServer.mapper.RecordMapper;

/** 
* @ClassName: RecordService 
* @Description: TODO
* @author zhengshaojian fjiot 
* @date 2017年12月13日 下午3:38:28 
*  
*/
@Service
public class RecordService {
	
	@Autowired
	RecordMapper recordMapper;
	
	@Autowired
	UserService userService;

	public Record recordByUserIdDateRemark(String userId, String date, String remark) {
		return recordMapper.recordByUserIdDateRemark(userId, date, remark);
	}

	public void addRecord(Record record) {
		recordMapper.addRecord(record);
	}
	
	@Scheduled(cron="0 0 23 ? * MON-FRI")
	public void unDakaRecord() {
//		Date now = new Date();
//		String date = new SimpleDateFormat("yyyy年MM月dd日").format(now);
//		int i1 = time.compareToIgnoreCase("07时30分00秒");
//		int i2 = time.compareToIgnoreCase("08时00分00秒");
//		int i3 = time.compareToIgnoreCase("08时30分00秒");
//		int j1 = time.compareToIgnoreCase("12时00分00秒");
//		int j2 = time.compareToIgnoreCase("12时30分00秒");
//		int m1 = time.compareToIgnoreCase("13时00分00秒");
//		int m2 = time.compareToIgnoreCase("13时30分00秒");
//		int m3 = time.compareToIgnoreCase("14时00分00秒");
//		int n1 = time.compareToIgnoreCase("17时30分00秒");
//		int n2 = time.compareToIgnoreCase("22时00分00秒");
//		List<User> users = userService.listUser();
//		for (User user : users) {
//			List<Record> records = recordMapper.listRecordByUserIdAndDate(user.getId(), date);
//			for (Record record : records) {
//				
//			}
//		}
	}
	
	@Scheduled(cron="0 0 0 1 * ?")
	public void dakaRecordList() {
		System.out.println("hello");
	}

}
