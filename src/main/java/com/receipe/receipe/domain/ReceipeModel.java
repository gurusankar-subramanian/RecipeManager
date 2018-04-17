package com.receipe.receipe.domain;

import java.util.List;

public class ReceipeModel {

	private Long id ;
	private String name ;
	List<IncredientModel> incredients;
	
	
	public ReceipeModel(){
		
	}
	
	public ReceipeModel(String name){
		this.name = name;	
	}
	
	public ReceipeModel(Long id, String name, List<IncredientModel> incredients){
		this.name = name;	
		this.incredients = incredients;
		this.id = id;
	}
	
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
