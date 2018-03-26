package com.bitcamp.open.member.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.open.member.service.MemberListService;

@Controller
public class DeleteController {
	@Autowired
	MemberListService service;
	@RequestMapping("/member/deleteidx")
	public String deleteIdx(@RequestParam("idx")String idx) {
		String page=null;
		System.out.println("확인 dao ");
		System.out.println(idx);
		int resultCnt = service.delete(idx);
		if(resultCnt>0) {
		//삭제 성공 
			page ="redirect:memberList";
		}
		
		return page;
	}
}
