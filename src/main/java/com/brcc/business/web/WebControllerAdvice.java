package com.brcc.business.web;

import com.esteel.common.controller.WebReturnMessage;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: zhangxiuzhi
 * Date: 2018-10-28
 * Time: 14:30
 */
@ControllerAdvice
public class WebControllerAdvice {

    Logger logger = LoggerFactory.getLogger(WebControllerAdvice.class);

    /**
     * 增加对远端调用服务的翻译处理
     *
     * @param request
     * @param ex
     * @return
     */
    @ExceptionHandler(FeignException.class)
    public ResponseEntity<?> FeignExceptionHandler(HttpServletRequest request, Throwable ex) {
        FeignException fe = (FeignException) ex;

        String errMsg = fe.getMessage();

        logger.info(errMsg);

        return new ResponseEntity<>(new WebReturnMessage(false, errMsg.split("content:\n")[1]), HttpStatus.valueOf(fe.status()));

    }

    /**
     * 统一处理绑定数据产生的错误
     * @param request
     * @param ex
     * @return
     */
    @ExceptionHandler(BindException.class)
    public ResponseEntity<?> BindExceptionHandler(HttpServletRequest request, BindException ex){

        BindingResult bindingResult = ex.getBindingResult();


        return new ResponseEntity<>(new WebReturnMessage(false, bindingResult.getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
//    @ResponseBody
    public ResponseEntity<?> exceptionHandler(HttpServletRequest request, Throwable ex) {

        logger.info(ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);

    }

}
