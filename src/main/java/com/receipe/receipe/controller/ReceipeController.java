package com.receipe.receipe.controller;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.receipe.receipe.domain.Receipe;
import com.receipe.receipe.domain.ReceipeDropDownValue;
import com.receipe.receipe.domain.ReceipeModel;
import com.receipe.receipe.service.ReceipeService;

/**
 * Controller for accessing tasks 
 * @author Guru Sankar
 *
 */

@RestController
@RequestMapping("receipe")
public class ReceipeController {

	public static final Logger logger = LoggerFactory.getLogger(ReceipeController.class);

	@Autowired
	private ReceipeService receipeService;

	@GetMapping("/")
	public ResponseEntity<?> getAll() {
		List<ReceipeDropDownValue> receipes = receipeService.findAllForDropDown();
		if(!Objects.isNull(receipes))
			return new ResponseEntity<List<ReceipeDropDownValue>>(receipes, HttpStatus.OK);
		else
			return new ResponseEntity<>(null,  HttpStatus.OK);
	}
	
	@SuppressWarnings("unchecked")
	@PostMapping(value = "/save")
	public ResponseEntity<?> creatTestTask(@RequestBody Receipe receipe) {
		if(receipe.getIncredients().size()> 0 && receipe.getIncredients().size() <= 4){
			receipe = receipeService.save(receipe);
			return new ResponseEntity<Receipe>(receipe, HttpStatus.CREATED);
		}else{
			return new ResponseEntity<String>("Add Incredients between range 1 - 4 ", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") Long id) {
		Receipe receipe= receipeService.find(id);
		if(!Objects.isNull(receipe))
			return new ResponseEntity<Receipe>(receipe, HttpStatus.OK);
		else
			return new ResponseEntity<String>("Receipe is not found with Id " + id , HttpStatus.NOT_FOUND);
	}
 
}
