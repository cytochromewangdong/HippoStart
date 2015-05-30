package com.dt.hippo.auto.data.repository.jpa;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.dt.hippo.auto.model.jpa.OrderheaderEntity;

/**
 * Repository : Orderheader.
 */
public interface OrderheaderJpaRepository extends
		PagingAndSortingRepository<OrderheaderEntity, Long>
{
	List<OrderheaderEntity> findByUserid(long userid,
			Pageable pageable);

	List<OrderheaderEntity> findByUseridAndUidLessThan(
			long userid, long uid, Pageable pageable);
	
    List<OrderheaderEntity> findByStoreidAndUserid(long storeid, long userid,
            Pageable pageable);
    
    List<OrderheaderEntity> findByStoreidAndUseridAndUidLessThan(long storeid,
            long userid, long uid, Pageable pageable);
    
	OrderheaderEntity findByOrdernoAndCorpid(String orderno, long corpid);
}
