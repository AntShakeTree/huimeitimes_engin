package com.hm.engine.dao.examniation.impl;

import org.springframework.stereotype.Repository;

import com.hm.engine.dao.examniation.DiseaseDao;
import com.hm.engine.dao.examniation.domain.Disease;
import com.hm.engine.dao.suport.JPADaoSuport;
@Repository
public class DiseaseDaoImpl extends JPADaoSuport<Disease> implements DiseaseDao {
}
