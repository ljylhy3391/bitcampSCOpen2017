package com.bitcamp.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitcamp.mvc.model.Member;
import com.bitcamp.mvc.model.MemberListXml;
import com.bitcamp.mvc.model.MemberXml;
import com.bitcamp.mvc.service.MemberListService;

@Controller
public class MemberListXmlController
{
	@Autowired
	private MemberListService memberListService;
	
	@RequestMapping(value = "/member/memberlist.xml")
	@ResponseBody
	public MemberListXml listxml()
	{
		return getMemberListXml();
	}
	
	private MemberListXml getMemberListXml()
	{
		List<MemberXml> memberListXml = new ArrayList<MemberXml>();
		List<Member> memberList = memberListService.selectAll();
		for (Member member : memberList) {
			memberListXml.add(new MemberXml(member.getId(), member.getEmail(), member.getName(), member.getRegisterDate()));
		}
		return new MemberListXml(memberListXml);
	}
}
