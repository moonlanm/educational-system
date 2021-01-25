package edu.hubu.commons.controller;

import edu.hubu.commons.model.CommonResult;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author moonlan
 * date 2021/1/25 下午3:28
 */
@SuppressWarnings(value = "unused")
@RestControllerAdvice
@RestController
@RequestMapping("${server.error.path:${error.path:/error}}")
public class ErrorController extends AbstractErrorController {

    public ErrorController(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }

    @RequestMapping
    public CommonResult err(HttpServletRequest request) {
        HttpStatus httpStatus = getStatus(request);
        Map<String, Object> body = getErrorAttributes(request, false);
        return new CommonResult().setMessage(body.get("message").toString())
                .setCode(httpStatus.value()).setCurrentPage(1).setTotalPages(1);
    }

    @Override
    public String getErrorPath() {
        return null;
    }
}
