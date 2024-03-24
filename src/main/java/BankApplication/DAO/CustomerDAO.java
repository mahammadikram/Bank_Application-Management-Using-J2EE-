package BankApplication.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import BankApp.Connection.*;
import BankApplication.DAO.*;
import BankApp.Connection.BankConnection;

public class CustomerDAO {
	public static  Customer getCustomer(int Account_No,int  Pin) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from bank.customer where Account_no=? and Pin=?";
		Customer c=null;
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			con=BankConnection.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,Account_No);
			pstmt.setInt(2, Pin);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				c=new Customer();
				c.setAccount_no(rs.getInt("Account_no"));
				c.setName(rs.getString("name"));
				c.setMobile_no(rs.getLong("Mobile_No"));
				c.setPin(rs.getInt("pin"));
				c.setAddress(rs.getString("Address"));
				c.setBalnece(rs.getInt("Balance"));
				return c;
			}
			else {
				return c;
			}
		}
	catch (ClassNotFoundException |SQLException e) {
		e.printStackTrace();
	}	finally {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pstmt!=null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
		return c;
	
}
 public static  boolean addCustomer(String name,long Mobile_no,int pin,String address,double balance){
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql="insert into bank.customer (Name,Mobile_No,Pin,Address,Balance) values(?,?,?,?,?)";
		int res=0;
		try {
			con=BankConnection.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setLong(2, Mobile_no);
			pstmt.setInt(3, pin);
			pstmt.setString(4, address);
			pstmt.setDouble(5, balance);
			res=pstmt.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		if(res>0) {
			return true;
		}
		else {
			return false;
		}
 }
 public static  boolean updateCustomer(Customer c) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int res=0;
	String sql="update bank.customer  set name=?,Mobile_no=?,pin=?, address=?,balance=? where Mobile_No=?";
		try {
			con=BankConnection.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, c.getName());
			pstmt.setLong(2, c.getMobile_no());
			pstmt.setInt(3, c.getPin());
			pstmt.setString(4, c.getAddress());
			pstmt.setDouble(5,c.getBalnece() );
			pstmt.setLong(6, c.getMobile_no());
			res=pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		if(res>0) {
			return true;
		}
		else {
			return false;
		}
 }
 public static  Customer getCustomer(long Mobile_no) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from bank.customer where Mobile_No=?";
		Customer c=null;
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			con=BankConnection.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setLong(1,Mobile_no);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				c=new Customer();
				c.setAccount_no(rs.getInt("Account_No"));
				c.setName(rs.getString("name"));
				c.setMobile_no(rs.getLong("Mobile_No"));
				c.setPin(rs.getInt("pin"));
				c.setAddress(rs.getString("Address"));
				c.setBalnece(rs.getInt("Balance"));
				return c;
			}
			else {
				return c;
			}
		}
	catch (ClassNotFoundException |SQLException e) {
		e.printStackTrace();
	}	finally {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pstmt!=null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
		return c;
	
}
}
