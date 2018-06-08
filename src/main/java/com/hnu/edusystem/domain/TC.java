package com.hnu.edusystem.domain;

import javax.persistence.*;

@Entity
@IdClass(value = TCPK.class)
public class TC {
    /**
     * 教工号
     */
    @Id
    @ManyToOne(targetEntity = Teacher.class)
    @JoinColumn(referencedColumnName = "id")
    private String tid;

    /**
     * 教师姓名
     */
    @ManyToOne(targetEntity = Teacher.class)
    @JoinColumn(referencedColumnName = "name")
    private String tname;

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

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
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

    @Override
    public String toString() {
        return "TC{" +
                "tid='" + tid + '\'' +
                ", tname='" + tname + '\'' +
                ", cid='" + cid + '\'' +
                ", cname='" + cname + '\'' +
                '}';
    }
}
