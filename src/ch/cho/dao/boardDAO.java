package ch.cho.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import ch.cho.dto.boardDTO;

public class boardDAO {
	private DataSource ds;
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public boardDAO() {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/CHO");
			
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
	
	public ArrayList<boardDTO> list(){
		String sql = "SELECT * FROM BOARD";
		
		ArrayList<boardDTO> dtos = new ArrayList<boardDTO>();
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {		
				boardDTO dto = new boardDTO();
				dto.setBtitle(rs.getString("btitle"));
				dto.setBcontent(rs.getString("bcontent"));
				dto.setBdate(rs.getDate("bdate"));
				dto.setId(rs.getString("id"));
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


	public boardDTO view(String btitle) {
		String sql ="select btitle,bcontent,id from board where title=?";
		boardDTO dto = new boardDTO();
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, btitle);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {	
				dto.setBtitle(btitle);
				dto.setBcontent(rs.getString("bcontent"));
				dto.setBdate(rs.getDate("bdate"));
				dto.setId(rs.getString("id"));
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
	
	public void insert(boardDTO dto) {	
		String sql = "insert into board(btitle, bcontent, id, bdate) values(?,?,?,SYSDATE)"; 
		
		try {  
			con = ds.getConnection();  
			pstmt =con.prepareStatement(sql);  	
			pstmt.setString(1, dto.getBtitle());
			pstmt.setString(2, dto.getBcontent());
			pstmt.setString(3, dto.getId());	
			
			pstmt.executeUpdate();

			pstmt.close();
			close();
		}catch(SQLException ex) {
			
		}finally {
			close();
		}
		
	}
	
	
	public void update(boardDTO dto) {
		String sql = "update board set bcontent=?, bdate=?, id=? where btitle=?";
		
		try {
			con = ds.getConnection();
			pstmt =con.prepareStatement(sql);
			pstmt.setString(1, dto.getBcontent());
			pstmt.setDate(2, dto.getBdate());
			pstmt.setString(3, dto.getId());
			pstmt.setString(4, dto.getBtitle());
			
			pstmt.executeUpdate();	

			pstmt.close();
			
		}catch(SQLException ex) {
			System.out.println("SQL update 오류 : " + ex.getLocalizedMessage());
		}finally {
			close();
		}

	}
	
	public void delete(String btitle,String id) {
		String sql = "delete from board where btitle=?,id=?";
		
		try {
			con = ds.getConnection();
			pstmt =con.prepareStatement(sql);
			pstmt.setString(1, btitle);
			pstmt.setString(2, id);
			
			pstmt.executeUpdate();	


			pstmt.close();
			
		}catch(SQLException ex) {
			System.out.println("SQL delete 오류 : " + ex.getLocalizedMessage());
		}finally {
			close();
		}

	}
	
}
