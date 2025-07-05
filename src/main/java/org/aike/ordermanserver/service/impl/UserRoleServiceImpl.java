package org.aike.ordermanserver.service.impl;

import org.aike.ordermanserver.model.UserRoleEntity;
import org.aike.ordermanserver.mapper.UserRoleMapper;
import org.aike.ordermanserver.service.UserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色关联表 服务实现类
 * </p>
 *
 * @author 艾科
 * @since 2025-07-06
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRoleEntity> implements UserRoleService {

}
