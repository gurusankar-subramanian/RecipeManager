package com.receipe.receipe.mapper;

import com.receipe.receipe.domain.Receipe;
import com.receipe.receipe.domain.ReceipeDropDownValue;
import com.receipe.receipe.domain.ReceipeModel;

public interface ReceipeMapper {

	 ReceipeModel sourceToDestination(Receipe source);
	 Receipe destinationToSource(ReceipeModel destination);
	 ReceipeDropDownValue sourceToDestinationForDropDown(Receipe source);
}
