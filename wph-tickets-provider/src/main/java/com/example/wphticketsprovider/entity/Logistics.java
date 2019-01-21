package com.example.wphticketsprovider.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Logistics)实体类
 *
 * @author makejava
 * @since 2018-12-27 14:51:13
 */
public class Logistics implements Serializable {
    private static final long serialVersionUID = 443539614871777281L;
    
    private Integer logid;
    
    private String logisticcode;   //订单编号
    
    private String shippercode;    //快递公司编号
    
    private String expno;        //没啥用

    private String traces;       //物流轨迹
    
    private String success;       //订单接收成功与否
    
    private String acceptstation;    //接收状态
    
    private Date accepttime;          //接收时间
    
    private String state;            //最终接收状态


    public Integer getLogid() {
        return logid;
    }

    public void setLogid(Integer logid) {
        this.logid = logid;
    }

    public String getLogisticcode() {
        return logisticcode;
    }

    public void setLogisticcode(String logisticcode) {
        this.logisticcode = logisticcode;
    }

    public String getShippercode() {
        return shippercode;
    }

    public void setShippercode(String shippercode) {
        this.shippercode = shippercode;
    }

    public String getExpno() {
        return expno;
    }

    public void setExpno(String expno) {
        this.expno = expno;
    }

    public String getTraces() {
        return traces;
    }

    public void setTraces(String traces) {
        this.traces = traces;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getAcceptstation() {
        return acceptstation;
    }

    public void setAcceptstation(String acceptstation) {
        this.acceptstation = acceptstation;
    }

    public Date getAccepttime() {
        return accepttime;
    }

    public void setAccepttime(Date accepttime) {
        this.accepttime = accepttime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}