package com.itcorey.aop;

import com.alibaba.fastjson.JSON;

import com.itcorey.passw.MyLog;
import com.itcorey.pojo.ClSysLog;
import com.itcorey.service.ClSysLogService;
import com.itcorey.utils.HttpContextUtil;
import com.itcorey.utils.IpUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Classname SysLogAspect
 * @Description 日志切面
 * @Date 2020/6/12 14:45
 * @Created by corey
 */
@Aspect
@Component
public class SysLogAspect {
    private static final Logger logger = LoggerFactory.getLogger(SpringAop.class);

    @Autowired
    private ClSysLogService sysLogService;

    //定义切点 @Pointcut
    //在注解的位置切入代码
    @Pointcut("@annotation( com.itcorey.passw.MyLog)")
    public void logPoinCut() {
    }

    //切面 配置通知
    @AfterReturning("logPoinCut()")
    public void saveSysLog(JoinPoint joinPoint) {
        logger.info("-----------切面---------------");
        //保存日志
        ClSysLog sysLog = new ClSysLog();

        //从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取切入点所在的方法
        Method method = signature.getMethod();

        //获取操作
        MyLog myLog = method.getAnnotation(MyLog.class);
        if (myLog != null) {
            String value = myLog.value();
            sysLog.setOperation(value);//保存获取的操作
        }

        //获取请求的类名
        String className = joinPoint.getTarget().getClass().getName();
        //获取请求的方法名
        String methodName = method.getName();
        sysLog.setMethod(className + "." + methodName);
        //请求的参数
        Object[] args = joinPoint.getArgs();
        //将参数所在的数组转换成json
        String params = Arrays.toString(args);
        String sp = "),";
        String[] split = params.split("sp",1);
        sysLog.setParams(JSON.toJSONString(split));
        //获取用户名
      //  sysLog.setUsername(ShiroUtils.getUserEntity().getUsername());
        //获取用户ip地址
        HttpServletRequest request = HttpContextUtil.getHttpServletRequest();
        sysLog.setIp(IpUtil.getRemortIP(request));

        //调用service保存SysLog实体类到数据库
        sysLogService.saveLog(sysLog);
    }



}
