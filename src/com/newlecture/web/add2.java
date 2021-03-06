package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class add2
 */
@WebServlet("/add2")
public class add2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public add2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset = UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String operator = request.getParameter("operator");
		
		// 기존 : String xStr = request.getParameter("num");
		String[] numArr = request.getParameterValues("num");
		// 여러개의 값이 하나의 이름으로 오므로 getParameter() 대신 getParameterValues() method를 이용한다.
		// String[] --> 배열의 형태로 받으니 참조 자료형도 배열 모양으로 정한다.(numArr은 임의로 정한 이름)
		
		int result = 0; // 계산결과값
		
		if (operator.equals("+")) {
			for (int i = 0; i < numArr.length; i++) {
				int num = Integer.parseInt(numArr[i]);
				result+=num;
			}
		} else {
			for (int i = 0; i < numArr.length; i++) {
				int num = Integer.parseInt(numArr[i]);
				result-=num;
			}
		}
		out.print("계산 결과 : " +  result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
