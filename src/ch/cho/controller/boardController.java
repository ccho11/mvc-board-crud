package ch.cho.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch.cho.command.BCommand;
import ch.cho.command.BDeleteCommand;
import ch.cho.command.BInsertCommand;
import ch.cho.command.BListCommand;
import ch.cho.command.BUpdateCommand;
import ch.cho.command.BViewCommand;

@WebServlet("*.doo")
public class boardController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String viewPage =null;
		BCommand command = null;
		
		String uri = request.getRequestURI(); 
		String com= uri.substring(uri.lastIndexOf("/")+ 1, uri.lastIndexOf(".doo"));
		
		if(com !=null && com.trim().equals("list")) {
			command = new BListCommand();
			command.execute(request, response);
			viewPage = "/WEB-INF/view/bList.jsp";
		}else if(com !=null && com.trim().equals("insertform")) {
			viewPage = "/WEB-INF/view/binsertform.jsp";
			
		}else if(com !=null && com.trim().equals("insert")) {
			command = new BInsertCommand();
			command.execute(request, response);
			viewPage ="list.doo";
		}else if(com !=null && com.trim().equals("view")) {
			command = new BViewCommand();
			command.execute(request, response);
			viewPage = "/WEB-INF/view/bView.jsp";
		}
		else if(com !=null && com.trim().equals("update")){
			command = new BUpdateCommand();
			command.execute(request, response);
			viewPage = "list.doo";
		}
		else if(com !=null && com.trim().equals("delete")){
			command = new BDeleteCommand();
			command.execute(request, response);
			viewPage = "list.doo";
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
