package com.bitcamp.guest.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.guest.model.Member;
import com.bitcamp.guest.service.MemberListService;

@Controller
@RequestMapping("/member/updateForm")
public class UpdateController {
	@Autowired
	private MemberListService memberlistservice;

	// post
	/*@RequestMapping(method = RequestMethod.POST)
	public String Update(@RequestParam("member_id") String member_id, Model model) {

		Member member = memberlistservice.updateMember(member_id);

		model.addAttribute("member", member);
		return "member/update";
	}
*/
	
	@RequestMapping(method=RequestMethod.GET)
	public String updateF(@RequestParam(value="member_id",defaultValue="0") String member_id,Model model){
		Member member= memberlistservice.regMember(member_id);
		
		model.addAttribute("member",member);
		return "member/updateForm";
		
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public String update(Model model,Member member) {//member문제
	
		int resultCnt =	memberlistservice.updateMember(member);
	
		if(resultCnt>0) {
			//실행 
			model.addAttribute("msg","실행");
		}
		
		return "member/update";
	
	}
	
	

}
