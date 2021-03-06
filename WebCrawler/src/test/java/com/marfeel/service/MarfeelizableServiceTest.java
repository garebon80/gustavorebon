package com.marfeel.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring-servlet.xml" })
public class MarfeelizableServiceTest {

	@Autowired
	MarfeelizableService marfeelizableService;
	
	@Test
	public void testCheckSite(){
		Assert.isTrue(marfeelizableService.checkSite("http://clarin.com"));
	}
	
}
