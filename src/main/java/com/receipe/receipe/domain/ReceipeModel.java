package com.receipe.receipe.domain;

import java.util.List;

public class ReceipeModel {

	private Long id ;
	private String name ;
	List<IncredientModel> incredients;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<IncredientModel> getIncredients() {
		return incredients;
	}
	public void setIncredients(List<IncredientModel> incredients) {
		this.incredients = incredients;
	}

}
