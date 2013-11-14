package com.prosper.clockgame.service.view;

import com.prosper.clockgame.service.common.OpCodeMap.ErrorCode;

public class ErrorView extends View {

	private String desc;

	public ErrorView(ErrorCode errorCode) {
		setOpCode(errorCode.getCode());
		setDesc(errorCode.getDescription());
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
