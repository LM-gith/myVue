package com.lm.enume;

/**
 * @author luoming
 * @date 2019/12/09
 */
public enum EnumTest {

    /**
     * 数据权限，当前大队
     */
    SJQX_DQDD("jdkf.sjqx.dqdd", "数据权限，当前大队"),

    /**
     * 数据权限，部门权限
     */
    SJQX_SYDD("jdkf.sjqx.sydd", "数据权限，所有大队"),

    /**
     * 业务标识 大队干警
     */
    JDKF_DDGJ("jdkf.ywjs.ddgj", "业务标识 大队干警"),
    /**
     * 业务标识 大队领导
     */
    JDKF_DDLD("jdkf.ywjs.ddld", "业务标识 大队领导"),
    /**
     * 业务标识 科室干警
     */
    JDKF_KSGJ("jdkf.ywjs.ksgj", "业务标识 科室干警"),
    /**
     * 业务标识 科室领导
     */
    JDKF_KSLD("jdkf.ywjs.ksld", "业务标识 科室领导"),
    /**
     * 业务标识所领导
     */
    JDKF_SLD("jdkf.ywjs.sld", "业务标识 所领导"),
    /**
     * 业务标识 省局领导
     */
    JDKF_SJLD("jdkf.ywjs.sjld", "业务标识 省局领导");

    private String code;

    private String comment;

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    EnumTest(String code, String comment) {
        this.code = code;
        this.comment = comment;
    }

}
