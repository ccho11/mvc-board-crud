package ch.cho.command;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch.cho.dao.boardDAO;
import ch.cho.dto.boardDTO;

public class BUpdateCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		boardDTO dto = new boardDTO();
		
		dto.setBtitle(request.getParameter("btitle"));
		dto.setBcontent(request.getParameter("bcontent"));
		dto.setId(request.getParameter("id"));
		dto.setBdate(Date.valueOf(request.getParameter("bdate")));
		
		boardDAO dao = new boardDAO();
		dao.update(dto);

	}

}
