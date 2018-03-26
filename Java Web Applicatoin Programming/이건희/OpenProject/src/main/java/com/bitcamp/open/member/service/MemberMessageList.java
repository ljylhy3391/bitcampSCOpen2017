package com.bitcamp.open.member.service;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.bitcamp.open.member.Model.MemberMessage;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "message")
public class MemberMessageList {

	@XmlElement(name = "message")
	private List<MemberMessage> messages;

	public MemberMessageList() {
	}

	public MemberMessageList(List<MemberMessage> messages) {
		this.messages = messages;
	}

	public List<MemberMessage> getMessages() {
		return messages;
	}

}