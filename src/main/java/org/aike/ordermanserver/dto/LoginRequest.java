package org.aike.ordermanserver.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "LoginRequest", description = "登录请求数据")
public class LoginRequest {
    @Schema(name = "phone", description = "手机号")
    private String phone;

    @Schema(name = "password", description = "密码")
    private String password;
}

