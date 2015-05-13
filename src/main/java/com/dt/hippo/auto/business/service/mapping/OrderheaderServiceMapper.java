/*
 * Created on 13 五月 2015 ( Time 21:15:27 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.auto.business.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import com.dt.hippo.auto.model.Orderheader;
import com.dt.hippo.auto.model.jpa.OrderheaderEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class OrderheaderServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public OrderheaderServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'OrderheaderEntity' to 'Orderheader'
	 * @param orderheaderEntity
	 */
	public Orderheader mapOrderheaderEntityToOrderheader(OrderheaderEntity orderheaderEntity) {
		if(orderheaderEntity == null) {
			return null;
		}

		//--- Generic mapping 
		Orderheader orderheader = map(orderheaderEntity, Orderheader.class);

		return orderheader;
	}
	
	/**
	 * Mapping from 'Orderheader' to 'OrderheaderEntity'
	 * @param orderheader
	 * @param orderheaderEntity
	 */
	public void mapOrderheaderToOrderheaderEntity(Orderheader orderheader, OrderheaderEntity orderheaderEntity) {
		if(orderheader == null) {
			return;
		}

		//--- Generic mapping 
		map(orderheader, orderheaderEntity);

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