package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Calculator
 */
@WebServlet("/calcul2")
public class Calculator2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Calculator2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		// ServletContext = application 저장소
		// ServletContext application = request.getServletContext();
		
		// Session 객체를 만들어보자
		// HttpSession session = request.getSession();
		
		// 사용자가 보낸 cookie를 받는다.
		// cookie가 배열에 담겨 오니까 Cookie[]로 받는다. 
		Cookie[] cookies = request.getCookies();
		
		String vStr = request.getParameter("v");
		String operator = request.getParameter("operator");
		
		int v = 0; // 사용자가 값을 입력하지 않았을 경우의 기본값
		if (vStr != null && !vStr.equals("")) { v = Integer.parseInt(vStr); }

		
		// operator값이 무엇이냐에 따라 사용자가 입력한 Data를 저장할 때도 있고 --> (+ - / *)
		// 저장이 아닌 계산을 해야할 때도 있다. --> (=)
		// 따라서 위의 2가지 경우를 구분해야한다.
		if (operator.equals("=")) { // 1. 계산
			// x : 앞 단계에서 application을 이용해 사용자가 저장해 놓은 값 / y : 현재 사용자가 보내는 값 / op : 앞 단계에서 사용자가 저장해 놓은 연산자 Data
			
			// 사용자로부터 온 cookie값을 읽어보자
			// 그냥 읽는 것이 아니라 브라우저에서 넘어온 여러개의 cookie 중 내가 원하는 것을 찾아야한다.
			int x = 0;
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if ("value".equals(cookie.getName())) { // 서로 일치하는 key 값을 찾는 것이다.
						x = Integer.parseInt(cookie.getValue());
						// getValue()는 반환 타입이 String이므로 int로 형변환을 해야한다.
						break;
					}
				}
			}
			// int x = (int)session.getAttribute("value");
			// int x = (int)application.getAttribute("value");
			int y = v;
			
			String op = null;
			if (cookies != null) {
				for (Cookie cookie : cookies) { 
					if ("operator".equals(cookie.getName())) {  // 서로 일치하는 key 값을 찾는 것이다.
						op = cookie.getValue();
						break;
					}
				}
			}
			// String op = (String)session.getAttribute("operator");
			// String op = (String)application.getAttribute("operator");
			
			int result = 0; // 연산 결과
			
			if (op.equals("+")) {
				result = x + y;
			} else {
				result = x - y;
			}
			
			out.print("계산 결과 : " + result);
		} else { // 2. 값을 저장
			// 사용자가 첫 번째로 입력한 값을 저장하는 곳
			// Java 컬렉션의 Map처럼 Key값과 그에 해당하는 값을 저장하는 것이라고 생각하면 된다.
			// v값과 operator값을 저장해보자. 그러면 다음에 해당 값을 이용할 수 있다.
			
			//session.setAttribute("value", v);
			//session.setAttribute("operator", operator);
			
			// application.setAttribute("value", v);
			// application.setAttribute("operator", operator);
			
			// 사용자의 브라우저에 보낼 cookie를 심는다.
			// cookie값은 반드시 String 형태로 보내야하므로 String 형변환을 해야한다.
			// 더 정확히 말하면 URL에 사용할 수 있는 형태의 문자열로만 보내야한다.
			Cookie valueCookie = new Cookie("value", String.valueOf(v));
			Cookie operatorCookie = new Cookie("operator", operator);
			
			// cookie를 심었으니 클라이언트의 브라우저에 보낸다.
			// response의 Header에 심어져 보내진다.
			response.addCookie(valueCookie);
			response.addCookie(operatorCookie);
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
