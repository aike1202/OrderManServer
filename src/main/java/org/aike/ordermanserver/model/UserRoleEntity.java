package org.aike.ordermanserver.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.aike.ordermanserver.entity.BaseEntity;

import java.io.Serial;
import java.io.Serializable;

/**
 * <p>
 * 用户角色关联表
 * </p>
 *
 * @author 艾科
 * @since 2025-07-06
 */
@Getter
@Setter
@ToString
@TableName("user_role")
@Accessors(chain = true)
@Schema(name = "UserRoleEntity对象", description = "用户角色关联表")
public class UserRoleEntity extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @Schema(name = "用户ID")
    private Long userId;

    /**
     * 角色ID
     */
    @Schema(name = "角色ID")
    private Long roleId;

    /**
     * 角色编码（用于sa-token权限管理）
     */
    @Schema(name = "角色编码")
    private String roleCode;
}
