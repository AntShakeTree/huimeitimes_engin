package com.hm.engine.dao.examniation.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 
 * @author ant_shake_tree 检查单编号 检查单名称 样品来源 检查类型
 */
@Entity
@Table
public class Examinationlist {
	@Id
	private Integer id;
	/**
	 * 说明
	 */
	private String name;
	/**
	 * 样本来源
	 */
	private String serum;
	

	/**
	 * 检查方式
	 */
	private String examinationType;

	@Transient
	private List<ExaminationItem> items;
	
	
	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSerum() {
		return serum;
	}

	public void setSerum(String serum) {
		this.serum = serum;
	}

	public String getExaminationType() {
		return examinationType;
	}

	public void setExaminationType(String examinationType) {
		this.examinationType = examinationType;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<ExaminationItem> getItems() {
		return items;
	}

	public void setItems(List<ExaminationItem> items) {
		this.items = items;
	}

	
}
