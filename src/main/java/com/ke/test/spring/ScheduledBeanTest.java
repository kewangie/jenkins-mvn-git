package com.ke.test.spring;

import nonautoscan.com.ke.test.ComponentScanConfig;
import nonautoscan.com.ke.test.PropertyConfig;
import nonautoscan.com.ke.test.ScheduleAndAsyncConfig;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class ScheduledBeanTest {

	public static void main(String[] args) {

		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.setAllowCircularReferences(false);
		rootContext.register(ComponentScanConfig.class, ScheduleAndAsyncConfig.class, PropertyConfig.class);
		rootContext.refresh();

		System.out.println(StaticField.multiSizeDecisioningOn);

		rootContext.close();

	}

}
