// src/main/java/org/aike/ordermanserver/service/impl/UserRoleServiceImpl.java
package org.aike.ordermanserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.aike.ordermanserver.mapper.UserRoleMapper;
import org.aike.ordermanserver.model.UserRoleEntity;
import org.aike.ordermanserver.service.UserRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRoleEntity> implements UserRoleService {

    @Override
    public List<UserRoleEntity> listByUserId(Long userId) {
        return lambdaQuery().eq(UserRoleEntity::getUserId, userId).list();
    }

    @Transactional
    @Override
    public boolean assignRolesToUser(Long userId, List<String> roleCodes) {
        // 1. 先删除用户已有角色
        lambdaUpdate().eq(UserRoleEntity::getUserId, userId).remove();

        // 2. 批量保存新角色
        List<UserRoleEntity> roleList = roleCodes.stream()
                .map(roleCode -> new UserRoleEntity()
                        .setUserId(userId)
                        .setRoleCode(roleCode))
                .collect(Collectors.toList());

        return saveBatch(roleList);
    }

    @Transactional
    @Override
    public boolean removeRoleFromUser(Long userId, String roleCode) {
        return lambdaUpdate()
                .eq(UserRoleEntity::getUserId, userId)
                .eq(UserRoleEntity::getRoleCode, roleCode)
                .remove();
    }
}
