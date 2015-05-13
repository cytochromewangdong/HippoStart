/*
 * Created on 13 五月 2015 ( Time 21:15:22 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.auto.business.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import com.dt.hippo.auto.model.Administrator;
import com.dt.hippo.auto.model.jpa.AdministratorEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class AdministratorServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public AdministratorServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'AdministratorEntity' to 'Administrator'
	 * @param administratorEntity
	 */
	public Administrator mapAdministratorEntityToAdministrator(AdministratorEntity administratorEntity) {
		if(administratorEntity == null) {
			return null;
		}

		//--- Generic mapping 
		Administrator administrator = map(administratorEntity, Administrator.class);

		return administrator;
	}
	
	/**
	 * Mapping from 'Administrator' to 'AdministratorEntity'
	 * @param administrator
	 * @param administratorEntity
	 */
	public void mapAdministratorToAdministratorEntity(Administrator administrator, AdministratorEntity administratorEntity) {
		if(administrator == null) {
			return;
		}

		//--- Generic mapping 
		map(administrator, administratorEntity);

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