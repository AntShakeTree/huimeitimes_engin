package com.hm.engine.dao.graph.impl;

import org.springframework.stereotype.Repository;

import com.hm.engine.dao.graph.ExpressionDao;
import com.hm.engine.dao.graph.domain.Expression;
import com.hm.engine.dao.suport.JPADaoSuport;
@Repository
public class ExpressionDaoImpl extends JPADaoSuport<Expression> implements ExpressionDao{
}
