package com.hm.engine.service.graph.impl;

import java.lang.reflect.InvocationTargetException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.hm.engine.dao.examniation.DiseaseDao;
import com.hm.engine.dao.examniation.domain.Disease;
import com.hm.engine.dao.graph.UserDiseaseDigraphDao;
import com.hm.engine.dao.graph.domain.GraphicProcess;
import com.hm.engine.dao.graph.domain.UserDiseaseDigraph;
import com.hm.engine.dao.suport.QueryUtil;
import com.hm.engine.service.graph.DigraphService;

@Component("digraphService")
public class DigraphServiceImpl implements DigraphService {
	@Autowired
	DiseaseDao diseaseDao;
	@Autowired
	UserDiseaseDigraphDao userDiseaseDigraphDao;
	

	@Override
	public GraphicProcess mappingDigraph(Integer diseaseId) {
		Assert.notNull(diseaseId);
		Disease.currentDisease(diseaseDao.find(diseaseId));
		return null;
	}

	@Override
	public GraphicProcess nextStep(String userGuid) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException, SecurityException {

//		QueryUtil queryUtil = QueryUtil
//				.getHqlByDomain(new UserDiseaseDigraph.Bulider()
//						.userGuid(userGuid)
//						.diseaseCode(
//								Disease.getCurrentDisease().getDiseaseCode())
//						.create());
		//TODO:多条路径
//		UserDiseaseDigraph userDiseaseDigraph = userDiseaseDigraphDao.findOne(
//				queryUtil.getHql(), queryUtil.getValues());
//		long currenttime = userDiseaseDigraph.getCurrenttime();

		System.out.println("===================");
		return null;
	}
	
	
//	public static void main(String[] args) {
//		ApplicationContext context = new AnnotationConfigApplicationContext(HmEngineConfig.class);
//		Test test =(Test) context.getBean("xiaoma");
//		System.out.println(test.getName());
//	}
}
