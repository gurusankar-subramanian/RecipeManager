package com.receipe.receipe.domain;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Entity for incredient table
 * @author Guru Sankar
 *
 */
@Entity
@Table(name="incredient")
public class Incredient {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id ;

	@Column
	private String name ;
	 
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "receipe_id")
	private Receipe receipe;
	
	public Incredient (){
		
	}

	public Incredient (String name){
		this.name = name;
	}
	
	public Incredient(Receipe receipe, String name){
		this.name = name;
		this.receipe = receipe;
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
	public Receipe getReceipe() {
		return receipe;
	}

	public void setReceipe(Receipe receipe) {
		this.receipe = receipe;
	}

}
