package org.aike.ordermanserver.utils;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.bean.BeanUtil;
import org.aike.ordermanserver.dto.LoginResponse;
import org.aike.ordermanserver.model.ShopEntity;
import org.aike.ordermanserver.model.UserEntity;

public class SaTokenUtil {

    /**
     * 构建登录响应数据
     */
    public static LoginResponse buildLoginResponse(UserEntity user, ShopEntity shop, String token, long expiresIn) {
        LoginResponse response = new LoginResponse();
        LoginResponse.UserDetail userDetail = BeanUtil.copyProperties(user, LoginResponse.UserDetail.class);
        LoginResponse.ShopInfo shopInfo = BeanUtil.copyProperties(shop, LoginResponse.ShopInfo.class);
        response.setUser(userDetail);
        response.setShop(shopInfo);
        // 设置响应
        response.setToken(token);
        response.setExpiresIn(expiresIn);
        response.setUser(userDetail);
        return response;
    }

    /**
     * 获取当前用户ID
     */
    public static Long getCurrentUserId() {
        return StpUtil.getLoginIdAsLong();
    }

    /**
     * 检查用户是否有指定角色
     */
    public static boolean hasRole(String roleCode) {
        return StpUtil.hasRole(roleCode);
    }

    /**
     * 检查用户是否有指定权限
     */
    public static boolean hasPermission(String permission) {
        return StpUtil.hasPermission(permission);
    }
}
