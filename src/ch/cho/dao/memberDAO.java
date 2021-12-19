package ch.cho.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import ch.cho.dto.memberDTO;

public class memberDAO {

	private DataSource ds;
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public memberDAO() {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/JSP");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			if(con !=null) {
				con.close();
				con=null;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	


	
	public ArrayList<memberDTO> list(){
		String sql = "SELECT * FROM MEMBER";
		
		ArrayList<memberDTO> dtos = new ArrayList<memberDTO>();
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {		
				memberDTO dto = new memberDTO();
				dto.setId(rs.getString("id"));
				dto.setPwd(rs.getString("pwd"));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				dto.setJoindate(rs.getDate("joindate"));
				dtos.add(dto);	
			}
			rs.close(); pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return dtos;
	}



	
	public memberDTO view(String id) {
		String sql ="select pwd,name,email,joindate from MEMBER where id=?";
		memberDTO dto = new memberDTO();
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {	
				dto.setId(id);
				dto.setPwd(rs.getString("pwd"));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				dto.setJoindate(rs.getDate("joindate"));
			}
			
			rs.close();
			pstmt.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return dto;
	}
	


	
	public void insert(memberDTO dto) {	
		String sql = "insert into MEMBER(id, pwd, name, email, joindate) values(?,?,?,?, SYSDATE)"; 
		
		try {  
			con = ds.getConnection();  
			pstmt =con.prepareStatement(sql);  	
			pstmt.setString(1, dto.getId());	
			pstmt.setString(2, dto.getPwd());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getEmail());
			
			pstmt.executeUpdate();

			pstmt.close();
			close();
		}catch(SQLException ex) {
			
		}finally {
			close();
		}
		
	}
	
	
	public void update(memberDTO dto) {
		String sql = "update MEMBER set name=?, pwd=?, email=?, joindate=? where id=?";
		
		try {
			con = ds.getConnection();
			pstmt =con.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getPwd());
			pstmt.setString(3, dto.getEmail());
			pstmt.setDate(4, dto.getJoindate()); 
			pstmt.setString(5, dto.getId());
			
			pstmt.executeUpdate();	

			pstmt.close();
			
		}catch(SQLException ex) {
			System.out.println("SQL update 오류 : " + ex.getLocalizedMessage());
		}finally {
			close();
		}

	}
	
	
	public void delete(String id) {
		String sql = "delete from MEMBER where id=?";
		
		try {
			con = ds.getConnection();
			pstmt =con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			pstmt.executeUpdate();	


			pstmt.close();
			
		}catch(SQLException ex) {
			System.out.println("SQL delete 오류 : " + ex.getLocalizedMessage());
		}finally {
			close();
		}

	}
}
