package org.aike.ordermanserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.aike.ordermanserver.mapper.UserMapper;
import org.aike.ordermanserver.model.UserEntity;
import org.aike.ordermanserver.model.UserRoleEntity;
import org.aike.ordermanserver.service.UserRoleService;
import org.aike.ordermanserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author 艾科
 * @since 2025-07-06
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {


    @Autowired
    private UserRoleService userRoleService;

    @Override
    public UserEntity getByPhone(String phone) {
        UserEntity user = selectByPhone(phone);
        if (user != null) {
            // 加载用户角色
            List<String> roles = userRoleService.listByUserId(user.getId())
                    .stream()
                    .map(UserRoleEntity::getRoleCode) // 假设UserRoleEntity有getRoleCode()方法
                    .collect(Collectors.toList());
            user.setRoles(roles);
        }
        return user;
    }


    private UserEntity selectByPhone(String phone) {
        return getOne(new QueryWrapper<UserEntity>().eq("phone", phone));
    }

}
