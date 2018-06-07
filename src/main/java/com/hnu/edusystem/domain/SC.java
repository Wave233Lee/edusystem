package com.hnu.edusystem.domain;

import javax.persistence.*;

@Entity
@IdClass(value = SCPK.class)
public class SC {
    /**
     * 学号
     */
    @Id
    @ManyToOne(targetEntity = Student.class)
    @JoinColumn(referencedColumnName = "id")
    private String sid;

    /**
     * 学生姓名
     */
    @ManyToOne(targetEntity = Student.class)
    @JoinColumn(referencedColumnName = "name")
    private String sname;

    /**
     * 课程号
     */
    @Id
    @ManyToOne(targetEntity = Course.class)
    @JoinColumn(referencedColumnName = "id")
    private String cid;

    /**
     * 课程名
     */
    @ManyToOne(targetEntity = Course.class)
    @JoinColumn(referencedColumnName = "name")
    private String cname;

    /**
     * 成绩
     */
    private Integer grade;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getTname() {
        return sname;
    }

    public void setTname(String sname) {
        this.sname = sname;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "SC{" +
                "sid='" + sid + '\'' +
                ", sname='" + sname + '\'' +
                ", cid='" + cid + '\'' +
                ", cname='" + cname + '\'' +
                ", grade=" + grade +
                '}';
    }
}
