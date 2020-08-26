package com.wolox.controller;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
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
}
