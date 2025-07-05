package org.aike.ordermanserver.service.impl;

import org.aike.ordermanserver.model.UserTokenEntity;
import org.aike.ordermanserver.mapper.UserTokenMapper;
import org.aike.ordermanserver.service.UserTokenService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户Token表 服务实现类
 * </p>
 *
 * @author 艾科
 * @since 2025-07-06
 */
@Service
public class UserTokenServiceImpl extends ServiceImpl<UserTokenMapper, UserTokenEntity> implements UserTokenService {

}
