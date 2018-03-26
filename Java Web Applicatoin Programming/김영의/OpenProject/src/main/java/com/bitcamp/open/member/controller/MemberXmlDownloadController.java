package com.bitcamp.open.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitcamp.open.member.model.Member2;
import com.bitcamp.open.member.service.MemberListService;
import com.bitcamp.open.member.view.MemberXmlListView;

@Controller
public class MemberXmlDownloadController {

	@Autowired
	private MemberListService memberListService;

	@RequestMapping("/member/downloadXml/list.xml")
	@ResponseBody
	public MemberXmlListView getXml() {
		return getMemberXml();
	}

	private MemberXmlListView getMemberXml() {
		List<Member2> members = memberListService.xmlList();
		return new MemberXmlListView(members);
	}
}
