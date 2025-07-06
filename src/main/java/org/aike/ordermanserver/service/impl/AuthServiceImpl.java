// src/main/java/org/aike/ordermanserver/service/impl/AuthServiceImpl.java
package org.aike.ordermanserver.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import org.aike.ordermanserver.dto.LoginRequest;
import org.aike.ordermanserver.dto.LoginResponse;
import org.aike.ordermanserver.exception.ApiException;
import org.aike.ordermanserver.exception.ErrorCode;
import org.aike.ordermanserver.model.ShopEntity;
import org.aike.ordermanserver.model.UserEntity;
import org.aike.ordermanserver.service.*;
import org.aike.ordermanserver.utils.SaTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private ShopService shopService;

    // src/main/java/org/aike/ordermanserver/service/impl/AuthServiceImpl.java
    @Override
    public LoginResponse login(LoginRequest request) {
        // 1. 查询用户
        UserEntity user = userService.getByPhone(request.getPhone());

        // 2. 验证用户凭证
        if (user == null) {
            throw new ApiException(ErrorCode.USER_NOT_FOUND);
        }

        if (!user.getPassword().equals(request.getPassword())) {
            throw new ApiException(ErrorCode.INVALID_PASSWORD);
        }

        // 3. 检查用户状态
        if (!user.getIsActive()) {
            throw new ApiException(ErrorCode.ACCOUNT_DISABLED);
        }

        // 4. 获取关联店铺
        ShopEntity shop = shopService.getById(user.getShopId());

        // 5. 验证店铺有效性
        if (shop == null) {
            throw new ApiException(ErrorCode.INVALID_SHOP);
        }

        if (!shop.getIsActive()) {
            throw new ApiException(ErrorCode.SHOP_DISABLED);
        }

//        LocalDateTime now = LocalDateTime.now();
//        if (now.isBefore(shop.getAuthorizationStart().atStartOfDay()) || now.isAfter(shop.getAuthorizationEnd().atStartOfDay())) {
//            throw new ApiException(ErrorCode.OUTSIDE_AUTH_PERIOD);
//        }

        // 6. 登录用户（sa-token核心方法）
        StpUtil.login(user.getId());

        // 7. 获取token信息
        String token = StpUtil.getTokenValue();
        long expiresIn = StpUtil.getTokenTimeout();

        // 8. 构造响应数据
        return SaTokenUtil.buildLoginResponse(user, shop, token, expiresIn);
    }

}
