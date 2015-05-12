/*
 * Created on 12 五月 2015 ( Time 20:53:06 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.auto.business.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import com.dt.hippo.auto.model.Promotioninfo;
import com.dt.hippo.auto.model.jpa.PromotioninfoEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class PromotioninfoServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public PromotioninfoServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'PromotioninfoEntity' to 'Promotioninfo'
	 * @param promotioninfoEntity
	 */
	public Promotioninfo mapPromotioninfoEntityToPromotioninfo(PromotioninfoEntity promotioninfoEntity) {
		if(promotioninfoEntity == null) {
			return null;
		}

		//--- Generic mapping 
		Promotioninfo promotioninfo = map(promotioninfoEntity, Promotioninfo.class);

		return promotioninfo;
	}
	
	/**
	 * Mapping from 'Promotioninfo' to 'PromotioninfoEntity'
	 * @param promotioninfo
	 * @param promotioninfoEntity
	 */
	public void mapPromotioninfoToPromotioninfoEntity(Promotioninfo promotioninfo, PromotioninfoEntity promotioninfoEntity) {
		if(promotioninfo == null) {
			return;
		}

		//--- Generic mapping 
		map(promotioninfo, promotioninfoEntity);

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