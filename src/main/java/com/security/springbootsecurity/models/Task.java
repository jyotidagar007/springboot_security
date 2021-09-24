package com.security.springbootsecurity.models;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
;

import javax.persistence.*;

import java.util.List;

@Setter(AccessLevel.PUBLIC)
@Getter(AccessLevel.PUBLIC)
@Entity
@Table(name = "task")
public class Task extends Auditable<String>{
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    public String id;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String desc;

    private boolean isComplete = false;

    private boolean flag = false;

    private String priority;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(nullable = false)
    private User user;

    private String tag;

//    @ManyToMany(mappedBy = "tasks", cascade = CascadeType.ALL)
//    List<Tag> tags= new ArrayList<Tag>();


    public Task() {
    }

    public Task(String id, String title, String desc, User user, List<Tag> tags, String priority) {
        super();
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.user = user;
        this.tag = tag;
        this.priority = priority;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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


//    public List<Tag> getTags() {
//        return tags;
//    }
//    public void setTags(List<Tag> tags) {
//        this.tags = tags;
//    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Task{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + desc + '\'' +
                '}';
    }


}
