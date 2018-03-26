package com.bitcamp.guest.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.guest.model.Member;
import com.bitcamp.guest.service.LoginService;

@Controller
@RequestMapping("/member/loginform")
public class LoginController {

		//의존주입 해줘야함 
	@Autowired
	LoginService service;
	
		@RequestMapping(method = RequestMethod.GET)
		public String loginform() {
			System.out.println("학인");
			//loginform 이동
			return "member/loginform";
			
		}
		
		
		@RequestMapping(method=RequestMethod.POST)
		public String login(@RequestParam(value ="member_id",defaultValue ="1")String member_id,
							@RequestParam(value = "password", required = false)String password,
							HttpSession session) {
			//로그인 여부 체크 
			Member member = service.selectByIdService(member_id, password);
			String view = null;
			if(member!=null) {
			
				member.setPassword(null);
				session.setAttribute("loginInfo",member);
			
				view = "member/mypage";
			}else {
				session.setAttribute("loginInfo","로그인에 실패하였습니다");
				view = "member/fail";
			}
			
			
			return view;
		}
}
