/*
 * Created on 18 五月 2015 ( Time 11:07:15 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.auto.business.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import com.dt.hippo.auto.model.Promotiondetailinfo;
import com.dt.hippo.auto.model.jpa.PromotiondetailinfoEntity;
import com.dt.hippo.auto.model.jpa.DishspecificationinfoEntity;

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

		//--- Link mapping ( link to Dishspecificationinfo )
		if(promotiondetailinfoEntity.getDishspecificationinfo() != null) {
			promotiondetailinfo.setSpecificationid(promotiondetailinfoEntity.getDishspecificationinfo().getUid());
		}
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

		//--- Link mapping ( link : promotiondetailinfo )
		if( hasLinkToDishspecificationinfo(promotiondetailinfo) ) {
			DishspecificationinfoEntity dishspecificationinfo1 = new DishspecificationinfoEntity();
			dishspecificationinfo1.setUid( promotiondetailinfo.getSpecificationid() );
			promotiondetailinfoEntity.setDishspecificationinfo( dishspecificationinfo1 );
		} else {
			promotiondetailinfoEntity.setDishspecificationinfo( null );
		}

	}
	
	/**
	 * Verify that Dishspecificationinfo id is valid.
	 * @param Dishspecificationinfo Dishspecificationinfo
	 * @return boolean
	 */
	private boolean hasLinkToDishspecificationinfo(Promotiondetailinfo promotiondetailinfo) {
		if(promotiondetailinfo.getSpecificationid() != null) {
			return true;
		}
		return false;
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