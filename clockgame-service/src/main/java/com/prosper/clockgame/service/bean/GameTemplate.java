package com.prosper.clockgame.service.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameTemplate {
	
	public static final short CAMERO = 1;
	public static final short GPS = 2;
	public static final short DEFAULT_LIMIT = 20;
	
	private static Map<Integer, GameTemplate> gameTemplateMap = new HashMap<Integer, GameTemplate>();
	
	static {
		GameTemplate gameTemplate = new GameTemplate();
		gameTemplate.setId(1);
		gameTemplate.setName("Running Game");
		gameTemplate.setDescription("Running Game for us");
		gameTemplate.setLimit((short)20);
		
		List<Step> stepList = new ArrayList<Step>();
		stepList.add(new Step("run", 1, "100"));
		stepList.add(new Step("answer", 2, "a"));
		stepList.add(new Step("run", 1, "100"));
		
		gameTemplate.setSteps(stepList);
		gameTemplateMap.put(1, gameTemplate);
	}
	
	private int id;
	
	private String name;

	private String description;
	
	private List<Step> steps;
	
	private short limit = DEFAULT_LIMIT;
	
	public static Map<Integer, GameTemplate> getMap() {
		return gameTemplateMap;
	}
	
	public GameTemplate() {}
	
	public GameTemplate(int id) {
		setId(id);
	}
	
	public GameTemplate(int id, String name, String description) {
		setId(id);
		setName(name);
		setDescription(description);
	}
	
	public static class Step {
		
		private String info;
		
		private Integer action;
		
		private String value;
		
		public Step(String info, Integer action, String value) {
			this.info = info;
			this.action = action;
			this.value = value;
		}

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

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public short getLimit() {
		return limit;
	}

	public void setLimit(short limit) {
		this.limit = limit;
	}
	
}
