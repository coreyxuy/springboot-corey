package com.itcorey.service;

import com.github.pagehelper.Page;
import com.itcorey.pojo.QuartzInfo;
import com.itcorey.pojo.QuartzInfoModel;

import java.util.List;
import java.util.Map;

/**
 * @Classname QuartzInfoService
 * @Description 定时任务接口
 * @Date 2020/6/3 11:01
 * @Created by corey
 */
public interface QuartzInfoService {

    /**
     * 保存定时任务数据
     * @param qi
     */
    boolean save(QuartzInfo qi);

    /**
     * 修改定时任务
     * @param search
     * @return
     */
    boolean update(Map<String, Object> search);

    /**
     * 查询所有任务
     * @param result
     * @return
     */
    List<QuartzInfo> list(Map<String, Object> result);

    /**
     * 定时任务分页查询
     * @param searchMap
     * @param current
     * @param pageSize
     * @return
     */
    Page<QuartzInfoModel> page(Map<String, Object> searchMap, int current,
                               int pageSize);

    /**
     * 据任务标识查询任务
     * @param code
     * @return
     */
    QuartzInfo findByCode(String code);

    /**
     * 据条件查询定时任务详情
     * @param paramMap
     * @return
     */
    QuartzInfo findSelective(Map<String, Object> paramMap);

}
