package org.aike.ordermanserver.exception;

// src/main/java/org/aike/ordermanserver/exception/ErrorCode.java
public enum ErrorCode {
    // 认证相关 4000-4999
    USER_NOT_FOUND(4000, "用户不存在"),
    INVALID_PASSWORD(4001, "密码错误"),
    ACCOUNT_DISABLED(4002, "账号已禁用"),
    INVALID_SHOP(4003, "无效店铺"),
    SHOP_DISABLED(4004, "店铺已禁用"),
    OUTSIDE_AUTH_PERIOD(4005, "账号未在授权期"),
    SHOP_AUTH_INVALID(4006, "店铺授权配置无效"),
    USER_NO_SHOP(4007, "用户无关联店铺"),

    // 系统通用 5000-5999
    INTERNAL_SERVER_ERROR(5000, "内部服务器错误"),
    PARAMETER_VALIDATION_FAILED(5001, "参数验证失败");

    private final int code;
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

