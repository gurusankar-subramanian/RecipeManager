package com.receipe.receipe.mapper;

import org.springframework.stereotype.Component;

import com.receipe.receipe.domain.Incredient;
import com.receipe.receipe.domain.IncredientModel;

@Component
public class IncredientMapperImpl implements IncredientMapper {
    @Override
    public IncredientModel sourceToDestination(Incredient source) {
        if ( source == null ) {
            return null;
        }
        IncredientModel simpleDestination = new IncredientModel();
        simpleDestination.setName(source.getName());
        simpleDestination.setId(source.getId());
        
        return simpleDestination;
    }
    @Override
    public Incredient destinationToSource(IncredientModel destination){
    	Incredient simpleSource = new Incredient();
        simpleSource.setName( destination.getName() );
        simpleSource.setId(destination.getId());
        return simpleSource;
    }
    
}
