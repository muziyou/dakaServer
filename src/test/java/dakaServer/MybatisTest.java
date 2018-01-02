///**   
//* @Title: MybatisTest.java 
//* @Package dakaServer 
//* @Description: TODO
//* @author zhengshaojian fjiot   
//* @date 2017年12月12日 下午2:43:31 
//* @version V1.0   
//*/
//package dakaServer;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.List;
//
//import org.apache.ibatis.io.Resources;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//
//import cn.org.fjiot.dakaServer.entity.Wifi;
//
///** 
//* @ClassName: MybatisTest 
//* @Description: TODO
//* @author zhengshaojian fjiot 
//* @date 2017年12月12日 下午2:43:31 
//*  
//*/
//public class MybatisTest {
//	
//	public static void main(String[] args) throws IOException {
//		String resource = "mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession session = sqlSessionFactory.openSession();
//         
//        List<Wifi> wifis = session.selectList("listWifi");
//        for (Wifi wifi : wifis) {
//            System.out.println(wifi.getId()+","+wifi.getName()+","+wifi.getMac()+","+wifi.getRemark()+","+wifi.getCompanyId());
//        }
//	}
//
//}
