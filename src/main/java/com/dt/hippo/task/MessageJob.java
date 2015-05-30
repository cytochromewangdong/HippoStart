package com.dt.hippo.task;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dt.hippo.core.base.AbstractMessageLoopQueue;
import com.dt.hippo.core.base.MessageObject;

@Component
public class MessageJob extends AbstractMessageLoopQueue
{

	@Autowired
	private TaskManagerService taskManagerService;

	@PostConstruct
	protected void init()
	{
		this.start();
	}

	@PreDestroy
	protected void destroy()
	{
		this.stop();
	}

	@Override
	protected void onElementFromQueue(MessageObject event)
	{

//		if ("emailNewUpdate".equals(event.getTargetMethod()))
//		{
//			taskManagerService.emailNewUpdate(event
//					.getParamMap());
//		}
//
//		if ("sendMail".equals(event.getTargetMethod()))
//		{
//			taskManagerService.sendMail(event.getParamMap());
//		}

		if ("pushNewUpdate".equals(event.getTargetMethod()))
		{
			taskManagerService
					.pushNewUpdate(event.getParamMap());
		}

		if ("pushNotification".equals(event.getTargetMethod()))
		{
			taskManagerService.pushNotification(event
					.getParamMap());
		}

		// Class<? extends AbstractService> targetObject = null;
		// try {
		// targetObject = (Class<? extends AbstractService>) Class
		// .forName(event.getClassName());
		// } catch (ClassNotFoundException e) {
		// e.printStackTrace();
		// }
		// if (targetObject != null) {
		// Class<Map<String, Object>> parameterTypes[] = new Class[1];
		// try {
		// parameterTypes[0] = (Class<Map<String, Object>>) Class
		// .forName("java.util.Map");
		// } catch (ClassNotFoundException e) {
		// e.printStackTrace();
		// }
		// Method method = null;
		// try {
		// method = targetObject.getMethod(event.getTargetMethod(),
		// parameterTypes);
		// } catch (SecurityException e) {
		// e.printStackTrace();
		// } catch (NoSuchMethodException e) {
		// e.printStackTrace();
		// }
		// if (method != null) {
		// try {
		// method.invoke(targetObject.newInstance(),
		// event.getParamMap());
		// } catch (IllegalArgumentException e) {
		// e.printStackTrace();
		// } catch (IllegalAccessException e) {
		// e.printStackTrace();
		// } catch (InvocationTargetException e) {
		// e.printStackTrace();
		// } catch (InstantiationException e) {
		// e.printStackTrace();
		// }
		// }
		// }
	}
}