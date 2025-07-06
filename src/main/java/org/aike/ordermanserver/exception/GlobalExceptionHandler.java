package org.aike.ordermanserver.exception;


import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.exception.NotRoleException;
import org.aike.ordermanserver.base.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Sa-Token 未登录异常
    @ExceptionHandler(NotLoginException.class)
    public Result<?> handleNotLoginException() {
        return Result.error(ErrorCode.USER_NOT_FOUND);
    }

    // Sa-Token 无角色权限
    @ExceptionHandler(NotRoleException.class)
    public Result<?> handleNotRoleException() {
        return Result.error(ErrorCode.ACCOUNT_DISABLED);
    }

    // Sa-Token 无接口权限
    @ExceptionHandler(NotPermissionException.class)
    public Result<?> handleNotPermissionException() {
        return Result.error(ErrorCode.ACCOUNT_DISABLED);
    }

    // 自定义 API 异常
    @ExceptionHandler(ApiException.class)
    public Result<?> handleApiException(ApiException e) {
        return Result.error(e.getCode(), e.getMessage());
    }

    // 兜底异常
//    @ExceptionHandler(Exception.class)
//    public Result<?> handleUnexpectedError(Exception e) {
//        // 记录日志
//        // logger.error("Unexpected error: ", e);
////        System.out.println(e.getMessage());
//        return Result.error(ErrorCode.INTERNAL_SERVER_ERROR);
//    }
}
