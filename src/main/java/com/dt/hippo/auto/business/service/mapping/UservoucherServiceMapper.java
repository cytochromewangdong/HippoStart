/*
 * Created on 18 五月 2015 ( Time 11:07:19 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.auto.business.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import com.dt.hippo.auto.model.Uservoucher;
import com.dt.hippo.auto.model.jpa.UservoucherEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class UservoucherServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public UservoucherServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'UservoucherEntity' to 'Uservoucher'
	 * @param uservoucherEntity
	 */
	public Uservoucher mapUservoucherEntityToUservoucher(UservoucherEntity uservoucherEntity) {
		if(uservoucherEntity == null) {
			return null;
		}

		//--- Generic mapping 
		Uservoucher uservoucher = map(uservoucherEntity, Uservoucher.class);

		return uservoucher;
	}
	
	/**
	 * Mapping from 'Uservoucher' to 'UservoucherEntity'
	 * @param uservoucher
	 * @param uservoucherEntity
	 */
	public void mapUservoucherToUservoucherEntity(Uservoucher uservoucher, UservoucherEntity uservoucherEntity) {
		if(uservoucher == null) {
			return;
		}

		//--- Generic mapping 
		map(uservoucher, uservoucherEntity);

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