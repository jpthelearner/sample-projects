package com.jp.app_name.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class MySpringService {
	private static final Logger logger = Logger.getLogger(MySpringService.class);
	
	public void createSomething() {
		logger.debug("Method Entry: createSomething");
		
		logger.debug("Method Exit: createSomething");
	}

}
