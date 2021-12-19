package ch.cho.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch.cho.dao.boardDAO;
import ch.cho.dto.boardDTO;

public class BListCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		boardDAO dao = new boardDAO();
		ArrayList<boardDTO> dtos = dao.list();
		request.setAttribute("dtos", dtos);
	}

}
