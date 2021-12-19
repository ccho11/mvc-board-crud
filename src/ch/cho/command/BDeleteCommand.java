package ch.cho.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch.cho.dao.boardDAO;

public class BDeleteCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8"); 
		String btitle = request.getParameter("btitle");
		String id = request.getParameter("id");
		  
		boardDAO dao = new boardDAO();  
		dao.delete(btitle,id);

	}

}
