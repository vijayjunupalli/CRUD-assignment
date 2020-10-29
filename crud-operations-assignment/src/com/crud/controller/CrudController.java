package com.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.exception.TechStackNotFoundException;
import com.crud.model.TechPanelDetails;
import com.crud.service.CrudService;

@RestController
@RequestMapping("/stack")
public class CrudController {

	@Autowired
	private CrudService service;

	// -------------------Retrieve All Tech Details-------------------------------------
	@GetMapping("/alltechstack")
	public ResponseEntity<List<TechPanelDetails>> list() throws TechStackNotFoundException {
		List<TechPanelDetails> details = service.list();
		if (!details.isEmpty()) {
			return new ResponseEntity<List<TechPanelDetails>>(details, HttpStatus.OK);
		}
		return new ResponseEntity<List<TechPanelDetails>>(HttpStatus.NO_CONTENT);
	}

	// -------------------Update Details-------------------------------------

	@PutMapping("/crud/{id}")
	public ResponseEntity<?> update(@ModelAttribute TechPanelDetails techPanelDetails, @PathVariable long id)
			throws TechStackNotFoundException {
		Optional<TechPanelDetails> optionalProject = Optional.ofNullable(service.getTechPanelById(id));
		if (optionalProject.isPresent()) {
			service.update(id, techPanelDetails);
			return ResponseEntity.ok().body(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	// -------------------Save Details-------------------------------------

	@PostMapping("/crud")
	public ResponseEntity<?> save(@ModelAttribute TechPanelDetails techPanel) {
		long id = service.save(techPanel);
		return ResponseEntity.ok().body(HttpStatus.CREATED);
	}

	// -------------------Delete Details-------------------------------------

	@DeleteMapping("/crud/{id}")
	public ResponseEntity<?> delete(@PathVariable long id) {
		Optional<TechPanelDetails> optionalProject = Optional.ofNullable(service.getTechPanelById(id));
		if (optionalProject.isPresent()) {
			service.delete(id);
			return ResponseEntity.ok().body(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

}
