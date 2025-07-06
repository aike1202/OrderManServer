package org.aike.ordermanserver.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Schema(name ="登录响应数据")
public class LoginResponse {
    @Schema(name = "访问令牌")
    private String token;

    @Schema(name = "过期时间（秒）")
    private Long expiresIn;

    @Schema(name = "用户信息")
    private UserDetail user;

    @Schema(name = "所属店铺")
    private ShopInfo shop;

    @Getter
    @Setter
    @Schema(name ="用户详情")
    public static class UserDetail {
        @Schema(name = "用户ID")
        private Long id;

        @Schema(name = "姓名")
        private String name;

        @Schema(name = "手机号")
        private String phone;

        @Schema(name = "角色列表")
        private List<String> roles;



        @Schema(name = "语言设置")
        private String language;
    }

    @Getter
    @Setter
    @Schema(name ="店铺信息")
    public static class ShopInfo {
        @Schema(name = "店铺ID")
        private Long id;

        @Schema(name = "店铺名称")
        private String name;

        @Schema(name = "授权开始日期")
        private LocalDateTime authorizationStart;

        @Schema(name = "授权结束日期")
        private LocalDateTime authorizationEnd;
    }
}

