package com.bitcamp.guest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitcamp.guest.model.Member;
import com.bitcamp.guest.service.MemberListService;


@Controller
public class MemberListController {
	@Autowired
	MemberListService service;
	
	@RequestMapping("/member/list")
	public String list(Model model) {
		
		List <Member> list = service.listByService();
		String view =null;
		if(list!=null) {
			view = "member/list";
		}
		model.addAttribute("list",list);
		
	
		return view;
	}
	
	
}
