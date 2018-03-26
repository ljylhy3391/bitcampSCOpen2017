package com.bitcamp.open.member.view;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.bitcamp.open.member.model.Member2;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "member-list")
public class MemberXmlListView {

	@XmlElement(name = "member")
	private List<Member2> members;

	public MemberXmlListView() {

	}

	public MemberXmlListView(List<Member2> members) {
		this.members = members;
	}

	public List<Member2> getMembers(){
		return members;
	}
}
