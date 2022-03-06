package com.model;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,
                  property = "@id", scope = Customer.class)
public class Customer {

	@NotBlank(message = "First Name is mandatory")
	@Size(max = 50, message = "First name is too Long")
	private String first_name;
	
	@NotBlank(message = "LastName is mandatory")
	@Size(max = 50, message = "Last name is too Long")
	private String last_name;
	
	@NotBlank(message = "Street is mandatory")
	@Pattern(message = "street no.  must be a number", regexp="^[0-9]*$")
	private String  street;
	
	@NotBlank(message = "Building is mandatory")
	private String building;
	
	@NotBlank(message = "Postcode is mandatory")
	@Pattern(message = "Postcode must be a number", regexp="^[0-9]*$")
	private String postcode;
	
	@NotBlank(message = "Address is mandatory")
	private String address;
	
	@NotBlank(message = "Contact details mandatory")
	@Pattern(message = "contact must be a number", regexp="^[0-9]*$")
	private String contactno;
	
	@NotBlank(message = "Alternate contact details mandatory")
	@Pattern(message = "Alternate contact must be a number", regexp="^[0-9]*$")
	private String alternate_contactno;
	
	@NotNull(message = "Installation Date is mandatory")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "MM/dd/yyyy")
	private Date installation_date;
	
	@NotBlank(message = "Preferable time for Delivery is mandatory")
	private String time_slot;
	

	@NotEmpty(message = "Product Details is mandatory")	
	private List<Product> product;
	

	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getBuilding() {
		return building;
	}
	public void setBuilding(String building) {
		this.building = building;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	public String getAlternate_contactno() {
		return alternate_contactno;
	}
	public void setAlternate_contactno(String alternate_contactno) {
		this.alternate_contactno = alternate_contactno;
	}
	public Date getInstallation_date() {
		return installation_date;
	}
	public void setInstallation_date(Date installation_date) {
		this.installation_date = installation_date;
	}
	public String getTime_slot() {
		return time_slot;
	}
	public void setTime_slot(String time_slot) {
		this.time_slot = time_slot;
	}
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}
	
	

	
}