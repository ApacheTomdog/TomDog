package com.brcc.business.creditRepay.vo;

/**
 * @Description: 授信还款公司名选项封装类
 * @Auther: gemaochao
 * @Date:Created in 20:22 2018/11/7
 */
public class RepayCompanyVo {

    private Long seqId;

    private String companyName;

    public Long getSeqId() {
        return seqId;
    }

    public void setSeqId(Long seqId) {
        this.seqId = seqId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
