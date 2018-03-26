package com.bitcamp.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.mvc.model.Member;
import com.bitcamp.mvc.service.MemberListService;

@Controller
public class DownloadController
{
	@Autowired
	private MemberListService memberListService;
	
	@RequestMapping("/downloadXls")
	public ModelAndView getXlsList()
	{
		List<Member> memberList = memberListService.selectAll();
		return new ModelAndView("memberListXls", "memberListXls", memberList);
	}
	
}
