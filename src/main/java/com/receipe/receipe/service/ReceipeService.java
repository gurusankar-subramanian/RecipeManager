package com.receipe.receipe.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.receipe.receipe.domain.Incredient;
import com.receipe.receipe.domain.Receipe;
import com.receipe.receipe.domain.ReceipeDropDownValue;
import com.receipe.receipe.domain.ReceipeModel;
import com.receipe.receipe.mapper.ReceipeMapper;
import com.receipe.receipe.repository.ReceipeRepository;

/**
 * Service for Receipe entity
 * @author Guru Sankar
 *
 */
@Service
public class ReceipeService {

	@Autowired
	ReceipeRepository receipeRepository;
 
	@Autowired
	ReceipeMapper receipeMapper;
	
	public Receipe save(Receipe receipe) {
		List<Incredient> incredients = receipe.getIncredients().stream()
        		.map(x->{
					x.setReceipe(receipe);
					return x;
		}).collect(Collectors.toList());
		receipe.setIncredients(incredients);
		return receipeRepository.saveAndFlush(receipe);
	}
 
	public Receipe find(Long id) {
		Optional<Receipe> receipe = receipeRepository.findById(id);
		if(receipe.isPresent())
			return receipe.get();
		else
			return null;
	}
	
	public List<Receipe> findAll() {
		List<Receipe> receipes = receipeRepository.findAll();
		if(!Objects.isNull(receipes) && !CollectionUtils.isEmpty(receipes))
			return receipes;
		else
			return null;
	} 
	
	public List<ReceipeDropDownValue> findAllForDropDown() {
		List<Receipe> receipes = receipeRepository.findAll();
		if(!Objects.isNull(receipes) && !CollectionUtils.isEmpty(receipes))
			return receipes.stream().map(receipeMapper::sourceToDestinationForDropDown).collect(Collectors.toList());
		else
			return null;
	}
}
