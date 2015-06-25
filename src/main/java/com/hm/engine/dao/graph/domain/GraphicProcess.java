package com.hm.engine.dao.graph.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class GraphicProcess {
	@Id
	private Integer linedId;
	private Integer head;
	private Integer tail;
	private Integer expressionId;
	private String diseaseCode;
	private String processContent;
	public Integer getLinedId() {
		return linedId;
	}

	public void setLinedId(Integer linedId) {
		this.linedId = linedId;
	}

	public Integer getHead() {
		return head;
	}

	public void setHead(Integer head) {
		this.head = head;
	}

	public Integer getTail() {
		return tail;
	}

	public void setTail(Integer tail) {
		this.tail = tail;
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

	

	@Override
	public String toString() {
		return "GraphicProcess [linedId=" + linedId + ", head=" + head
				+ ", tail=" + tail + ", expressionId=" + expressionId
				+ ", diseaseCode=" + diseaseCode + ", processContent="
				+ processContent + "]";
	}



	public static class ProcessContent {
		private String type;
		private String id;
		private String level;

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getLevel() {
			return level;
		}

		public void setLevel(String level) {
			this.level = level;
		}

	}

	public String getProcessContent() {
		return processContent;
	}

	public void setProcessContent(String processContent) {
		this.processContent = processContent;
	}

}
