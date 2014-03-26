package com.jskj.asset.client.bean.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Churukudanyimiaoliebiaotb {
    private Integer id;

    private String churukuId;

    private Integer yimiaoId;

    private String source;

    private String tongguandanno;

    private Integer quantity;

    private String pihao;

    private Date youxiaoqi;

    private String piqianfahegeno;

    private Float price;

    private Float totalprice;

    private Integer xiangdanId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChurukuId() {
        return churukuId;
    }

    public void setChurukuId(String churukuId) {
        this.churukuId = churukuId == null ? null : churukuId.trim();
    }

    public Integer getYimiaoId() {
        return yimiaoId;
    }

    public void setYimiaoId(Integer yimiaoId) {
        this.yimiaoId = yimiaoId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getTongguandanno() {
        return tongguandanno;
    }

    public void setTongguandanno(String tongguandanno) {
        this.tongguandanno = tongguandanno == null ? null : tongguandanno.trim();
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getPihao() {
        return pihao;
    }

    public void setPihao(String pihao) {
        this.pihao = pihao == null ? null : pihao.trim();
    }

    public Date getYouxiaoqi() {
        return youxiaoqi;
    }

    public void setYouxiaoqi(Date youxiaoqi) {
        this.youxiaoqi = youxiaoqi;
    }

    public String getPiqianfahegeno() {
        return piqianfahegeno;
    }

    public void setPiqianfahegeno(String piqianfahegeno) {
        this.piqianfahegeno = piqianfahegeno == null ? null : piqianfahegeno.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Float totalprice) {
        this.totalprice = totalprice;
    }

    public Integer getXiangdanId() {
        return xiangdanId;
    }

    public void setXiangdanId(Integer xiangdanId) {
        this.xiangdanId = xiangdanId;
    }
}