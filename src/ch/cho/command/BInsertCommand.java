package ch.cho.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch.cho.dao.boardDAO;
import ch.cho.dto.boardDTO;

public class BInsertCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		boardDTO dto = new boardDTO();
		
		dto.setBtitle(request.getParameter("btitle"));
		dto.setBcontent(request.getParameter("bcontent"));
		dto.setId(request.getParameter("id"));
		
		boardDAO dao = new boardDAO();	
		dao.insert(dto);		
	}

}
