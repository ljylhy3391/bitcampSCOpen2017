package com.bitcamp.open.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//로그인 체크 인터셉터 클래스
public class AuthCheckInterceptor extends HandlerInterceptorAdapter {
	//보통 모든 요청마다 Controller에서 session을 통해 로그인 정보가 남아 있는지를 확인함
	//Interceptor를 먼저 수행해 session에서  로그인 정보가 있는지 확인해 주는 역할을 한다면, 중복 코드가 확 줄어들 수 있을 것이다.

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// 세션 정보 확인
		HttpSession session = request.getSession(false);

		if (session != null) {
			Object authInfo = session.getAttribute("loginInfo");
			if (authInfo != null) {
				// 정상적으로 다음 실행 할 컨트롤러나 인터셉터를 실행한다.
				return true;
			}
		}

		response.sendRedirect(request.getContextPath() + "/member/login");

		// 이후에 실행할 컨트롤러나 인터셉터가 실행 되지 않는다.
		return false;
	}

}
