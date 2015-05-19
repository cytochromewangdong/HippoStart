package com.dt.hippo.business.common.impl;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import com.dt.hippo.business.common.SequenceService;

@Component("businessSequenceService")
//@Scope( proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SequenceServiceImpl implements SequenceService
{

	private static final int SEQUENCE_PER = 10000;

	@Autowired
	private SequenceDao sequenceDao;

	private AtomicLong top = new AtomicLong();

	private AtomicLong current = new AtomicLong();

	private final int randombitCount = 8;
	
	private final int randomCeiling = 1<<8;
	
	private final Random r = new Random();
	
	@PostConstruct
	public void init()
	{
		fetchSequnceNumberFromDB();
	}

	@Override
	public long getSeqence()
	{
		while (true)
		{
			long sequence = current.get() + 1;
			if (sequence < top.get())
			{
				if (current
						.compareAndSet(sequence - 1, sequence))
				{
					long val = sequence<<randombitCount|(r.nextInt(randomCeiling));
					return val;
				}
			} else
			{
				long topV = top.get();
				synchronized (this)
				{
					if (top.get() == topV)
					{
						fetchSequnceNumberFromDB();
					}
				}
			}
		}
	}

	private void fetchSequnceNumberFromDB()
	{
		long topSeq = sequenceDao.getNextSequence("all",
				SEQUENCE_PER);
		top.set(topSeq);
		current.set(topSeq - SEQUENCE_PER);
	}

	private static final String SQL_UPDATE_SEQUENCE = "update sequence set no = LAST_INSERT_ID(no + ?) where keyword = ?";

	private static final String SQL_INSERT_SEQUENCE = "insert into sequence(keyword, no) values(?,?)";

	private static final String SQL_LAST_INSERT_ID = "SELECT LAST_INSERT_ID()";

}
