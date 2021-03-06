package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Calculator
 */
@WebServlet("/calcul")
public class Calculator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Calculator() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String xStr = request.getParameter("x");
		String yStr = request.getParameter("y");
		String operator = request.getParameter("operator");
		
		int x = 0;
		int y = 0;
		
		if (xStr == null || xStr.equals("") || yStr == null || yStr.equals("")) {
			out.print("올바른 숫자를 입력해 주세요");
		} else {
			try {
				x = Integer.parseInt(xStr);
				y = Integer.parseInt(yStr);
			} catch (Exception e) {
				e.printStackTrace();
			}
			switch (operator) {
			case "+":
				out.print("계산 결과 : " + (x + y)); break;
				
			case "-":
				out.print("계산 결과 : " + (x - y)); break;
				
			case "x":
				out.print("계산 결과 : " + (x * y)); break;
				
			case "/":
				out.print("계산 결과 : " + (x / y)); break;

			default:
				break;
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
