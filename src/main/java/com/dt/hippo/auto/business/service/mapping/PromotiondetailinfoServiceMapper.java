/*
 * Created on 12 五月 2015 ( Time 20:53:06 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.auto.business.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import com.dt.hippo.auto.model.Promotiondetailinfo;
import com.dt.hippo.auto.model.jpa.PromotiondetailinfoEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class PromotiondetailinfoServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public PromotiondetailinfoServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'PromotiondetailinfoEntity' to 'Promotiondetailinfo'
	 * @param promotiondetailinfoEntity
	 */
	public Promotiondetailinfo mapPromotiondetailinfoEntityToPromotiondetailinfo(PromotiondetailinfoEntity promotiondetailinfoEntity) {
		if(promotiondetailinfoEntity == null) {
			return null;
		}

		//--- Generic mapping 
		Promotiondetailinfo promotiondetailinfo = map(promotiondetailinfoEntity, Promotiondetailinfo.class);

		return promotiondetailinfo;
	}
	
	/**
	 * Mapping from 'Promotiondetailinfo' to 'PromotiondetailinfoEntity'
	 * @param promotiondetailinfo
	 * @param promotiondetailinfoEntity
	 */
	public void mapPromotiondetailinfoToPromotiondetailinfoEntity(Promotiondetailinfo promotiondetailinfo, PromotiondetailinfoEntity promotiondetailinfoEntity) {
		if(promotiondetailinfo == null) {
			return;
		}

		//--- Generic mapping 
		map(promotiondetailinfo, promotiondetailinfoEntity);

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