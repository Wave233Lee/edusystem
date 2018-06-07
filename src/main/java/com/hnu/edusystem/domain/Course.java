package com.hnu.edusystem.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Course {
    /**
     * 课程号
     */
    @Id
    private String id;

    /**
     * 课程名
     */
    private String name;

    /**
     * 上课时间
     */
    private Date date;

    /**
     * 课程上限人数
     */
    private Integer num;

    /**
     * 上课地点
     */
    private String location;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", num=" + num +
                ", location='" + location + '\'' +
                '}';
    }
}
