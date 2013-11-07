package com.prosper.clockgame.service.bean;

import java.util.List;

public class Game {
	
	public static final short CAMERO = 1;
	public static final short GPS = 2;
	
	private String id;
	
	private String name;

	private String description;
	
	private List<Step> steps;
	
	public class Step {
		
		private String info;
		
		private Integer action;

		public String getInfo() {
			return info;
		}

		public void setInfo(String info) {
			this.info = info;
		}

		public Integer getAction() {
			return action;
		}

		public void setAction(Integer action) {
			this.action = action;
		}

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Step> getSteps() {
		return steps;
	}

	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}
	
}
