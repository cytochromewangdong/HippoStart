package com.dt.hippo.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dt.hippo.core.base.BaseActor;


@Component
public class QuartzJob extends BaseActor {


	@Autowired
	protected TaskManagerService taskManagerService;

	public void executeJudgeTask() {
	
	}

	public void refreshToken() {
		taskManagerService.refreshToken();
	}
}
