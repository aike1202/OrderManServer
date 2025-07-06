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
import java.time.LocalDate;

/**
 * <p>
 * 店铺表
 * </p>
 *
 * @author 艾科
 * @since 2025-07-06
 */
@Getter
@Setter
@ToString
@TableName("shop")
@Accessors(chain = true)
@Schema(name = "ShopEntity对象", description = "店铺表")
public class ShopEntity extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 店铺名称
     */
    @Schema(name = "店铺名称")
    private String name;

    /**
     * 店铺地址
     */
    @Schema(name = "店铺地址")
    private String address;

    /**
     * 店铺头像URL
     */
    @Schema(name = "店铺头像URL")
    private String logoUrl;

    /**
     * 联系电话
     */
    @Schema(name = "联系电话")
    private String contactPhone;

    /**
     * 授权开始日期
     */
    @Schema(name = "授权开始日期")
    private LocalDate authorizationStart;

    /**
     * 授权结束日期
     */
    @Schema(name = "授权结束日期")
    private LocalDate authorizationEnd;

    /**
     * 店铺是否启用
     */
    @Schema(name = "店铺是否启用")
    private Boolean isActive;
}
