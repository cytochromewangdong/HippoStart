/*
 * Created on 13 五月 2015 ( Time 21:15:26 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.auto.business.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import com.dt.hippo.auto.model.Externalaccount;
import com.dt.hippo.auto.model.jpa.ExternalaccountEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class ExternalaccountServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public ExternalaccountServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'ExternalaccountEntity' to 'Externalaccount'
	 * @param externalaccountEntity
	 */
	public Externalaccount mapExternalaccountEntityToExternalaccount(ExternalaccountEntity externalaccountEntity) {
		if(externalaccountEntity == null) {
			return null;
		}

		//--- Generic mapping 
		Externalaccount externalaccount = map(externalaccountEntity, Externalaccount.class);

		return externalaccount;
	}
	
	/**
	 * Mapping from 'Externalaccount' to 'ExternalaccountEntity'
	 * @param externalaccount
	 * @param externalaccountEntity
	 */
	public void mapExternalaccountToExternalaccountEntity(Externalaccount externalaccount, ExternalaccountEntity externalaccountEntity) {
		if(externalaccount == null) {
			return;
		}

		//--- Generic mapping 
		map(externalaccount, externalaccountEntity);

	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ModelMapper getModelMapper() {
		return modelMapper;
	}

	protected void setModelMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

}