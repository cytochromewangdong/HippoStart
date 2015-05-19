package com.dt.hippo.business.common;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface CommonRepository<T, ID extends Serializable> extends
		CorpRepository<T, ID>, StatusRepository<T, ID>,
		PagingAndSortingRepository<T, ID>
{
	List<T> findByCorpidAndStatus(long corpid, int status);
}
