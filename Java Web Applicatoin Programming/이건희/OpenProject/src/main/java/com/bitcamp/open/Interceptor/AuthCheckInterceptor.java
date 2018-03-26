package com.bitcamp.open.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//로그인 체크 인터셉터 클래스 
public class AuthCheckInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession(false);
		if (session != null) {
			Object autobj = session.getAttribute("loginInfo");
			if (autobj != null) {
				// null이아니면
				// 정상적으로 다음 실행 할 컨트롤러나 인터셉터를 실행한다

				return true;
			}

		}
		// 로그인 정보가 없을경우
		// 로그인 페이지로 리다이렉트 처리
		response.sendRedirect(request.getContentType() + "/member/loginFrom");

		// 이후에 실행할 컨트롤러나 인터셉터가 실행되지 않는다
		return false;
	}

}
