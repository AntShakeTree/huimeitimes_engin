package com.hm.engine.dao.examniation.domain;

import java.util.concurrent.ConcurrentHashMap;

import javax.persistence.Id;

/**
 * 
 * @author ant_shake_tree
 *  疾病库
 */
public class Disease {
	protected static String CURRENT_DIS="current_disease";
	@Id
	/**
	 * 疾病编码
	 */
	private String diseaseCode;
	/**
	 * 疾病名称
	 */
	private String diseaseName;
	/**
	 * 上一级别的编码
	 */
	private String parentCode;
	/**
	 * 疾病所属类型。是消化系统，内科 （保留字段）
	 */
	private String diseaseType;
	/**
	 *  疾病等级
	 */
	private String diseaseLevel;
	
	
	 
	public String getDiseaseCode() {
		return diseaseCode;
	}
	public void setDiseaseCode(String diseaseCode) {
		this.diseaseCode = diseaseCode;
	}
	public String getDiseaseName() {
		return diseaseName;
	}
	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}
	public String getParentCode() {
		return parentCode;
	}
	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}
	public String getDiseaseType() {
		return diseaseType;
	}
	public void setDiseaseType(String diseaseType) {
		this.diseaseType = diseaseType;
	}
	public String getDiseaseLevel() {
		return diseaseLevel;
	}
	public void setDiseaseLevel(String diseaseLevel) {
		this.diseaseLevel = diseaseLevel;
	}
	
	
	private static ConcurrentHashMap<String,Disease> concurrentHashMap=new ConcurrentHashMap<String, Disease>(1);
	
	public static Disease getCurrentDisease(){
		return concurrentHashMap.get("CURRENT_DIS");
	}
	public static void currentDisease(Disease disease){
		concurrentHashMap.put(CURRENT_DIS, disease);
	}
	
}
