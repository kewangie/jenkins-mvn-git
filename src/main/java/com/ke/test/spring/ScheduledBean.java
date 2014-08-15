package com.ke.test.spring;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledBean {

	private final AsyncBean asyncBean;

	@Autowired
	public ScheduledBean(AsyncBean asyncBean) {
		this.asyncBean = asyncBean;
	}

	@Scheduled(fixedDelayString = "3000")
	public void schedule() throws InterruptedException, ExecutionException {
		for (int i = 0; i < 10; i++) {
			Future<String> future = this.asyncBean.hello();
			System.out.println(future.get());
		}
	}

}
