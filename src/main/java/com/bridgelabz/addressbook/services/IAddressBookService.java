package com.bridgelabz.addressbook.services;
import java.util.List;
import com.bridgelabz.addressbook.dto.AddressBookDto;
import com.bridgelabz.addressbook.model.AddressBookData;
public interface IAddressBookService {
	List<AddressBookData> getAddressBookdata();
	AddressBookData getAddressBookDataById(int personId);
	AddressBookData createAddressBookData(AddressBookDto addressBookDto);
	AddressBookData updateAddressBookData(int personId,AddressBookDto addressBookDto);
	int deleteAddressBookData(int personId);
}
