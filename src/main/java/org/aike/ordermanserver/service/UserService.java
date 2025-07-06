package org.aike.ordermanserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.aike.ordermanserver.model.UserEntity;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author 艾科
 * @since 2025-07-06
 */
public interface UserService extends IService<UserEntity> {
    UserEntity getByPhone(String phone);
}
