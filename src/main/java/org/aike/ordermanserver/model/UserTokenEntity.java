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
import java.time.LocalDateTime;

/**
 * <p>
 * 用户Token表
 * </p>
 *
 * @author 艾科
 * @since 2025-07-06
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
@TableName("user_token")
@Schema(name = "UserTokenEntity对象", description = "用户Token表")
public class UserTokenEntity extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @Schema(name = "用户ID")
    private Long userId;

    /**
     * Token值
     */
    @Schema(name = "Token值")
    private String token;

    /**
     * 过期时间
     */
    @Schema(name = "过期时间")
    private LocalDateTime expiresAt;

    /**
     * 设备信息
     */
    @Schema(name = "设备信息")
    private String deviceInfo;
}
