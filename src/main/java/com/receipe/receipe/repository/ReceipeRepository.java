package com.receipe.receipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.receipe.receipe.domain.Receipe;

/**
 * Repository for Receipe table
 * 
 * @author Guru Sankar
 *
 */
@Repository
public interface ReceipeRepository extends JpaRepository<Receipe, Long> {

}
