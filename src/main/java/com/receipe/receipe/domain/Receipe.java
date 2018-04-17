package com.receipe.receipe.domain;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Entity for receipe table
 * @author Guru Sankar
 *
 */
@Entity
@Table(name="receipe")
public class Receipe {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id ;

	@Column
	private String name ;
	  
	@OneToMany(mappedBy = "receipe", cascade = CascadeType.ALL,  fetch = FetchType.LAZY)
	List<Incredient> incredients;

	public Receipe(){
		
	}
	
	public Receipe(Long id){
		this.id = id ;
	}
	

	public Receipe(Long id, String name, List<Incredient> incredients){
		this.id = id ;
		this.name = name ;
		this.incredients = incredients ;
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

	public List<Incredient> getIncredients() {
		return incredients;
	}

	public void setIncredients(List<Incredient> incredients) {
		this.incredients = incredients;
	}
	
}
