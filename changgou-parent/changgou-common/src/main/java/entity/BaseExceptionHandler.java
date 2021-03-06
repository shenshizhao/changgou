package entity;

import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhaowuting
 * @date 2022-03-01 16:54
 */
@ControllerAdvice    //全局捕获异常类，只要作用于@RequestMapping上，所有的异常都会被捕获
public class BaseExceptionHandler {

    /**
     * 异常处理
     * @param e
     * @return new Result()
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result error(Exception e)
    {
        e.printStackTrace();
        return new Result(false, StatusCode.ERROR,e.getMessage());
    }
}
