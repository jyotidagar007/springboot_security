package com.security.springbootsecurity.dto;

import java.util.Date;
import java.util.List;

public class TaskDto {

    private String id;

    public Date createdDate;

    private String title;

    private String desc;

    private String tag;

//    List<String> tagIds= new ArrayList<String>();

    private String priority;



    public TaskDto() {
    }

    public TaskDto(String id, String title, String desc, String tag, String priority, Date createdDate) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.tag = tag;
     //   this.tagIds = tagIds;
        this.priority = priority;
        this.createdDate = createdDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


//    public List<String> getTagIds() {
//        return tagIds;
//    }
//
//    public void setTagIds(List<String> tagIds) {
//        this.tagIds = tagIds;
//    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}


