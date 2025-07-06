package org.aike.ordermanserver.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.aike.ordermanserver.entity.BaseEntity;

import java.io.Serial;
import java.util.List;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author 艾科
 * @since 2025-07-06
 */
@Getter
@Setter
@ToString
@TableName("user")
@Accessors(chain = true)
@Schema(name = "UserEntity对象", description = "用户表")
public class UserEntity extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 手机号
     */
    @Schema(name = "phone", description = "手机号")
    private String phone;

    /**
     * 加密密码
     */
    @Schema(name = "加密密码")
    private String password;

    /**
     * 用户姓名
     */
    @Schema(name = "用户姓名")
    private String name;

    /**
     * 默认语言
     */
    @Schema(name = "默认语言")
    private String language;

    /**
     * 账号是否启用
     */
    @Schema(name = "账号是否启用")
    private Boolean isActive;

    /**
     * 关联店铺ID（可为空）
     */
    @Schema(name = "关联店铺ID（可为空）")
    private Long shopId;

    @TableField(exist = false)
    private List<String> roles;
}
