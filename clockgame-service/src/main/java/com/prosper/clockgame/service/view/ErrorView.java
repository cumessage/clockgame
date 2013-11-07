package com.prosper.clockgame.service.view;

public class ErrorView extends View {

	private String desc;

	public ErrorView(int opCode, String desc) {
		super(opCode);
		this.setDesc(desc);
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
