package com.dt.hippo.core.base;

public abstract class AbstractMessageLoopQueue extends
		AbstractLoopQueue<MessageObject> {

	protected final static MessageObject CLOSE_OBJECT = new MessageObject();

	@Override
	protected MessageObject getStopObject() {
		return CLOSE_OBJECT;
	}
}
