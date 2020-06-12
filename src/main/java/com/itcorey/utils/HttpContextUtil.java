package com.itcorey.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @Classname HttpContextUtil
 * @Description TODO
 * @Date 2020/6/12 15:10
 * @Created by corey
 */
public class HttpContextUtil {

    private HttpContextUtil(){

    }

    public static HttpServletRequest getHttpServletRequest() {
        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
    }
}
