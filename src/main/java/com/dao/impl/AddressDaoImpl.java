package com.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.common.DBUtils;
import com.dao.AddressDao;
import com.entity.Address;
import com.entity.PageModel;
import org.springframework.stereotype.Repository;
public class AddressDaoImpl implements AddressDao {

	@Override
	public int addAddress(Integer userid, Address address) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pst=null;
			 try {
				conn=DBUtils.getConnection();
				String sql="insert into address(user_id,receiver_name,receiver_phone,receiver_mobile,receiver_province,receiver_city) values(?,?,?,?,?,?)";
				 pst=conn.prepareStatement(sql);
				 pst.setInt(1, address.getUserid());
				 pst.setString(2,address.getReceivername());
				 pst.setString(3,address.getReceiverphone());
				 pst.setString(4,address.getReceivermobile());
				 pst.setString(5,address.getReceiverprovince());
				 pst.setString(6,address.getReceivercity());
				
				return pst.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					DBUtils.close(conn,pst);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			 return 0;
	}

	@Override
	public int deleteAddressByUserid(Integer userid,String receivercity) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pst=null;
			 try {
				conn=DBUtils.getConnection();
				String sql="delete from address where user_id=? and receiver_city=?";
				pst=conn.prepareStatement(sql);
				pst.setInt(1, userid);
				pst.setString(2,  receivercity);
				return pst.executeUpdate();
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
	public int updateUserAddressByUserid(Integer userid, Address address,String receivercity) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pst=null;
		
		try {
			conn=DBUtils.getConnection();
			String sql="update address set  user_id=?,receiver_name=?,receiver_phone=?,receiver_mobile=?,receiver_province=?,receiver_city=? where user_id=? and receiver_city=?";
			pst=conn.prepareStatement(sql);
		    pst.setInt(1, address.getUserid());
		    pst.setString(2,address.getReceivername());
		    pst.setString(3, address.getReceiverphone());
		    pst.setString(4,address.getReceivermobile());
		    pst.setString(5,address.getReceiverprovince());
		    pst.setString(6,address.getReceivercity());
		    pst.setInt(7, address.getUserid());
		    pst.setString(8, address.getReceivercity());
		    return pst.executeUpdate();
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
	public PageModel<Address> findUserAddress(Integer pageNo, Integer pageSize, Integer userid) {
		// TODO Auto-generated method stub
		PageModel<Address> pageModel=new PageModel<Address>();
	     
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			conn=DBUtils.getConnection();
		
			//��ѯ�ܵļ�¼��
			String sqlcount="select count(user_id) from address where user_id=?";
			pst=conn.prepareStatement(sqlcount);
			pst.setInt(1, userid);
			rs=pst.executeQuery();
			if(rs.next()) {
			  int totalCount=rs.getInt(1);//�ܵļ�¼
			  //���㹲����ҳ
			 int totalPage= (totalCount%pageSize)==0?totalCount/pageSize:(totalCount/pageSize+1);
			 pageModel.setTotalPage(totalPage);
			  
			}
			
			String sql="select user_id,receiver_name,receiver_phone,receiver_mobile,receiver_province,receiver_city from address where user_id=?  limit ?,?  ";
			pst=conn.prepareStatement(sql);
			 pst.setInt(1, userid);
		     pst.setInt(2, (pageNo-1)*pageSize);
		     pst.setInt(3, pageSize);
			rs=pst.executeQuery();
			List<Address> list=new ArrayList<Address>();
			while(rs.next()) {
	
				Address address=new Address(rs.getInt("user_id"),rs.getString("receiver_name"),rs.getString("receiver_phone"),rs.getString("receiver_mobile"),rs.getString("receiver_province"),rs.getString("receiver_city"));
				list.add(address);
			}
			
			pageModel.setData(list);
			
			
			
			
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.close(conn,pst,rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		return pageModel;
	}

	@Override
	public Address selectAddressByUseridAndId(Integer userid, String receivercity) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		Address address=null;
		try {
			conn=DBUtils.getConnection();
			pst=conn.prepareStatement("select user_id,receiver_name,receiver_phone,receiver_mobile,receiver_province,receiver_city from address where user_id=? and receiver_city=?");
		     pst.setInt(1, userid);
		     pst.setString(2, receivercity);
			rs=pst.executeQuery();
			
			if(rs.next()) {
				address=new Address(rs.getInt("user_id"),rs.getString("receiver_name"),rs.getString("receiver_phone"),rs.getString("receiver_mobile"),rs.getString("receiver_province"),rs.getString("receiver_city"));
				
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
		return address;
		
	}

}
