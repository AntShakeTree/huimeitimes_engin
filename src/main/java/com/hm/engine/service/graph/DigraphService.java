package com.hm.engine.service.graph;

import java.lang.reflect.InvocationTargetException;

import com.hm.engine.dao.graph.domain.GraphicProcess;


/**
 * 
 * @author ant_shake_tree
 *
 */
public interface DigraphService {
	GraphicProcess mappingDigraph(Integer diseaseId);
	GraphicProcess nextStep(String userId) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException, SecurityException;
}
