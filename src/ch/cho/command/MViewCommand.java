package ch.cho.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch.cho.dao.memberDAO;
import ch.cho.dto.memberDTO;

public class MViewCommand implements MCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		memberDAO dao = new memberDAO();
		memberDTO dto = dao.view(id);
		request.setAttribute("dto", dto);

	}

}
