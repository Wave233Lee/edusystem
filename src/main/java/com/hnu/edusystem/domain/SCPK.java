package com.hnu.edusystem.domain;

import java.io.Serializable;

/**
 * @Author: WaveLee
 * @Date: 2018/6/6 15:33
 */
public class SCPK implements Serializable {
    private static final long serialVersionUID = 1L;

    private String sid;
    private String cid;

    public SCPK(){}

    public SCPK(String sid ,String cid){
        this.sid = sid;
        this.cid = cid;
    }

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

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + ((sid == null) ? 0 : sid.hashCode());
        result = PRIME * result + ((cid == null) ? 0 : cid.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }

        final SCPK other = (SCPK)obj;
        if(sid == null){
            if(other.sid != null){
                return false;
            }
        }else if(!sid.equals(other.sid)){
            return false;
        }
        if(cid == null){
            if(other.cid != null){
                return false;
            }
        }else if(!cid.equals(other.cid)){
            return false;
        }

        return true;
    }
}
