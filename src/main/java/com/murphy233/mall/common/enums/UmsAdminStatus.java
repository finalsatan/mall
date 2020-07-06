package com.murphy233.mall.common.enums;

/**
 * UmsAdminStatus
 * 管理员用户状态
 *
 * @author zhangyh2360@dimpt.com
 * @date 2020/7/6 10:17 上午
 */
public enum UmsAdminStatus {
    /**
     * 禁用状态
     */
    BANNED(0, "禁用"),
    /**
     * 启用状态
     */
    UN_BANNED(1, "启用");

    private Integer code;
    private String message;

    UmsAdminStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}