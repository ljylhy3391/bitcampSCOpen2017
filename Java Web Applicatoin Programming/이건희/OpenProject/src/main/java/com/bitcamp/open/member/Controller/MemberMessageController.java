package com.bitcamp.open.member.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitcamp.open.member.Model.MemberMessage;
import com.bitcamp.open.member.service.MemberListService;
import com.bitcamp.open.member.service.MemberMessageList;

public class MemberMessageController {
	@Autowired
	MemberListService service;
	
	@RequestMapping("/guestmessage/list.xml")
	public MemberMessageList getMessageList(Model model) {
		List<MemberMessage> messages = new ArrayList<MemberMessage>();

		///서비스 주입 
		return new MemberMessageList(messages);
	}
}
