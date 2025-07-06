package org.aike.ordermanserver.service;

import org.aike.ordermanserver.model.UserRoleEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户角色关联表 服务类
 * </p>
 *
 * @author 艾科
 * @since 2025-07-06
 */
public interface UserRoleService extends IService<UserRoleEntity> {

    /**
     * 根据用户ID获取角色列表
     */
    List<UserRoleEntity> listByUserId(Long userId);

    /**
     * 为用户分配角色（替换原有角色）
     */
    boolean assignRolesToUser(Long userId, List<String> roleCodes);

    /**
     * 移除用户特定角色
     */
    boolean removeRoleFromUser(Long userId, String roleCode);

}
