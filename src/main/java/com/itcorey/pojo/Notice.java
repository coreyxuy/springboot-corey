package com.itcorey.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Notice {
    private Integer id;

    private String title;

    private Integer type;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createtime;

    private Integer creater;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getCreater() {
        return creater;
    }

    public void setCreater(Integer creater) {
        this.creater = creater;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    @Override
    public String toString() {
        return "Notice{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", type=" + type +
                ", createtime=" + createtime +
                ", creater=" + creater +
                ", content='" + content + '\'' +
                '}';
    }
}