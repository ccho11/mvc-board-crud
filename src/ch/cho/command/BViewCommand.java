package ch.cho.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch.cho.dao.memberDAO;
import ch.cho.dto.memberDTO;

public class BViewCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		String btitle = request.getParameter("btitle");
		memberDAO dao = new memberDAO();
		memberDTO dto = dao.view(btitle);
		request.setAttribute("dto", dto);

	}

}
