package com.bitcamp.open.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.open.member.model.Member;
import com.bitcamp.open.member.service.MemberListService;

@Controller
public class MemberXlsDownloadController
{
	@Autowired
	private MemberListService memberListService;
	
	@RequestMapping("/member/downloadXls")
	public ModelAndView getXlsList()
	{
		// 멤버 리스트를 받아옴
		List<Member> memberList = memberListService.listview();
		
		// servlet-context.xml에 등록된 memberListXls 빈으로 뷰처리
		return new ModelAndView("memberListXlsView", "memberList", memberList);
	}
	
}
