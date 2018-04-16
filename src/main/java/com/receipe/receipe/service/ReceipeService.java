package com.receipe.receipe.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	
	public ReceipeModel save(ReceipeModel receipe) {
		Receipe entity = receipeMapper.destinationToSource(receipe);
		entity = receipeRepository.saveAndFlush(entity);
		return receipeMapper.sourceToDestination(entity);
	}
 

	public ReceipeModel find(Long id) {
		Optional<Receipe> receipe = receipeRepository.findById(id);
		if(receipe.isPresent())
			return receipeMapper.sourceToDestination(receipe.get());
		else
			return null;
	}
	 
	public List<ReceipeModel> findAll() {
		List<Receipe> receipes = receipeRepository.findAll();
		if(!Objects.isNull(receipes) && !CollectionUtils.isEmpty(receipes))
			return receipes.stream().map(receipeMapper::sourceToDestination).collect(Collectors.toList());
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
