package com.hm.engine.dao.graph.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class ProcessExpression {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long processExceptionId;
	private Integer graphId;
	
	private Integer expressionId;
	
	private String diseaseCode;

	public Integer getGraphId() {
		return graphId;
	}

	public void setGraphId(Integer graphId) {
		this.graphId = graphId;
	}

	public Integer getExpressionId() {
		return expressionId;
	}

	public void setExpressionId(Integer expressionId) {
		this.expressionId = expressionId;
	}

	public String getDiseaseCode() {
		return diseaseCode;
	}

	public void setDiseaseCode(String diseaseCode) {
		this.diseaseCode = diseaseCode;
	}

	public Long getProcessExceptionId() {
		return processExceptionId;
	}

	public void setProcessExceptionId(Long processExceptionId) {
		this.processExceptionId = processExceptionId;
	}

	
	
}
