package com.chinacoal.microservice.excption;

import com.chinacoal.microservice.util.result.CodeMsg;
import com.chinacoal.microservice.util.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandlers{

	
	@ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result<String> defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
//        log.error("", e);
      
        if (e instanceof  NoHandlerFoundException) {
        	
              return Result.error(CodeMsg.NOT_FOUND);
              
        } else if(e instanceof HttpRequestMethodNotSupportedException) {
        	
        	  return Result.error(CodeMsg.METHOD_NOT_SUPPORTED);
        	  
        }else if(e instanceof IllegalArgumentException || e instanceof NumberFormatException || e instanceof MethodArgumentTypeMismatchException || e instanceof HttpMessageNotReadableException){
        	
        	return Result.error(CodeMsg.IllegalArgumentException);
        	
        }else if(e instanceof MethodArgumentNotValidException ) {
        	
        	BindingResult bindingResult = ((MethodArgumentNotValidException) e).getBindingResult();
        	
        	if(bindingResult.hasFieldErrors()) {
        		 String defaultMessage = bindingResult.getFieldError().getDefaultMessage();
        		 return Result.error(CodeMsg.BIND_ERROR.fillArgs(defaultMessage));
        	}
        	
        	return Result.error(CodeMsg.BIND_ERROR);
        	
        }else {
        	return Result.error(CodeMsg.SERVER_ERROR);
        }
         
    }
}
