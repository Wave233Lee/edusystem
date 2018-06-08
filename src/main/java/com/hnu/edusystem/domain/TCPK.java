package com.hnu.edusystem.domain;

import java.io.Serializable;

/**
 * @Author: WaveLee
 * @Date: 2018/6/6 15:33
 */
public class TCPK implements Serializable {
    private String tid;
    private String cid;

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }
}
