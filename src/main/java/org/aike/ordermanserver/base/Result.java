package org.aike.ordermanserver.base;

import lombok.Data;
import lombok.experimental.Accessors;
import org.aike.ordermanserver.exception.ErrorCode;

@Data
@Accessors(chain = true)
public class Result<T> {
    private int code;
    private String message;
    private T data;

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(0);
        result.setMessage("success");
        result.setData(data);
        return result;
    }

    public static <T> Result<T> error(int code, String message) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public static <T> Result<T> error(String message) {
        return error(500, message);
    }
    public static <T> Result<T> error(ErrorCode errorCode) {
        return error(errorCode.getCode(), errorCode.getMessage());
    }
}
