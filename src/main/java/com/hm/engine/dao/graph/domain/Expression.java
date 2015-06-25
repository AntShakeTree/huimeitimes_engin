package com.hm.engine.dao.graph.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hm.engine.dao.Request;
import com.hm.engine.dao.annotation.HmDaoHelper;
import com.hm.engine.dao.annotation.HmDaoHelper.IgnoreValue;

@Table
@Entity
public class Expression implements Request<Expression> {
	@Id
	private Integer expressionId;
	private String content;
	@HmDaoHelper(ignore=IgnoreValue.ZERO)
	public Integer getExpressionId() {
		return expressionId;
	}
	public void setExpressionId(Integer expressionId) {
		this.expressionId = expressionId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}	
}
