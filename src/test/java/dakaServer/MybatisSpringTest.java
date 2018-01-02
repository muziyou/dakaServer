///**   
// * @Title: MybatisSpringTest.java 
// * @Package dakaServer 
// * @Description: TODO
// * @author zhengshaojian fjiot   
// * @date 2017年12月12日 下午3:00:54 
// * @version V1.0   
// */
//package dakaServer;
//
//import java.util.List;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import cn.org.fjiot.dakaServer.entity.Wifi;
//import cn.org.fjiot.dakaServer.mapper.WifiMapper;
//
///** 
// * @ClassName: MybatisSpringTest 
// * @Description: TODO
// * @author zhengshaojian fjiot 
// * @date 2017年12月12日 下午3:00:54 
// *  
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:spring.xml")
//public class MybatisSpringTest {
//
//	@Autowired
//	WifiMapper wifiMapper;
//
//	@Test
//	public void testList() {
//		System.out.println(wifiMapper);
//		List<Wifi> wifis = wifiMapper.listWifi();
//		for (Wifi wifi : wifis) {
//			System.out.println(wifi.getId()+","+wifi.getName()+","+wifi.getMac()+","+wifi.getRemark()+","+wifi.getCompanyId());
//		}
//	}
//
//}
