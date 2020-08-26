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
import com.wolox.model.Photos;
import com.wolox.repository.PhotosRepository;

@Controller
public class PhotosController {
	@Autowired
	PhotosRepository photosRepository;

	@RequestMapping(value = "/photos", method = RequestMethod.GET)
	@ResponseBody
	public List<Photos> getPhotos() {
		return photosRepository.findAll();
	}

	@RequestMapping(value = "/photos", method = RequestMethod.POST)
	@ResponseBody
	public Photos createPhotos(@Valid @RequestBody Photos photos) {
		return photosRepository.save(photos);
	}

	@RequestMapping(value = "/photos/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Photos> updatePhotos(@PathVariable(value = "id") Long photosId,
			@Valid @RequestBody Photos photosDetails) throws ResourceNotFoundException {
		Photos photos = photosRepository.findById(photosId)
				.orElseThrow(() -> new ResourceNotFoundException("Photos not found : " + photosId));
		photos.setTitle(photosDetails.getTitle());
		photos.setUrl(photosDetails.getUrl());
		photos.setThumbnailUrl(photosDetails.getThumbnailUrl());
		photos.setAlbums(photosDetails.getAlbums());
		final Photos updatedPhotos = photosRepository.save(photos);
		return ResponseEntity.ok(updatedPhotos);
	}

	@RequestMapping(value = "/photos/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Map<String, Boolean> deletePhotos(@PathVariable(value = "id") Long photosId)
			throws ResourceNotFoundException {
		Photos photos = photosRepository.findById(photosId)
				.orElseThrow(() -> new ResourceNotFoundException("Photos not found : " + photosId));
		photosRepository.delete(photos);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}