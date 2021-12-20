package com.bridgelabz.addressbook.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bridgelabz.addressbook.dto.AddressBookDto;
import com.bridgelabz.addressbook.dto.ResponseDto;
import com.bridgelabz.addressbook.model.AddressBookData;
import com.bridgelabz.addressbook.services.IAddressBookService;
@RestController
@RequestMapping("/addressbookservice")
public class AddressBookController {
	@Autowired
	private IAddressBookService addressBookService;
	@RequestMapping(value= {"","/","/get"})
	public ResponseEntity<ResponseDto> getAddressBookData() {
		List<AddressBookData> addressBookList=addressBookService.getAddressBookdata();
		ResponseDto respDto=new ResponseDto("Get Call Success",addressBookList);;
		return new ResponseEntity<ResponseDto>(respDto,HttpStatus.OK);
	}
	@GetMapping("/get/{personId}")
	public ResponseEntity<ResponseDto> getAddressBookData(@PathVariable("personId") int personId) {
		ResponseDto respDto;
		AddressBookData addressBookData=addressBookService.getAddressBookDataById(personId);
		if(addressBookData!=null) {
			respDto=new ResponseDto("Get Call For Id Success",addressBookData.getName());
			return new ResponseEntity<ResponseDto>(respDto,HttpStatus.OK);
		} else {
			respDto=new ResponseDto("Id is not Present");
			return new ResponseEntity<ResponseDto>(respDto,HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/create")
	public ResponseEntity<ResponseDto> addAddressBookData(@RequestBody AddressBookDto addressBookdto) {
		addressBookService.createAddressBookData(addressBookdto);
		ResponseDto respDto=new ResponseDto("Created Address Book Data Successfully");
		return new ResponseEntity<ResponseDto>(respDto,HttpStatus.OK);
	}
	@PutMapping("/update/{personId}")
	public ResponseEntity<ResponseDto> updateAddressBookData(@PathVariable("personId") int personId,@RequestBody AddressBookDto addressBookdto) {
		ResponseDto respDto;
		if(addressBookService.updateAddressBookData(personId,addressBookdto)!=null) {
			respDto=new ResponseDto("Updated Address Book Data Successfully");
			return new ResponseEntity<ResponseDto>(respDto,HttpStatus.OK);
		} else {
			respDto=new ResponseDto("Id is not Present");
			return new ResponseEntity<ResponseDto>(respDto,HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("/delete/{personId}")
	public ResponseEntity<ResponseDto> deleteAddressBookData(@PathVariable("personId") int personId) {
		ResponseDto respDto;
		if(addressBookService.deleteAddressBookData(personId)!=0) {
			respDto=new ResponseDto("Deleted Successfully id="+personId);
		return new ResponseEntity<ResponseDto>(respDto,HttpStatus.OK);
		} else {
			respDto=new ResponseDto("Id is not Present");
			return new ResponseEntity<ResponseDto>(respDto,HttpStatus.NOT_FOUND);
		}
	}
}	