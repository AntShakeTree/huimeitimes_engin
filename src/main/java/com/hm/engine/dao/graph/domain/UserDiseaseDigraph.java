package com.hm.engine.dao.graph.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hm.engine.dao.Request;
import com.hm.engine.dao.annotation.HmDaoHelper;
import com.hm.engine.dao.annotation.HmDaoHelper.IgnoreValue;

@Entity
@Table
public class UserDiseaseDigraph implements Request<UserDiseaseDigraph> {
	private String diseaseCode;
	private String userGuid;

	private long currenttime;
	private Integer currentProcessGraphId;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	public String getUserGuid() {
		return userGuid;
	}

	public void setUserGuid(String userGuid) {
		this.userGuid = userGuid;
	}

	public String getDiseaseCode() {
		return diseaseCode;
	}

	public void setDiseaseCode(String diseaseCode) {
		this.diseaseCode = diseaseCode;
	}

	public Integer getCurrentProcessGraphId() {
		return currentProcessGraphId;
	}

	public void setCurrentProcessGraphId(Integer currentProcessGraphId) {
		this.currentProcessGraphId = currentProcessGraphId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@HmDaoHelper(ignore = IgnoreValue.ZERO)
	public long getCurrenttime() {
		return currenttime;
	}

	public void setCurrenttime(long currenttime) {
		this.currenttime = currenttime;
	}

	public static class Bulider {
		public Bulider diseaseCode(String diseaseCode) {
			this.userDiseaseDigraph.setDiseaseCode(diseaseCode);
			return this;
		}

		public Bulider userGuid(String userGuid) {
			this.userDiseaseDigraph.setUserGuid(userGuid);
			return this;
		}

		public Bulider currenttime() {
			this.userDiseaseDigraph.setCurrenttime(System.currentTimeMillis());
			return this;
		}

		public Bulider currentProcessGraphId(Integer currentProcessGraphId) {
			this.userDiseaseDigraph
					.setCurrentProcessGraphId(currentProcessGraphId);
			return this;
		}

		final UserDiseaseDigraph userDiseaseDigraph;

		public UserDiseaseDigraph create() {
			return this.userDiseaseDigraph;
		}

		public Bulider() {
			this.userDiseaseDigraph = new UserDiseaseDigraph();
		}
	}
}
