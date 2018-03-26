package com.bitcamp.mvc.service;

@SuppressWarnings("serial")
public class IdPasswordNotMatchingException extends RuntimeException
{
	public IdPasswordNotMatchingException(String message)
	{
		super(message);
	}
}