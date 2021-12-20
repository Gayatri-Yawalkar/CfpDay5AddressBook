package com.bridgelabz.addressbook.dto;
public class AddressBookDto {
	public String name;
	public String city;
	public AddressBookDto(String name,String city) {
		this.name=name;
		this.city=city;
		}
	@Override
	public String toString() {
		return "Name="+name+" City="+city;
	}
}
