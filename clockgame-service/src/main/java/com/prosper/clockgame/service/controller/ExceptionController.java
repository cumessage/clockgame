package com.prosper.clockgame.service.controller;

import java.security.InvalidParameterException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prosper.clockgame.service.common.OpCodeMap;
import com.prosper.clockgame.service.exception.DataExistException;
import com.prosper.clockgame.service.exception.DataNotExistException;
import com.prosper.clockgame.service.exception.OperationIsDoneException;
import com.prosper.clockgame.service.exception.OutOfLimitException;
import com.prosper.clockgame.service.exception.ServiceException;
import com.prosper.clockgame.service.view.ErrorView;
import com.prosper.clockgame.service.view.View;

@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(DataExistException.class)
	@ResponseBody
    public View handleCustomException(DataExistException ex) {
		return new ErrorView(OpCodeMap.getError(ex.getClass().getName()));
    }
	
	@ExceptionHandler(DataNotExistException.class)
	@ResponseBody
    public View handleCustomException(DataNotExistException ex) {
		return new ErrorView(OpCodeMap.getError(ex.getClass().getName()));
    }
	
	@ExceptionHandler(InvalidParameterException.class)
	@ResponseBody
    public View handleCustomException(InvalidParameterException ex) {
		return new ErrorView(OpCodeMap.getError(ex.getClass().getName()));
    }
	
	@ExceptionHandler(OperationIsDoneException.class)
	@ResponseBody
    public View handleCustomException(OperationIsDoneException ex) {
		return new ErrorView(OpCodeMap.getError(ex.getClass().getName()));
    }
	
	@ExceptionHandler(OutOfLimitException.class)
	@ResponseBody
    public View handleCustomException(OutOfLimitException ex) {
		return new ErrorView(OpCodeMap.getError(ex.getClass().getName()));
    }
	
	@ExceptionHandler(ServiceException.class)
	@ResponseBody
    public View handleCustomException(ServiceException ex) {
		return new ErrorView(OpCodeMap.getError(ex.getClass().getName()));
    }
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
    public View handleCustomException(Exception ex) {
		ex.printStackTrace();
		return new ErrorView(OpCodeMap.getError(ServiceException.class.getName()));
    }

}
