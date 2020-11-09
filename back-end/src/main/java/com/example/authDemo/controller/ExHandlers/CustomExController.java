package com.example.authDemo.controller.ExHandlers;

import com.example.authDemo.model.ResultMap;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.AuthenticationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class CustomExController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private final ResultMap resultMap;

    @Autowired
    public CustomExController(ResultMap resultMap) {
        this.resultMap = resultMap;
    }

    // 捕捉shiro的异常
    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(value=HttpStatus.UNAUTHORIZED,
                    reason = "authentication failed")
    public void authHandler(Throwable ex) {
        logger.info("Global ExHandler:"+ex.getMessage());
    }

    // 捕捉其他所有异常
    @ExceptionHandler(Exception.class)
    public ResultMap defaultExHandler(HttpServletRequest request, Throwable ex) {
        return resultMap.fail()
                .code(getStatus(request).value())
                .message("error","访问出错，无法访问: " + ex.getMessage());
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }
}
