package com.dt.hippo.auto.data.repository.jpa;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.dt.hippo.auto.model.jpa.TargetlistEntity;

/**
 * Repository : Targetlist.
 */
public interface TargetlistJpaRepository extends PagingAndSortingRepository<TargetlistEntity, Long> {
//	targetId	BIGINT
//	type	INT
//	corpId	BIGINT
//	targetValue	BIGINT
	TargetlistEntity findByTargetidAndTypeAndCorpidAndTargetvalue(long targetid, int type, long corpid, long targetvalue);
	
	TargetlistEntity findByTargetidAndTypeAndCorpidAndTargetvalueIn(long targetid, int type, long corpid, List<Long> targetvalueList);
}
