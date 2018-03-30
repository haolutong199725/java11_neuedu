package com.common;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtils {
	private static  SqlSessionFactory sqlSessionFactory=null;
          static{
        	  String config="com/config/MyBatisConfig.xml";
        	  Reader reader=null;
        	  try {
        		  reader=Resources.getResourceAsReader(config);
        		  sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        	  }catch(IOException e) {
        		  e.printStackTrace();
        	  }
          }   

           public static SqlSessionFactory getSqlSessionFactory(){
        	   return sqlSessionFactory;
           }
           
           
           public static void close(SqlSession sqlSession) {
        	   sqlSession.close();
           }
}