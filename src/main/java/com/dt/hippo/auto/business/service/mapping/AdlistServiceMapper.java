/*
 * Created on 30 五月 2015 ( Time 18:22:34 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.auto.business.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import com.dt.hippo.auto.model.Adlist;
import com.dt.hippo.auto.model.jpa.AdlistEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class AdlistServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public AdlistServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'AdlistEntity' to 'Adlist'
	 * @param adlistEntity
	 */
	public Adlist mapAdlistEntityToAdlist(AdlistEntity adlistEntity) {
		if(adlistEntity == null) {
			return null;
		}

		//--- Generic mapping 
		Adlist adlist = map(adlistEntity, Adlist.class);

		return adlist;
	}
	
	/**
	 * Mapping from 'Adlist' to 'AdlistEntity'
	 * @param adlist
	 * @param adlistEntity
	 */
	public void mapAdlistToAdlistEntity(Adlist adlist, AdlistEntity adlistEntity) {
		if(adlist == null) {
			return;
		}

		//--- Generic mapping 
		map(adlist, adlistEntity);

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