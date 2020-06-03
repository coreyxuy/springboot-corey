package com.itcorey.jobs;

import com.itcorey.service.impl.uploadServiceImpl;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @Classname QuartzInform
 * @Description TODO
 * @Date 2020/6/3 11:12
 * @Created by corey
 */

@Component
@Lazy(value = false)
public class QuartzInform implements Job {

    private static final Logger logger = LoggerFactory.getLogger(QuartzInform.class);


    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

    }
}
