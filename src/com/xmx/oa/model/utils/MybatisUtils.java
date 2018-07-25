package com.xmx.oa.model.utils;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtils {
static SqlSessionFactory sqlSessionFactory;
static{
	try {
		Reader reader=Resources.getResourceAsReader("mybatis-config.xml");
		sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public static SqlSession getSqlSession(){
	return  sqlSessionFactory.openSession();
	
}
}
