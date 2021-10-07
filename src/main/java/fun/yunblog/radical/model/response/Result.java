package fun.yunblog.radical.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author 耿子云
 * @date 2021/9/28
 * @Description 定义的统一响应对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Result<T> {

    /*
    * 状态码
    * */
    private int code;

    /*
     * 信息
     * */
    private String message;

    /*
     * 数据
     * */
    private T Data;
}
