package com.bitcamp.mvc.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "member-list")
public class MemberListXml
{
	@XmlElement(name = "member")
	private List<MemberXml> memberListXml;
	
	public MemberListXml()
	{
		
	}
	
	public MemberListXml(List<MemberXml> memberListXml)
	{
		this.memberListXml = memberListXml;
	}
	
	public List<MemberXml> getMemberListXml()
	{
		return memberListXml;
	}
}
