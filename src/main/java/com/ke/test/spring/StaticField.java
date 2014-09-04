package com.ke.test.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class StaticField {

	public static boolean multiSizeDecisioningOn;

	@Value("${multi.size.decisioning.on:false}")
	public void setMultiSizeDecisioningOn(boolean multiSizeDecisioningOn) {
		StaticField.multiSizeDecisioningOn = multiSizeDecisioningOn;
	}

}
