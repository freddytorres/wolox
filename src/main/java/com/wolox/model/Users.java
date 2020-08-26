package com.wolox.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@SequenceGenerator(name = "UsersSeq", sequenceName = "USERS_SEQ", initialValue = 1, allocationSize = 100)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
public class Users implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UsersSeq")
	private long id;
	private String name;
	private String username;
	private String email;
	private String address_street;
	private String address_suite;
	private String address_city;
	private String address_zipcode;
	private String address_geo_lat;
	private String address_geo_lng;
	private String phone;
	private String website;
	private String company_name;
	private String company_catchPhrase;
	private String company_bs;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress_street() {
		return address_street;
	}

	public void setAddress_street(String address_street) {
		this.address_street = address_street;
	}

	public String getAddress_suite() {
		return address_suite;
	}

	public void setAddress_suite(String address_suite) {
		this.address_suite = address_suite;
	}

	public String getAddress_city() {
		return address_city;
	}

	public void setAddress_city(String address_city) {
		this.address_city = address_city;
	}

	public String getAddress_zipcode() {
		return address_zipcode;
	}

	public void setAddress_zipcode(String address_zipcode) {
		this.address_zipcode = address_zipcode;
	}

	public String getAddress_geo_lat() {
		return address_geo_lat;
	}

	public void setAddress_geo_lat(String address_geo_lat) {
		this.address_geo_lat = address_geo_lat;
	}

	public String getAddress_geo_lng() {
		return address_geo_lng;
	}

	public void setAddress_geo_lng(String address_geo_lng) {
		this.address_geo_lng = address_geo_lng;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getCompany_catchPhrase() {
		return company_catchPhrase;
	}

	public void setCompany_catchPhrase(String company_catchPhrase) {
		this.company_catchPhrase = company_catchPhrase;
	}

	public String getCompany_bs() {
		return company_bs;
	}

	public void setCompany_bs(String company_bs) {
		this.company_bs = company_bs;
	}
}