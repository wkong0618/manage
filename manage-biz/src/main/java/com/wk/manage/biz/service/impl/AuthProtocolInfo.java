package com.wk.manage.biz.service.impl;

import lombok.Data;

/**
 package com.ppdai.inst.manager.extservice.response.paycore;

 /**
 * @author wukong
 * @Description 协议签约详细信息
 * @create 2019-05-17 16:19
 */
@Data
public class AuthProtocolInfo {
    /**
     * 签约订单号
     */
    private String authOrderNo;
    /**
     * 银行标识
     */
    private String bankCode;
    /**
     * 签约绑卡时间
     */
    private String bindCardTime;
    /**
     * 持卡人证件号
     */
    private String cardHolderID;
    /**
     * 持卡人证件类型(1:身份证，2:护照，3：签证，4：居住证，5：户口本)
     */
    private String cardHolderIDType;
    /**
     * 持卡人姓名
     */
    private String cardHolderName;
    /**
     * 银行卡号
     */
    private String cardNo;
    /**
     * 卡类型（0：借记卡，1：贷记卡，2其他）
     */
    private String cardType;
    /**
     * 渠道code
     */
    private String channelCode;
    /**
     * 渠道名称
     */
    private String channelName;
    /**
     * 渠道签约协议号
     */
    private String channelPayToken;
    /**
     * 银行预留手机号
     */
    private String phoneNo;

}

