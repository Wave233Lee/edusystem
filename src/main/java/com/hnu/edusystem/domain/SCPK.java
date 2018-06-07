package com.hnu.edusystem.domain;

import java.io.Serializable;

/**
 * @Author: WaveLee
 * @Date: 2018/6/6 15:33
 */
public class SCPK implements Serializable {
    private String sid;
    private String cid;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }
}
