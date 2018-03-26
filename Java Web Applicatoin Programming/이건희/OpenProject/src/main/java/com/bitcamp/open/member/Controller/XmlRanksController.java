package com.bitcamp.open.member.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.open.member.Model.Member;
import com.bitcamp.open.member.Model.MemberMessage;
import com.bitcamp.open.member.service.MemberListService;
import com.bitcamp.open.member.service.MemberMessageList;

@Controller
public class XmlRanksController {
	@Autowired
	MemberListService service;
	
	@RequestMapping("/member/lsitXml")
	@ResponseBody
	public MemberMessageList getXml() {
		return getXmllist();
	}

	
	

	public MemberMessageList getXmllist() {

		List<MemberMessage> list = new ArrayList<MemberMessage>();
		
		list = service.xmlList();
		return new MemberMessageList(list);
	}

	

}
