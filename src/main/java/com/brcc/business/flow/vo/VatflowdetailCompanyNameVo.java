package com.brcc.business.flow.vo;

import com.esteel.common.vo.BaseQueryVo;

/**
 * @Description:
 * @Auther: gemaochao
 * @Date:Created in 15:05 2018/11/14
 */
public class VatflowdetailCompanyNameVo extends BaseQueryVo {

    private Long seqId;
    private Long vatClientId;

    private String vatClientName;

    private Long vatCarryId;

    private String vatCarryName;

    public Long getSeqId() {
        return seqId;
    }

    public void setSeqId(Long seqId) {
        this.seqId = seqId;
    }

    public Long getVatClientId() {
        return vatClientId;
    }

    public void setVatClientId(Long vatClientId) {
        this.vatClientId = vatClientId;
    }

    public String getVatClientName() {
        return vatClientName;
    }

    public void setVatClientName(String vatClientName) {
        this.vatClientName = vatClientName;
    }

    public Long getVatCarryId() {
        return vatCarryId;
    }

    public void setVatCarryId(Long vatCarryId) {
        this.vatCarryId = vatCarryId;
    }

    public String getVatCarryName() {
        return vatCarryName;
    }

    public void setVatCarryName(String vatCarryName) {
        this.vatCarryName = vatCarryName;
    }
}
