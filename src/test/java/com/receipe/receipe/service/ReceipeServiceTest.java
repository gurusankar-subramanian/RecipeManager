package com.receipe.receipe.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.receipe.receipe.domain.Incredient;
import com.receipe.receipe.domain.IncredientModel;
import com.receipe.receipe.domain.Receipe;
import com.receipe.receipe.domain.ReceipeModel;
import com.receipe.receipe.mapper.ReceipeMapperImpl;
import com.receipe.receipe.repository.ReceipeRepository;

@RunWith(MockitoJUnitRunner.class)
@DataJpaTest
public class ReceipeServiceTest {

	@Autowired
    private TestEntityManager entityManager;
	
    @Autowired
    private ReceipeRepository receipeRepository;

    @MockBean
    private ReceipeMapperImpl receipeMapper;
     
    /*
    @Test
	public void testSave() {

        Incredient inc1 = new Incredient("test1Inc");
    	Incredient inc2 = new Incredient("test2Inc");
        List<Incredient> incredients = new ArrayList<>();
        incredients.add(inc1);
        incredients.add(inc2);
        Receipe mockReceipe = new Receipe(1L, "name",  incredients); 

        
        IncredientModel incModel1 = new IncredientModel("test1Inc");
        IncredientModel incModel2 = new IncredientModel("test2Inc");
        List<IncredientModel> incredientModelss = new ArrayList<>();
        incredientModelss.add(incModel1);
        incredientModelss.add(incModel2);
    	ReceipeModel mockReceipeModel = new ReceipeModel(1L, "test1", incredientModelss);
        
        
    	Mockito.when(receipeMapper.destinationToSource(Mockito.any(ReceipeModel.class))).thenReturn(mockReceipe);
    	Mockito.when(receipeMapper.sourceToDestination(Mockito.any(Receipe.class))).thenReturn(mockReceipeModel);
    	
    	
		Receipe entity = receipeMapper.destinationToSource(mockReceipeModel);
		entity = receipeRepository.saveAndFlush(entity);
		System.out.println(receipeMapper.sourceToDestination(entity));
	}*/
 
}
