package com.hm.engine.dao.graph.impl;

import org.springframework.stereotype.Repository;

import com.hm.engine.dao.graph.ProcessExpressionDao;
import com.hm.engine.dao.graph.domain.ProcessExpression;
import com.hm.engine.dao.suport.JPADaoSuport;
@Repository
public class ProcessExpressionDaoImpl extends  JPADaoSuport<ProcessExpression> implements ProcessExpressionDao{
}
