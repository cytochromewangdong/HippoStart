package com.dt.hippo.core.base;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractLooper extends BaseActor implements Runnable {

	public static class LooperHelper {
		public static void stopAll() {
			synchronized (runningList) {
				for (AbstractLooper worker : runningList) {
					worker.stop();
				}
			}
		}
	}

	private static List<AbstractLooper> runningList = new ArrayList<AbstractLooper>();

	protected Thread thread = new Thread(this);

	public void start() {
		if (!thread.isAlive()) {
			thread.start();
			registerForAutoClose();
		}
	}

	public boolean isAlive() {
		return thread.isAlive();
	}

	protected void registerForAutoClose() {
		synchronized (runningList) {
			runningList.add(this);
		}
	}

	protected void unregister() {
		synchronized (runningList) {
			runningList.remove(this);
		}
	}

	public abstract void stop();

	protected void onExit() {
		unregister();
	}

	protected void beforeLoop() {

	}

	@Override
	public void run() {
		beforeLoop();
		this.defaultLoop();
	}

	protected abstract boolean loopCondition();

	protected abstract boolean eachLoop();

	protected void defaultLoop() {

		while (loopCondition()) {
			if (!eachLoop()) {
				break;
			}
		}

		onExit();
	}
}
