package com.bridgelabz.addressbook.model;
import com.bridgelabz.addressbook.dto.AddressBookDto;
public class AddressBookData {
	private int personId;
	private String name;
	private String city;
	public AddressBookData() {

	}
	public AddressBookData(int personId,AddressBookDto addressBookDto) {
		this.personId=personId;
		this.name=addressBookDto.name;
		this.city=addressBookDto.city;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
}
