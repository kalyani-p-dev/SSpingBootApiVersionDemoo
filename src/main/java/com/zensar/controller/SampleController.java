package com.zensar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.ApiConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class SampleController {
	
	@Autowired
	ApiConfig apiConfig;
	
	@GetMapping(value ="/app/name")
	public String getAppicationName() {
		return "Application name is" +this.apiConfig.getAppName()+" operation: " + apiConfig.getOperation() ;
				//" operation: " + operation.toString();
	}
	

}
