package com.dt.hippo.my.repository;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.dt.hippo.auto.model.jpa.PromotioninfoEntity;
import com.dt.hippo.business.common.CommonRepository;

public interface CstPromotioninfoJpaRepository extends
		CommonRepository<PromotioninfoEntity, Long>
{
	List<PromotioninfoEntity> findPromotionForStore(
			@Param("storetype") Integer storetype,
			@Param("corpid") Long corpid,
			@Param("storeid") Long storeid);
}
