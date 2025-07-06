package org.aike.ordermanserver.model;

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
 * 角色表
 * </p>
 *
 * @author 艾科
 * @since 2025-07-06
 */
@Getter
@Setter
@ToString
@TableName("role")
@Accessors(chain = true)
@Schema(name = "RoleEntity对象", description = "角色表")
public class RoleEntity extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;


    @Schema(name = "角色编码")
    private String roleCode;

    /**
     * 角色名称
     */
    @Schema(name = "角色名称")
    private String name;

    /**
     * 角色描述
     */
    @Schema(name = "角色描述")
    private String description;
}
