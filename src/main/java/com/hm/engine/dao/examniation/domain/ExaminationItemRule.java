package com.hm.engine.dao.examniation.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author ant_shake_tree 一条sql穿云箭
 */
@Entity
@Table
public class ExaminationItemRule {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	/**
	 * 规则 1，2，4，8
	 */
	private int rule;
	/**
	 * 检查项子规则类型
	 */
	private String itemType;
	/**
	 * 检查项子规则的属性名称
	 */
	private String itemName;
	/**
	 * 检查项的属性值
	 */
	private Double itemValue;

	/**
	 * 检查项最大值
	 */
	public Double itemMaxValue;
	/**
	 * 几个检查项合并一起运算
	 */
	private Integer matchId; // root 1024 
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getRule() {
		return rule;
	}

	public void setRule(int rule) {
		this.rule = rule;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Double getItemValue() {
		return itemValue;
	}

	public void setItemValue(Double itemValue) {
		this.itemValue = itemValue;
	}

	public Double getItemMaxValue() {
		return itemMaxValue;
	}

	public void setItemMaxValue(Double itemMaxValue) {
		this.itemMaxValue = itemMaxValue;
	}

	public Integer getMatchId() {
		return matchId;
	}

	public void setMatchId(Integer matchId) {
		this.matchId = matchId;
	}

}
