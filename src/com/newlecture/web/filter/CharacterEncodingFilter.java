package com.newlecture.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*") // ("/*") --> 모든 URL에 대해(모든 요청에 대해) filter가 적용되도록 설정한 것이다.
public class CharacterEncodingFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("before Filter");
		response.setContentType("text/html; charset = UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8"); // 모든 Servlet 파일이 별도의 지정 없이도 해당 설정을 자동으로 갖게되는 것이다.
		// Servlet에 요청(request)을 전달하기 전에 설정될 내용
		// 즉, Filter 실행 전에 설정될 내용
		
		// 사용자로부터 들어온 요청(request)이 Servlet 파일로 전달되게 하기 위한 설정
		chain.doFilter(request, response);
		// 위의 코드가 없으면 사용자의 요청(request)이 들어와도 Servlet 파일이 실행되지 않는다.
		// 반드시 [ chain.doFilter(request, response) ] 이렇게 쓸 필요는 없다.
		// 조건 검사 후 조건에 맞지 않으면 다른 곳으로 요청(request)이 전달되도록 할수도 있다.
		// 즉, doFilter() method가 다음 실행을(흐름을) 관할하는 것이다.
		
		System.out.println("after Filter");
		// Servlet으로 부터 결과가 돌아온 후 실행될 내용
		// 즉, Filter가 실행된 이후에 설정될 내용
	}
}