package com.prosper.clockgame.service.view;

import com.prosper.clockgame.service.common.OpCodeMap;

public class View {
	
	private int opCode = OpCodeMap.SUCCESS;
	
	public View() {}
	
	public int getOpCode() {
		return opCode;
	}

	public void setOpCode(int opCode) {
		this.opCode = opCode;
	}

}
