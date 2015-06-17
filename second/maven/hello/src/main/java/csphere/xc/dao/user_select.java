package csphere.xc.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import csphere.xc.po.User;



public class user_select {
	
	
		public static String select()throws IOException {
			  String resource = "sqlMapConfig.xml";

			    InputStream inputStream =   Resources.getResourceAsStream(resource);
			    

			    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

			    SqlSession sqlSession = sqlSessionFactory.openSession();
			    
			  
			    User user =  sqlSession.selectOne("csphere.xc.findUserById", 1);
			    
			    System.err.println("haha-----------------"+user.getName());
			   
			    sqlSession.close();
			    return user.getName();
		}
}
