package com.wolox.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wolox.exception.ResourceNotFoundException;
import com.wolox.model.Users;
import com.wolox.repository.UsersRepository;

@Controller
public class UsersController {
	@Autowired
	UsersRepository usersRepository;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	@ResponseBody
	public List<Users> getUsers() {
		return usersRepository.findAll();
	}

	@RequestMapping(value = "/users", method = RequestMethod.POST)
	@ResponseBody
	public Users createUsers(@Valid @RequestBody Users users) {
		return usersRepository.save(users);
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Users> updateUsers(@PathVariable(value = "id") Long usersId,
			@Valid @RequestBody Users usersDetails) throws ResourceNotFoundException {
		Users users = usersRepository.findById(usersId)
				.orElseThrow(() -> new ResourceNotFoundException("Users not found : " + usersId));
		users.setName(usersDetails.getName());
		users.setUsername(usersDetails.getUsername());
		users.setEmail(usersDetails.getEmail());
		users.setAddress_street(usersDetails.getAddress_street());
		users.setAddress_suite(usersDetails.getAddress_suite());
		users.setAddress_city(usersDetails.getAddress_city());
		users.setAddress_zipcode(usersDetails.getAddress_zipcode());
		users.setAddress_geo_lat(usersDetails.getAddress_geo_lat());
		users.setAddress_geo_lng(usersDetails.getAddress_geo_lng());
		users.setPhone(usersDetails.getPhone());
		users.setWebsite(usersDetails.getWebsite());
		users.setCompany_name(usersDetails.getCompany_name());
		users.setCompany_catchPhrase(usersDetails.getCompany_catchPhrase());
		users.setCompany_bs(usersDetails.getCompany_bs());
		final Users updatedUsers = usersRepository.save(users);
		return ResponseEntity.ok(updatedUsers);
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Map<String, Boolean> deleteUsers(@PathVariable(value = "id") Long usersId) throws ResourceNotFoundException {
		Users users = usersRepository.findById(usersId)
				.orElseThrow(() -> new ResourceNotFoundException("Users not found : " + usersId));
		usersRepository.delete(users);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
