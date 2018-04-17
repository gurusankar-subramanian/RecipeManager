package com.receipe.receipe.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.receipe.receipe.domain.Incredient;
import com.receipe.receipe.domain.IncredientModel;
import com.receipe.receipe.domain.Receipe;
import com.receipe.receipe.domain.ReceipeDropDownValue;
import com.receipe.receipe.domain.ReceipeModel;

@Component
public class ReceipeMapperImpl implements ReceipeMapper {
	
	@Autowired
	IncredientMapper incredientMapper;
	
    @Override
    public ReceipeModel sourceToDestination(Receipe source) {
        if ( source == null ) {
            return null;
        }
        ReceipeModel simpleDestination = new ReceipeModel();
        simpleDestination.setName(source.getName());
        simpleDestination.setId(source.getId());
        List<IncredientModel> incredients =  source.getIncredients().stream().map(x -> incredientMapper.sourceToDestination(x)).collect(Collectors.toList());
        simpleDestination.setIncredients(incredients);
        return simpleDestination;
    }
    @Override
    public Receipe destinationToSource(ReceipeModel destination){
    	Receipe simpleSource = new Receipe();
        simpleSource.setName( destination.getName() );
        List<Incredient> incredients = destination.getIncredients().stream()
        		.map(x-> incredientMapper.destinationToSource(x))
        		.map(x->{
			x.setReceipe(simpleSource);
			return x;
		}).collect(Collectors.toList());
        simpleSource.setIncredients(incredients);
		
        return simpleSource;
    }
    
    @Override
    public ReceipeDropDownValue sourceToDestinationForDropDown(Receipe source){
    	ReceipeDropDownValue simpleDestination = new ReceipeDropDownValue();
        simpleDestination.setName(source.getName());
        simpleDestination.setId(source.getId());
        return simpleDestination;
    }
}
