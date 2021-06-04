package com.algaworks.algafood.api.model;

import java.util.List;

import com.algaworks.algafood.domain.model.Kitchen;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import lombok.Data;
import lombok.NonNull;

@JsonRootName("kitchens")
//@JacksonXmlRootElement(localName = "kitchens")
@Data
public class KitchenXMLWrapper {
	
	
	@JsonProperty("Kitchen")
	@NonNull
	@JacksonXmlElementWrapper(useWrapping = false)//Retira o envelopamento
	private List<Kitchen> kitchens;
}