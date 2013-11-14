package com.prosper.clockgame.service.common;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

import com.prosper.clockgame.service.exception.DataExistException;
import com.prosper.clockgame.service.exception.DataNotExistException;
import com.prosper.clockgame.service.exception.OperationIsDoneException;
import com.prosper.clockgame.service.exception.OutOfLimitException;
import com.prosper.clockgame.service.exception.ServiceException;

public class OpCodeMap {
	
	public static final short SUCCESS = 0;

	public static Map<String, ErrorCode> map =  new HashMap<String, ErrorCode>();

	static {
		map.put(DataExistException.class.getName(), new ErrorCode(101, "data exist"));
		map.put(DataNotExistException.class.getName(), new ErrorCode(102, "data not exist"));
		map.put(InvalidParameterException.class.getName(), new ErrorCode(103, "invalid param"));
		map.put(OperationIsDoneException.class.getName(), new ErrorCode(104, "operation is done"));
		map.put(OutOfLimitException.class.getName(), new ErrorCode(105, "out of limit"));
		map.put(ServiceException.class.getName(), new ErrorCode(106, "servise exception"));
	}
	
	public static ErrorCode getError(String className) {
		return map.get(className);
	}
	
	public static class ErrorCode {

		private int code;
		private String description;

		public ErrorCode(int code, String desc) {
			setCode(code);
			setDescription(desc);
		}

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}
	}

}
