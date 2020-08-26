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
import com.wolox.model.Albums;
import com.wolox.repository.AlbumsRepository;

@Controller
public class AlbumsController {
	@Autowired
	AlbumsRepository albumsRepository;

	@RequestMapping(value = "/albums", method = RequestMethod.GET)
	@ResponseBody
	public List<Albums> getAlbums() {
		return albumsRepository.findAll();
	}
	@RequestMapping(value = "/albums", method = RequestMethod.POST)
	@ResponseBody
	public Albums createAlbums(@Valid @RequestBody Albums albums) {
		return albumsRepository.save(albums);
	}
	
	@RequestMapping(value = "/albums/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Albums> updateDevelopers(@PathVariable(value = "id") Long albumsId,
			@Valid @RequestBody Albums albumsDetails) throws ResourceNotFoundException {
		Albums albums = albumsRepository.findById(albumsId)
				.orElseThrow(() -> new ResourceNotFoundException("Albums not found : " + albumsId));
		albums.setTitle(albumsDetails.getTitle());
		final Albums updatedAlbums = albumsRepository.save(albums);
		return ResponseEntity.ok(updatedAlbums);
	}
	
	@RequestMapping(value = "/albums/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Map<String, Boolean> deleteAlbums(@PathVariable(value = "id") Long albumsId)
			throws ResourceNotFoundException {
		Albums albums = albumsRepository.findById(albumsId)
				.orElseThrow(() -> new ResourceNotFoundException("Albums not found : " + albumsId));
		albumsRepository.delete(albums);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}