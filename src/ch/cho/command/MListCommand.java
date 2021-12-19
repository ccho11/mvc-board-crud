package ch.cho.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch.cho.dao.memberDAO;
import ch.cho.dto.memberDTO;

public class MListCommand implements MCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		memberDAO dao = new memberDAO();
		ArrayList<memberDTO> dtos = dao.list();
		request.setAttribute("dtos", dtos);
	}
}
