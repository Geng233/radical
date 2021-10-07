package fun.yunblog.radical.exception;

import fun.yunblog.radical.model.response.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author 耿子云
 * @date 2021/9/28
 * @Description 全局异常处理
 */
@Slf4j
@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(value = UnauthorizedException.class)
    public Result handler(UnauthorizedException e) {
        log.error("运行时异常：----------------{}" + e.getMessage());
        return new Result().setCode(401).setMessage("您权限不够");
    }

    @ExceptionHandler(value = ExpiredCredentialsException.class)
    public Result handler(ExpiredCredentialsException e) {
        log.error("运行时异常：----------------{}", e.getMessage());
        return new Result().setCode(401).setMessage("登录已过期，请重新登录");
    }

    @ExceptionHandler(value = UnauthenticatedException.class)
    public Result handler(UnauthenticatedException e) {
        log.error("运行时异常：----------------{}", e);
        return new Result().setCode(401).setMessage("未登录");
    }

    @ExceptionHandler(value = UnknownAccountException.class)
    public Result handler(UnknownAccountException e) {
        log.error("运行时异常：----------------{}", e);
        return new Result().setCode(401).setMessage("未知账号，账号错误");
    }
}
