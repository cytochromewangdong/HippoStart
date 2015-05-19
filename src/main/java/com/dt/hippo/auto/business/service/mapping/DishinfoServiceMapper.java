/*
 * Created on 19 五月 2015 ( Time 13:48:43 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.auto.business.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import com.dt.hippo.auto.model.Dishinfo;
import com.dt.hippo.auto.model.jpa.DishinfoEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class DishinfoServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public DishinfoServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'DishinfoEntity' to 'Dishinfo'
	 * @param dishinfoEntity
	 */
	public Dishinfo mapDishinfoEntityToDishinfo(DishinfoEntity dishinfoEntity) {
		if(dishinfoEntity == null) {
			return null;
		}

		//--- Generic mapping 
		Dishinfo dishinfo = map(dishinfoEntity, Dishinfo.class);

		return dishinfo;
	}
	
	/**
	 * Mapping from 'Dishinfo' to 'DishinfoEntity'
	 * @param dishinfo
	 * @param dishinfoEntity
	 */
	public void mapDishinfoToDishinfoEntity(Dishinfo dishinfo, DishinfoEntity dishinfoEntity) {
		if(dishinfo == null) {
			return;
		}

		//--- Generic mapping 
		map(dishinfo, dishinfoEntity);

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