package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.common.DBUtils;
import com.dao.LoginDao;
import com.entity.User;
import org.springframework.stereotype.Repository;

public class LoginDaoImpl implements LoginDao {

	@Override
	public User loginByUsenameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		User user=null;
			 try {
				conn=DBUtils.getConnection();
				String sql="select user_id,user,passwrod from user where user=? and passwrod=?";
				pst=conn.prepareStatement(sql);
				pst.setString(1, username);
				pst.setString(2, password);
				rs=pst.executeQuery();
				if(rs.next()){
				user=new User(rs.getInt("user_id"),rs.getString("user"),rs.getString("passwrod"));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					DBUtils.close(conn, pst, rs);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			 return user;
	}

	@Override
	public int updateTokenByuserId(String user, String token) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pst=null;
			 try {
				conn=DBUtils.getConnection();
				String sql="update user set token=? where user=?";
				pst=conn.prepareStatement(sql);
				pst.setString(1, token);
				pst.setString(2, user);
				pst.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					DBUtils.close(conn, pst);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		return 0;
	}

	@Override
	public User TokenUser(String token) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		User user=null;
			 try {
				conn=DBUtils.getConnection();
				String sql="select user,passwrod from user where token=?";
				pst=conn.prepareStatement(sql);
				pst.setString(1, token);
				rs=pst.executeQuery();
				if(rs.next()){
				user=new User(rs.getString("user"),rs.getString("passwrod"));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					DBUtils.close(conn, pst, rs);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			 return user;

	}

}
