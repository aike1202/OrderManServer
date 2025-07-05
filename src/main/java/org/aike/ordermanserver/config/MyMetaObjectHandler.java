package org.aike.ordermanserver.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "createdAt", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "updatedAt", LocalDateTime.class, LocalDateTime.now());
        // 这里可以根据上下文获取当前用户ID
        this.strictInsertFill(metaObject, "createdBy", Long.class, getCurrentUserId());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "updatedAt", LocalDateTime.class, LocalDateTime.now());
        // 这里可以根据上下文获取当前用户ID
        this.strictUpdateFill(metaObject, "updatedBy", Long.class, getCurrentUserId());
    }

    // 模拟获取当前用户方法（需根据实际鉴权方案实现）
    private Long getCurrentUserId() {
        return 1L; // 测试值
    }
}
