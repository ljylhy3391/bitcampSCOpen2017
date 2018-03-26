package com.bitcamp.open.member.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.open.member.Model.Member;
import com.bitcamp.open.member.Model.PageRank;
import com.bitcamp.open.member.service.MemberListService;

@Controller
public class XlsRanksController {
	@Autowired
	MemberListService service;
	
	@RequestMapping("/member/lsitXls")
	public ModelAndView getXlslist() {
		
		List<Member> member = new ArrayList<Member>();
		member = service.getMemberList();
			
		
		return new ModelAndView("pageRanks","member",member);
	}
	
	
	
	
}
