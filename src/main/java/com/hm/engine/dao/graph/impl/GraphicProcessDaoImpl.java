package com.hm.engine.dao.graph.impl;

import org.springframework.stereotype.Repository;

import com.hm.engine.dao.graph.GraphicProcessDao;
import com.hm.engine.dao.graph.domain.GraphicProcess;
import com.hm.engine.dao.suport.JPADaoSuport;
@Repository
public class GraphicProcessDaoImpl extends JPADaoSuport<GraphicProcess> implements GraphicProcessDao{

}
