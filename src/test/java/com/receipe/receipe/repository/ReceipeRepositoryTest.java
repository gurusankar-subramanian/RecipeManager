package com.receipe.receipe.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.receipe.receipe.domain.Receipe;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ReceipeRepositoryTest {

	@Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private ReceipeRepository receipeRepository;
    
    
    @Test
    public void save_thenReturnReceipe() {/*
        // given
    	Receipe test1 = new Receipe();
    	test1.setName("test1");
        entityManager.persist(test1);
        entityManager.flush();
     
        // when
        Receipe found = receipeRepository.findById(test1.getId());
     
        // then
        assertThat(found.getName())
          .isEqualTo(alex.getName());
    */}
}
