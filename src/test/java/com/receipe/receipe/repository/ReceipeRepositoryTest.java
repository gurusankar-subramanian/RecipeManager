package com.receipe.receipe.repository;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.receipe.receipe.domain.Incredient;
import com.receipe.receipe.domain.Receipe;
import com.receipe.receipe.domain.ReceipeModel;
import com.receipe.receipe.mapper.ReceipeMapper;
import com.receipe.receipe.mapper.ReceipeMapperImpl;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ReceipeRepositoryTest {

	@Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private ReceipeRepository receipeRepository;

    @Test
    public void save_thenReturnReceipe() {
        // given
    	Receipe receipe = new Receipe();
    	receipe.setName("test1");
    	
    	List<Incredient> incredients = new ArrayList<>();
    	incredients.add(new Incredient(receipe, "test1Inc"));
    	incredients.add(new Incredient(receipe, "test2Inc"));
    	incredients.add(new Incredient(receipe, "test3Inc"));
    	
    	receipe.setIncredients(incredients);
    	
        entityManager.persist(receipe);
        entityManager.flush();
        
    }
     
    @Test
    public void testFindById() {
    	save_thenReturnReceipe();
    	Optional<Receipe> client = receipeRepository.findById(1L);
        assertEquals("test1", client.get().getName());
    }
    

    @Test
    public void testFindAll() {
    	save_thenReturnReceipe();
    	save_thenReturnReceipe();
    	save_thenReturnReceipe();
    	List<Receipe> receipes = receipeRepository.findAll();
    	System.out.println(receipes.stream().map(x->x.getId()).collect(Collectors.toList()));
    }
}
