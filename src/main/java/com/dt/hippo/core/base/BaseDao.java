/*
 * Copyright (c) 2013 NeuLion, Inc. All Rights Reserved.
 */
package com.dt.hippo.core.base;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.rowset.SqlRowSet;


public abstract class BaseDao extends JdbcDaoSupport
{

//    protected abstract DataSource getTheDataSource();
    protected Logger logger = Logger.getLogger(this.getClass());

    protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void setNamedDataSource(DataSource dataSource)
    {

        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }
    @Autowired
	private DataSource dataSource;
    
    @PostConstruct
    void init()
    {
        setDataSource(dataSource);
        if (supportNameTemplate())
        {
            setNamedDataSource(dataSource);
        }
    }

    protected boolean supportNameTemplate()
    {
        return true;
    }

    protected static class CountInfo
    {
        long allCount = 0;
        long max_id = 0;
        long min_id = 0;

        public CountInfo()
        {
        }

        public CountInfo(long allCount, long max_id, long min_id)
        {
            this.allCount = allCount;
            this.max_id = max_id;
            this.min_id = min_id;
        }

        public long getAllCount()
        {
            return allCount;
        }

        public long getMax_id()
        {
            return max_id;
        }

        public long getMin_id()
        {
            return min_id;
        }

        public void setAllCount(long allCount)
        {
            this.allCount = allCount;
        }

        public void setMax_id(long max_id)
        {
            this.max_id = max_id;
        }

        public void setMin_id(long min_id)
        {
            this.min_id = min_id;
        }
    }

    protected static interface ExecutorBigLoop
    {
        void beforeBatch() throws Exception;

        void executePerRow(SqlRowSet rs) throws Exception;

        void afterBatch() throws Exception;
    }

    protected static abstract class AbstractExecutorPerRow implements ExecutorBigLoop
    {
        public void beforeBatch() throws Exception
        {

        }

        public void afterBatch() throws Exception
        {

        }
    }

    public void processBigLoop(String tableName, String sql, ExecutorBigLoop rowHandle)
    {
        processBigLoop(tableName, sql, rowHandle, null);
    }
    
    public void processBigLoop(String tableName, String sql, ExecutorBigLoop rowHandle,
            String counterCondition, Map<String, Object> paramMap){
        CountInfo counter = getCounterInfoWithParamMap(tableName, counterCondition, paramMap);
        if (counter.getAllCount() > 0)
        {
            try
            {
                long startID = -1;
                long endID = -1;
                int loopCount = (int) ((counter.getMax_id() - counter.getMin_id()) / limit);
                for (int k = 0; k <= loopCount; k++)
                {
                    startID = counter.getMin_id() + k * limit;
                    endID = startID + limit;
                    if (endID > counter.getMax_id() + 1)
                    {
                        endID = counter.getMax_id() + 1;
                    }
                    paramMap.put("startID", startID);
                    paramMap.put("endID", endID);
                    SqlRowSet rs = this.namedParameterJdbcTemplate.queryForRowSet(sql, paramMap);
                    rowHandle.beforeBatch();
                    while (rs.next())
                    {

                        rowHandle.executePerRow(rs);

                    }
                    rowHandle.afterBatch();
                }
            }
            catch (Exception e1)
            {
                throw new RuntimeException(e1);
            }
        }
    }

    public void processBigLoop(String tableName, String sql, ExecutorBigLoop rowHandle,
            String counterCondition)
    {
        CountInfo counter = getCounterInfo(tableName, counterCondition);
        if (counter.getAllCount() > 0)
        {
            try
            {
                long startID = -1;
                long endID = -1;

                int loopCount = (int) ((counter.getMax_id() - counter.getMin_id()) / limit);
                for (int k = 0; k <= loopCount; k++)
                {
                    startID = counter.getMin_id() + k * limit;
                    endID = startID + limit;
                    if (endID > counter.getMax_id() + 1)
                    {
                        endID = counter.getMax_id() + 1;
                    }

                    SqlRowSet rs = this.getJdbcTemplate().queryForRowSet(sql, startID, endID);
                    rowHandle.beforeBatch();
                    while (rs.next())
                    {

                        rowHandle.executePerRow(rs);

                    }
                    rowHandle.afterBatch();
                }
            }
            catch (Exception e1)
            {
                throw new RuntimeException(e1);
            }
        }
    }

    public CountInfo getCounterInfo(String tableName)
    {
        return getCounterInfo(tableName, null);
    }

    public CountInfo getCounterInfo(String tableName, String condition)
    {
        CountInfo counter = new CountInfo();
        StringBuilder sbSql = new StringBuilder(
                "select max(id) max_id, min(id) min_id, count(1) count from ").append(tableName);
        if (condition != null)
        {
            sbSql.append(condition);
        }
        Map<String, Object> maxMinParam = this.getJdbcTemplate().queryForMap(sbSql.toString());
        counter.setAllCount(((Number) maxMinParam.get("count")).intValue());
        if (counter.getAllCount() > 0)
        {
            counter.setMax_id(((Number) maxMinParam.get("max_id")).intValue());
            counter.setMin_id(((Number) maxMinParam.get("min_id")).intValue());

        }
        return counter;
    }
    
    public CountInfo getCounterInfoWithParamMap(String tableName, String condition, Map<String, Object> paramMap)
    {
        CountInfo counter = new CountInfo();
        StringBuilder sbSql = new StringBuilder(
                "select max(id) max_id, min(id) min_id, count(1) count from ").append(tableName);
        if (condition != null)
        {
            sbSql.append(condition);
        }
        Map<String, Object> maxMinParam = this.namedParameterJdbcTemplate.queryForMap(sbSql.toString() , paramMap);
        counter.setAllCount(((Number) maxMinParam.get("count")).intValue());
        if (counter.getAllCount() > 0)
        {
            counter.setMax_id(((Number) maxMinParam.get("max_id")).intValue());
            counter.setMin_id(((Number) maxMinParam.get("min_id")).intValue());

        }
        return counter;
    }

    public static final int limit = 50000;

    // public long getLastInsertID()
    // {
    // String sql = "SELECT LAST_INSERT_ID()";
    // return this.getJdbcTemplate().queryForLong(sql);
    // }
}
