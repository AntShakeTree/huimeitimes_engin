package com.hm.engine.dao.examniation.domain;

import javax.persistence.Id;

/**
 * 
 * @author ant_shake_tree 检查项
 */
public class ExaminationItem {
	@Id
	private Integer id;
	/**
	 * 检查单ID
	 */
	private Integer checklistId;
	 /**
	  * 检查项说明
	  */
	private String desc;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getChecklistId() {
		return checklistId;
	}
	public void setChecklistId(Integer checklistId) {
		this.checklistId = checklistId;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
//	private String check
	
	
}
