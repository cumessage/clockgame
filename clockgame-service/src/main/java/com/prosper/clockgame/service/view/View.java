package com.prosper.clockgame.service.view;

import com.prosper.clockgame.service.common.Opcode;

public class View {
	
	private int opCode = Opcode.SUCCESS;
	
	public View() {}
	
	public View(int opCode) {
		this.setOpCode(opCode);
	}

	public int getOpCode() {
		return opCode;
	}

	public void setOpCode(int opCode) {
		this.opCode = opCode;
	}

}
