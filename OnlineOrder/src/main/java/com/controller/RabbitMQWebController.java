package com.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exception.GeneralException;
import com.model.Customer;
import com.model.Product;
import com.service.RabbitMQSender;

@RestController
@RequestMapping(value = "/rabbitmq/api/order/")
@Validated
public class RabbitMQWebController extends GeneralException{
	private static final Logger log = LoggerFactory.getLogger(RabbitMQWebController.class.getName());

	private static final long serialVersionUID = 1L;
	
	
	@Autowired
	RabbitMQSender rabbitMQSender;
	
	 // Added sample list of Product and Packages
	 List<String> ProductList = new ArrayList<>(Arrays.asList("TV","MOBILE","TELEPHONY","INTERNET"));
	 List<String> ChannelsPkg = new ArrayList<>(Arrays.asList("90","140")); 
	 List<String> Internetpkg = new ArrayList<>(Arrays.asList("250Mbps","1Gbps"));
	 List<String> Mobilepkg = new ArrayList<>(Arrays.asList("Prepaid","Postpaid"));
	 List<String> Telephonypkg = new ArrayList<>(Arrays.asList("Free On net Calls","Unlimited Calls"));
	 
	 boolean result=true;

	
	@PostMapping(value = "/producemq")
	public ResponseEntity<String> producemq(@Valid @RequestBody Customer customer) {
	
	List<Product> strproduct = customer.getProduct();
	
	
    strproduct.forEach(e -> {

		if(ProductList.contains(e.getProduct_name())) {
			
			switch ((e.getProduct_name()).toUpperCase()){
			
						 case "TV" 			:    if(!ChannelsPkg.contains(e.getProduct_package())) 
							                              result=false;
												 else
													      result=true;
						 					     break;
						 case "MOBILE" 		:  	 if(!Mobilepkg.contains(e.getProduct_package())) 
							                              result=false;
												 else
													      result=true;
						 					     break;
						 case "TELEPHONY" 	:    if(!ChannelsPkg.contains(e.getProduct_package())) 
							                              result=false;
												 else
													      result=true;
						 					     break;
						 case "INTERNET" 	:    if(!Mobilepkg.contains(e.getProduct_package())) 
							                               result=false;
												 else
													       result=true;
						 					     break;
			
			}
			
			
		}else {
			 result=false;
		}
	

});
log.info("result->"+result);
			if(result) {
				 rabbitMQSender.sendcustomerdtls(customer);
				 return ResponseEntity.ok("Your order is been processed - Message sent to the RabbitMQ");
			}else {
		         return ResponseEntity.ok("Product or Product Package is Not Found ");
				
			}
	}
 
	
}
