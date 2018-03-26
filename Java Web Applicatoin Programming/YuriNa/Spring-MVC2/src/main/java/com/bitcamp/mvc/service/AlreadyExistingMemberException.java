package com.bitcamp.mvc.service;

@SuppressWarnings("serial")
public class AlreadyExistingMemberException extends RuntimeException
{
	public AlreadyExistingMemberException(String message)
	{
		super(message);
	}
}