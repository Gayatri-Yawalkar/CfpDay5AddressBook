package com.bridgelabz.addressbook.dto;
public class ResponseDto {
	private String message;
	Object name;
	public ResponseDto(String message) {
		this.message=message;
	}
	public ResponseDto(String message,Object name) {
		this.message=message;
		this.name=name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getName() {
		return name;
	}
	public void setName(Object name) {
		this.name = name;
	}
}
