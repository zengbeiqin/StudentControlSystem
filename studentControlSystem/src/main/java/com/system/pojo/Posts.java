package com.system.pojo;

import java.io.Serializable;

//邮寄
public class Posts implements Serializable {
    private Integer id;
    private Integer studentId;
    private String goods;
    private String address;
    private String oddNumber;
    private Integer dispose;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getGoods() {
        return goods;
    }
    public void setGoods(String goods) {
        this.goods = goods == null ? null : goods.trim();
    }

//    public String getGongyu() {
//        return gongyu;
//    }
//    public void setGongyu(String gongyu) {
//        this.gongyu = gongyu == null ? null : gongyu.trim();
//    }
//
//    public String getSushe() {
//        return sushe;
//    }
//    public void setSushe(String sushe) {
//        this.sushe = sushe == null ? null : sushe.trim();
//    }
//
//    public String getChuangwei() {
//        return chuangwei;
//    }
//    public void setChuangwei(String chuangwei) {
//        this.chuangwei = chuangwei == null ? null : chuangwei.trim();
//    }
//
//    public String getWeizhi() {
//        return weizhi;
//    }
//    public void setWeizhi(String weizhi) {
//        this.weizhi = weizhi == null ? null : weizhi.trim();
//    }


    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address == null ? null : address.trim(); }

//    public String getName() { return name; }
//    public void setName(String name) { this.name = name == null ? null : name.trim(); }
//
//    public String getPhone() { return phone; }
//    public void setPhone(String phone) { this.phone = phone == null ? null : phone.trim(); }


    public String getOddNumber() {
        return oddNumber;
    }
    public void setOddNumber(String oddNumber) {
        this.oddNumber = oddNumber == null ? null : oddNumber.trim();
    }

    public Integer getDispose() {
        return dispose;
    }
    public void setDispose(Integer dispose) {
        this.dispose = dispose;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", studentId=").append(studentId);
        sb.append(", goods=").append(goods);
        sb.append(", address=").append(address);
        sb.append(", oddNumber=").append(oddNumber);
        sb.append(", dispose=").append(dispose);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}