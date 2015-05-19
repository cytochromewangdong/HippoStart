package com.dt.hippo.business.common.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.dt.hippo.core.base.BaseDao;

@Component
@Transactional
public class SequenceDao extends BaseDao
{
	private static final String SQL_UPDATE_SEQUENCE = "update sequence set no = LAST_INSERT_ID(no + ?) where keyword = ?";
	
	private static final String SQL_INSERT_SEQUENCE = "insert into sequence(keyword, no) values(?,?)";
	
	private static final String SQL_LAST_INSERT_ID = "SELECT LAST_INSERT_ID()";
	
	
	
	public long getNextSequence(String name, int range)
	{
		int rowCount = this.getJdbcTemplate().update(SQL_UPDATE_SEQUENCE,range, name);
		if(rowCount <= 0)
		{
			try
			{

				this.getJdbcTemplate().update(
						SQL_INSERT_SEQUENCE, name, 1);
			} catch (org.springframework.dao.DuplicateKeyException e)
			{
				
			}
			this.getJdbcTemplate().update(SQL_UPDATE_SEQUENCE, range, name);
		}
		return this.getJdbcTemplate().queryForObject(SQL_LAST_INSERT_ID, Long.class);

	}
}
