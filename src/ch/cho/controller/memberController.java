package ch.cho.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import ch.cho.command.MCommand;
import ch.cho.command.MDeleteCommand;
import ch.cho.command.MInsertCommand;
import ch.cho.command.MListCommand;
import ch.cho.command.MUpdateCommand;
import ch.cho.command.MViewCommand;

@WebServlet("*.do")
public class memberController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String viewPage =null;
		MCommand command = null;
		
		String uri = request.getRequestURI(); 
		String com= uri.substring(uri.lastIndexOf("/")+ 1, uri.lastIndexOf(".do"));
		
		if(com !=null && com.trim().equals("list")) {
			command = new MListCommand();
			command.execute(request, response);
			viewPage = "/WEB-INF/view/mList.jsp";
		}else if(com !=null && com.trim().equals("insertform")) {
			viewPage = "/WEB-INF/view/mInsertform.jsp";
			
		}else if(com !=null && com.trim().equals("insert")) {
			command = new MInsertCommand();
			command.execute(request, response);
			viewPage ="list.do";
		}else if(com !=null && com.trim().equals("view")) {
			command = new MViewCommand();
			command.execute(request, response);
			viewPage = "/WEB-INF/view/mView.jsp";
		}
		else if(com !=null && com.trim().equals("update")){
			command = new MUpdateCommand();
			command.execute(request, response);
			viewPage = "list.do";
		}
		else if(com !=null && com.trim().equals("delete")){
			command = new MDeleteCommand();
			command.execute(request, response);
			viewPage = "list.do";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

}