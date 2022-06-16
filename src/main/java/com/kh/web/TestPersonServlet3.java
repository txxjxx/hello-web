package com.kh.web;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/testPerson3.do")
public class TestPersonServlet3 extends HttpServlet {
	
	/**
	 * POST 요청 처리시 doPost 오버라이드
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// 1. 인코딩처리(POST요청시 필수)
		request.setCharacterEncoding("utf-8");
		
		// 2. 사용자입력값 처리
		String name = request.getParameter("name");
		String color = request.getParameter("color");
		String animal = request.getParameter("animal");
		String[] foods = request.getParameterValues("food");
		
		System.out.println("name = " + name);
		System.out.println("color = " + color);
		System.out.println("animal = " + animal);
		System.out.println("foods = " + (foods != null ? Arrays.toString(foods) : null));
		
		// 3. 업무로직
		// 추천서비스
		String recommendation = "";
		switch(color) {
		case "빨강" : recommendation = "빨간 초장을 버무린 회덮밥"; break;
		case "노랑" : recommendation = "산뜻한 노란 우산"; break;
		case "초록" : recommendation = "초록색 배춧잎"; break;
		case "파랑" : recommendation = "파랑색 시원한 죠스바"; break;
		}
		
		// 4. 응답메세지 작성 -> jsp위임
		// jsp에 데이터 전달 : request속성 등록
		request.setAttribute("recommendation", recommendation);
		
		RequestDispatcher reqDispatcher = 
				request.getRequestDispatcher("/testPersonResult.jsp");
		reqDispatcher.forward(request, response);
		
	}
	
}





