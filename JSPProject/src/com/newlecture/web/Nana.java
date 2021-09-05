package com.newlecture.web;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/hi")
public class Nana extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset = UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		int loop = 100; // 기본값 설정
		String loopStr = request.getParameter("loopTime");
		// getParameter() --> 사용자가 전달하는 쿼리 스트링의 키워드를 읽을 수 있다.
		// 사용자 입력값은 무조건 문자열로 전달된다.
		
		if (loopStr != null && !loopStr.equals("")) {
			loop = Integer.parseInt(loopStr);
		}
		// [ /hello?loopTime= ] 일때 얘기
		// (loopStr != null) --> 이 조건만으로는 loopStr가 "" 일때(빈 문자열) 오류가 발생한다. 
		// 빈 문자열을 int형으로 변경할 수는 없다.
		// 따라서 if문의 조건을 추가해야 한다. --> (loopStr != null && !loopStr.equals(""))
		// loopStr에 정확하게 숫자가 왔을 때만 Integer.parseInt()로 변환하겠다는 의미이다.
		
		// 만약 조건을 (loopStr != null)로만 하면 ""은 null이 아니므로 if문의 조건을 만족하게 되고
		// loop = Integer.parseInt("");를 변환해야한다.
		// 근데 빈 문자열인 ""를 int로 변환할 수 없으니까 오류가 발생하는 것이다.
		
		// 나머지 (/hello?)과 (/hello)에서 loopStr은 null이 된다. (/hello?loopTime=) 일때는 ""이 된다.
		// 이러면 어차피 if문의 조건을 만족하지 못 하므로 아래의 for문에 기본으로 설정한 (loop = 100)값이 들어가는 것이다.
		// null값 or ""값 인 loopStr은 더 이상 쓸모도 없고 쓸 곳도 없는 상태가 되버린 것이다.
		for (int i = 0; i < loop ; i++) {
			out.println((i + 1) + "번 : " +  " Hello Servlet 안녕" + "<br>");
		}
	}
}
