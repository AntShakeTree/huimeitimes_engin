package com.hm.engine.dao.graph.impl;

import org.springframework.stereotype.Repository;

import com.hm.engine.dao.graph.UserDiseaseDigraphDao;
import com.hm.engine.dao.graph.domain.UserDiseaseDigraph;
import com.hm.engine.dao.suport.JPADaoSuport;
@Repository
public class UserDiseaseDigraphDaoImpl extends JPADaoSuport<UserDiseaseDigraph> implements UserDiseaseDigraphDao {

}
