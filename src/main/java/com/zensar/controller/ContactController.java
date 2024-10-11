package com.zensar.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

	/* Content Negotiation based */
	@GetMapping(value="/api/contact", produces = "application/contact.v2+json")
	public ResponseEntity<Contact> getContactContentNegotiation() {
		Contact contact = new Contact("Tom");
		return new ResponseEntity<Contact>(contact, HttpStatus.OK);
	}
	@GetMapping(value="/api/contact", produces = "application/contact.v1+json")
	public ResponseEntity<ContactV2> getContactContentNegotiation2() {
		ContactV2 contact = new ContactV2("Tom");
		return new ResponseEntity<ContactV2>(contact, HttpStatus.OK);
	}
	
	
	/* Header parameter based */
	@GetMapping(value="/api/contact", headers = "version=v1")
	public ResponseEntity<Contact> getContactHeader() {
		Contact contact = new Contact("Tom");
		return new ResponseEntity<Contact>(contact, HttpStatus.OK);
	}
	@GetMapping(value="/api/contact", headers = "version=v2")
	public ResponseEntity<ContactV2> getContactHeader2() {
		ContactV2 contact = new ContactV2("Tom");
		return new ResponseEntity<ContactV2>(contact, HttpStatus.OK);
	}
	
	
	
	/* Query parameter based */
	@GetMapping(value="/api/contact", params = "version=v1")
	public ResponseEntity<Contact> getContactQuery() {
		Contact contact = new Contact("Tom");
		return new ResponseEntity<Contact>(contact, HttpStatus.OK);
	}
	@GetMapping(value="/api/contact", params = "version=v2")
	public ResponseEntity<ContactV2> getContactQuery2() {
		ContactV2 contact = new ContactV2("Tom");
		return new ResponseEntity<ContactV2>(contact, HttpStatus.OK);
	}
	
	
	
	
	/* PATH Parameter based API versioning */
	@GetMapping(value="/api/v1/contact")
	public ResponseEntity<Contact> getContact() {
		Contact contact = new Contact("Tom");
		return new ResponseEntity<Contact>(contact, HttpStatus.OK);
	}
	@GetMapping(value="/api/v2/contact")
	public ResponseEntity<ContactV2> getContactV2() {
		ContactV2 contact = new ContactV2("Tom");
		return new ResponseEntity<ContactV2>(contact, HttpStatus.OK);
	}
}

class ContactV2 {
	String firstname;
	public ContactV2() {}
	public ContactV2(String firstname) {
		super();
		this.firstname = firstname;
	}
	public String getFirstName() {
		return firstname;
	}
	public void setFirstName(String firstname) {
		this.firstname = firstname;
	}
	@Override
	public String toString() {
		return "ContactV2 [firstname=" + firstname + "]";
	}
}

class Contact {
	String name;
	public Contact() {}
	public Contact(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Contact [name=" + name + "]";
	}
	
}