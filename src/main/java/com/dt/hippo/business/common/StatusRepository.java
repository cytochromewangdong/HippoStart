package com.dt.hippo.business.common;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface StatusRepository<T, ID extends Serializable> extends PagingAndSortingRepository<T, ID>
{
	List<T> findByStatus(int status);
}

