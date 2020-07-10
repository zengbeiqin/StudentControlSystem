package com.system.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class StuInfo implements Serializable {
    private Integer id;
    private Integer stu_id;
    private String  sname;
    private String  sid;
    private Integer sex;
    private Integer inschool;
    private String banhao;
    private String sushehao;
    private String jzphone;
    private String dyphone;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date times;
    public Date getTimes() {
        return times;
    }
    public void setTimes(Date times) {
        this.times = times;
    }

    private static final long serialVersionUID = 1L;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStu_id() {
        return stu_id;
    }
    public void setStu_id(Integer stu_id) {
        this.stu_id = stu_id;
    }

    public String getSname() { return sname; }
    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSid() { return sid; }
    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
    }

    public Integer getSex() { return sex; }
    public void setSex(Integer sex) {  this.sex = sex;  }

    public Integer getInschool() { return inschool; }
    public void setInschool(Integer inschool) {
        this.inschool = inschool;
    }

    public String getBanhao() { return banhao; }
    public void setBanhao(String banhao) {
        this.banhao = banhao == null ? null : banhao.trim();
    }

    public String getSushehao() { return sushehao; }
    public void setSushehao(String banhao) {
        this.sushehao = sushehao == null ? null : sushehao.trim();
    }

    public String getJzphone() { return jzphone; }
    public void setJzphone(String jzphone) {
        this.jzphone = jzphone == null ? null : jzphone.trim();
    }

    public String getDyphone() { return dyphone; }
    public void setDyphone(String dyphone) {
        this.dyphone = dyphone == null ? null : dyphone.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", stu_id=").append(stu_id);
        sb.append(", sname=").append(sname);
        sb.append(", sid=").append(sid);
        sb.append(", sex=").append(sex);
        sb.append(", inschool=").append(inschool);
        sb.append(", banhao=").append(banhao);
        sb.append(", sushehao=").append(sushehao);
        sb.append(", jzphone=").append(jzphone);
        sb.append(", dyphone=").append(dyphone);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}