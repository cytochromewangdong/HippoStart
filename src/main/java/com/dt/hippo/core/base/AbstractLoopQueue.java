package com.dt.hippo.core.base;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public abstract class AbstractLoopQueue<T> extends AbstractLooper {
	protected LinkedBlockingQueue<T> queue = new LinkedBlockingQueue<T>();

	public void enQueue(T event) {
		try {
			queue.put(event);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

	}

	 protected List<T> buffer = new LinkedList<T>();
	    public void deQueue()
	    {
	        int errorCount = 0;
	        buffer.clear();
	        while (true)
	        {
	            try
	            {
	                int count = queue.drainTo(buffer);
	                if(count>0)
	                {
	                    return;
	                }
	                buffer.add(queue.take());
	                return;
	            }
	            catch (InterruptedException e)
	            {
	                logger.error("===============  InterruptedException");
	                errorCount++;
	                // return null;
	                if (errorCount >= 3)
	                {
	                    throw new RuntimeException(e);
	                }
	            }
	            try
	            {
	                Thread.sleep(30);
	            }
	            catch (InterruptedException e)
	            {
	                throw new RuntimeException(e);
	            }
	        }
	    }


	protected boolean loopCondition() {
		return true;
	}

    protected boolean eachLoop()
    {
        deQueue();
        Iterator<T> iter = buffer.iterator();
        while (iter.hasNext())
        {
            T o = iter.next();
            iter.remove();
            if (o == getStopObject())
            {
                return false;
            }
            try
            {
                handleElement(o);
            }
            catch (Exception ex)
            {
                logger.error("Exception", ex);
            }
            catch (OutOfMemoryError error)
            {
                logger.error("========= out of memory happened, never bad!");
                throw error;
            }
        }
        return true;

    }
	protected boolean handleElement(T e) {
		onElementFromQueue(e);
		return true;
	}

	protected abstract void onElementFromQueue(T event);

	protected abstract T getStopObject();

	public void stop() {
		enQueue(getStopObject());
	}

}
