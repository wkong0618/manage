package com.wk.manage.dao.entity;

import java.io.Serializable;

/**
 * auth_usr
 * @author 
 */
public class AuthUsr implements Serializable {
    /**
     * ï¿½Ã»ï¿½ID
     */
    private String usrId;

    /**
     * ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ID
     */
    private String orgId;

    /**
     * ï¿½Ã»ï¿½ï¿½ï¿½
     */
    private String usrName;

    /**
     * ï¿½ï¿½ï¿½ï¿½
     */
    private String usrPsw;

    /**
     * ï¿½ï¿½Êµï¿½ï¿½ï¿½ï¿½
     */
    private String usrRealName;

    /**
     * ï¿½Ã»ï¿½ï¿½ï¿½ï¿½ï¿½
     */
    private String usrDesc;

    /**
     * ï¿½Ã»ï¿½×´Ì¬ï¿½ï¿½0-ï¿½ï¿½ï¿½Ã£ï¿½1-ï¿½ï¿½ï¿½ï¿½
     */
    private String usrStatus;

    /**
     * ï¿½Ã»ï¿½ï¿½Ï´Îµï¿½Â¼ï¿½É¹ï¿½Ê±ï¿½ï¿½
     */
    private String lastLoginTime;

    /**
     * ï¿½Ã»ï¿½ï¿½ï¿½Â¼Ê§ï¿½Ü´ï¿½ï¿½ï¿½
     */
    private String failLoginTimes;

    /**
     * ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½
     */
    private String creObj;

    /**
     * ï¿½ï¿½ï¿½ï¿½Ê±ï¿½ï¿½
     */
    private String creTim;

    /**
     * ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½
     */
    private String updObj;

    /**
     * ï¿½ï¿½ï¿½ï¿½Ê±ï¿½ï¿½
     */
    private String updTim;

    private static final long serialVersionUID = 1L;

    public String getUsrId() {
        return usrId;
    }

    public void setUsrId(String usrId) {
        this.usrId = usrId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getUsrName() {
        return usrName;
    }

    public void setUsrName(String usrName) {
        this.usrName = usrName;
    }

    public String getUsrPsw() {
        return usrPsw;
    }

    public void setUsrPsw(String usrPsw) {
        this.usrPsw = usrPsw;
    }

    public String getUsrRealName() {
        return usrRealName;
    }

    public void setUsrRealName(String usrRealName) {
        this.usrRealName = usrRealName;
    }

    public String getUsrDesc() {
        return usrDesc;
    }

    public void setUsrDesc(String usrDesc) {
        this.usrDesc = usrDesc;
    }

    public String getUsrStatus() {
        return usrStatus;
    }

    public void setUsrStatus(String usrStatus) {
        this.usrStatus = usrStatus;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getFailLoginTimes() {
        return failLoginTimes;
    }

    public void setFailLoginTimes(String failLoginTimes) {
        this.failLoginTimes = failLoginTimes;
    }

    public String getCreObj() {
        return creObj;
    }

    public void setCreObj(String creObj) {
        this.creObj = creObj;
    }

    public String getCreTim() {
        return creTim;
    }

    public void setCreTim(String creTim) {
        this.creTim = creTim;
    }

    public String getUpdObj() {
        return updObj;
    }

    public void setUpdObj(String updObj) {
        this.updObj = updObj;
    }

    public String getUpdTim() {
        return updTim;
    }

    public void setUpdTim(String updTim) {
        this.updTim = updTim;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        AuthUsr other = (AuthUsr) that;
        return (this.getUsrId() == null ? other.getUsrId() == null : this.getUsrId().equals(other.getUsrId()))
            && (this.getOrgId() == null ? other.getOrgId() == null : this.getOrgId().equals(other.getOrgId()))
            && (this.getUsrName() == null ? other.getUsrName() == null : this.getUsrName().equals(other.getUsrName()))
            && (this.getUsrPsw() == null ? other.getUsrPsw() == null : this.getUsrPsw().equals(other.getUsrPsw()))
            && (this.getUsrRealName() == null ? other.getUsrRealName() == null : this.getUsrRealName().equals(other.getUsrRealName()))
            && (this.getUsrDesc() == null ? other.getUsrDesc() == null : this.getUsrDesc().equals(other.getUsrDesc()))
            && (this.getUsrStatus() == null ? other.getUsrStatus() == null : this.getUsrStatus().equals(other.getUsrStatus()))
            && (this.getLastLoginTime() == null ? other.getLastLoginTime() == null : this.getLastLoginTime().equals(other.getLastLoginTime()))
            && (this.getFailLoginTimes() == null ? other.getFailLoginTimes() == null : this.getFailLoginTimes().equals(other.getFailLoginTimes()))
            && (this.getCreObj() == null ? other.getCreObj() == null : this.getCreObj().equals(other.getCreObj()))
            && (this.getCreTim() == null ? other.getCreTim() == null : this.getCreTim().equals(other.getCreTim()))
            && (this.getUpdObj() == null ? other.getUpdObj() == null : this.getUpdObj().equals(other.getUpdObj()))
            && (this.getUpdTim() == null ? other.getUpdTim() == null : this.getUpdTim().equals(other.getUpdTim()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUsrId() == null) ? 0 : getUsrId().hashCode());
        result = prime * result + ((getOrgId() == null) ? 0 : getOrgId().hashCode());
        result = prime * result + ((getUsrName() == null) ? 0 : getUsrName().hashCode());
        result = prime * result + ((getUsrPsw() == null) ? 0 : getUsrPsw().hashCode());
        result = prime * result + ((getUsrRealName() == null) ? 0 : getUsrRealName().hashCode());
        result = prime * result + ((getUsrDesc() == null) ? 0 : getUsrDesc().hashCode());
        result = prime * result + ((getUsrStatus() == null) ? 0 : getUsrStatus().hashCode());
        result = prime * result + ((getLastLoginTime() == null) ? 0 : getLastLoginTime().hashCode());
        result = prime * result + ((getFailLoginTimes() == null) ? 0 : getFailLoginTimes().hashCode());
        result = prime * result + ((getCreObj() == null) ? 0 : getCreObj().hashCode());
        result = prime * result + ((getCreTim() == null) ? 0 : getCreTim().hashCode());
        result = prime * result + ((getUpdObj() == null) ? 0 : getUpdObj().hashCode());
        result = prime * result + ((getUpdTim() == null) ? 0 : getUpdTim().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", usrId=").append(usrId);
        sb.append(", orgId=").append(orgId);
        sb.append(", usrName=").append(usrName);
        sb.append(", usrPsw=").append(usrPsw);
        sb.append(", usrRealName=").append(usrRealName);
        sb.append(", usrDesc=").append(usrDesc);
        sb.append(", usrStatus=").append(usrStatus);
        sb.append(", lastLoginTime=").append(lastLoginTime);
        sb.append(", failLoginTimes=").append(failLoginTimes);
        sb.append(", creObj=").append(creObj);
        sb.append(", creTim=").append(creTim);
        sb.append(", updObj=").append(updObj);
        sb.append(", updTim=").append(updTim);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}