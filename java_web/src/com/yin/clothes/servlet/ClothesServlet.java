package com.yin.clothes.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yin.clothes.dto.Clothes;

public class ClothesServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Clothes> clothesList = new ArrayList<Clothes>();
		
		clothesList.add(new Clothes(1,"1","resources/img/1.jpg"));
		clothesList.add(new Clothes(1,"2","resources/img/2.jpg"));
		clothesList.add(new Clothes(1,"3","resources/img/3.jpg"));
		clothesList.add(new Clothes(1,"4","resources/img/4.jpg"));
		clothesList.add(new Clothes(1,"5","resources/img/5.jpg"));
		clothesList.add(new Clothes(1,"6","resources/img/6.jpg"));
		clothesList.add(new Clothes(1,"7","resources/img/7.jpg"));
		clothesList.add(new Clothes(1,"8","resources/img/8.jpg"));
		clothesList.add(new Clothes(1,"9","resources/img/9.jpg"));
		clothesList.add(new Clothes(1,"10","resources/img/10.jpg"));
		
		HttpSession session=request.getSession();
		session.setAttribute("ClothesList",clothesList);
		response.sendRedirect(request.getContextPath()+"/clothes.jsp");
		
	}

}
