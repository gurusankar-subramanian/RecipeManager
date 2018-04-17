package com.receipe.receipe.mapper;

import com.receipe.receipe.domain.Incredient;
import com.receipe.receipe.domain.IncredientModel;

public interface IncredientMapper {

	IncredientModel sourceToDestination(Incredient source);
	Incredient destinationToSource(IncredientModel destination);

}
