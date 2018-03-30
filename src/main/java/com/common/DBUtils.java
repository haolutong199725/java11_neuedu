package com.common;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;


public class DBUtils {
             private static Properties ps= new Properties();
             static {
            	 InputStream is=Thread.currentThread().getContextClassLoader().getResourceAsStream("jdbc.properties");
            	 try {
					ps.load(is);
					Class.forName(ps.getProperty("driver"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
             }
             public static Connection getConnection() throws 	SQLException{
				Connection conn=null;
				conn=DriverManager.getConnection(ps.getProperty("url"),ps.getProperty("user"),ps.getProperty("password"));
				return conn;
            	 
             }
             public static void close(Connection conn)throws SQLException{
            	 conn.close();
             }
             public static void close(Connection conn,PreparedStatement st)throws SQLException{
            	 conn.close();
            	 st.close();
             }
             public static void close(Connection conn,Statement st)throws SQLException{
            	 conn.close();
            	 st.close();
             }
             public static void close(Connection conn,PreparedStatement st,ResultSet rs)throws SQLException{
            	 conn.close();
            	 st.close();
            	 rs.close();
             }

}
