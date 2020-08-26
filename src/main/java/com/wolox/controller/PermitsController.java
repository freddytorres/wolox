package com.wolox.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.wolox.exception.ResourceNotFoundException;
import com.wolox.model.Permits;
import com.wolox.repository.PermitsRepository;

@Controller
public class PermitsController {
	@Autowired
	PermitsRepository permitsRepository;

	@RequestMapping(value = "/permits", method = RequestMethod.GET)
	@ResponseBody
	public List<Permits> getPermits() {
		return permitsRepository.findAll();
	}

	@RequestMapping(value = "/permitsUsers/{id}", method = RequestMethod.GET)
	@ResponseBody
	public List<Permits> getPermitsUser(@PathVariable(value = "id") Long permitsId) throws ResourceNotFoundException {
		return (List<Permits>) permitsRepository.findByIdUserPermits(permitsId);

	}

	@RequestMapping(value = "/permits", method = RequestMethod.POST)
	@ResponseBody
	public Permits createPermits(@Valid @RequestBody Permits permits) {
		return permitsRepository.save(permits);
	}

	@RequestMapping(value = "/permits/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Permits> updatePermits(@PathVariable(value = "id") Long permitsId,
			@Valid @RequestBody Permits permitsDetails) throws ResourceNotFoundException {
		Permits permits = permitsRepository.findById(permitsId)
				.orElseThrow(() -> new ResourceNotFoundException("Permits not found : " + permitsId));
		permits.setAlbums(permitsDetails.getAlbums());
		permits.setUsers(permitsDetails.getUsers());
		final Permits updatedPermits = permitsRepository.save(permits);
		return ResponseEntity.ok(updatedPermits);
	}

	@RequestMapping(value = "/permits/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Map<String, Boolean> deletePermits(@PathVariable(value = "id") Long permitsId)
			throws ResourceNotFoundException {
		Permits permits = permitsRepository.findById(permitsId)
				.orElseThrow(() -> new ResourceNotFoundException("Permits not found : " + permitsId));
		permitsRepository.delete(permits);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}