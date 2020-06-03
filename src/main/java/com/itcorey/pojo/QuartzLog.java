package com.itcorey.pojo;

import java.io.Serializable;
import java.util.Date;

public class QuartzLog implements Serializable {
    private Long id;

    private Long quartzId;

    private Date startTime;

    private Integer time;

    private String result;

    private String remark;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuartzId() {
        return quartzId;
    }

    public void setQuartzId(Long quartzId) {
        this.quartzId = quartzId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}