package com.hm.engine.manager.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.engine.config.TestConfig;
import com.hm.engine.manager.GraphProcessContentTypeBeanManager;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
public class GraphProcessContentTypeBeanManagerImplTest {
	@Autowired GraphProcessContentTypeBeanManager graphProcessContentTypeBeanManagerImpl;

	@Test
	public void testLoadContentTypeByName() {
		System.out.println(graphProcessContentTypeBeanManagerImpl.loadContentTypeByName("indicatorDecision"));
	}

}
