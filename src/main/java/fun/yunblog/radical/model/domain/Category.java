package fun.yunblog.radical.model.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 耿子云
 * @date 2021/9/29
 */
@Data
@ApiModel("目录种类")
public class Category {

    @ApiModelProperty("目录id")
    private Long categoryId;

    @ApiModelProperty("目录名字")
    private String categoryName;

    @ApiModelProperty("目录url")
    private String categoryUrl;

    @ApiModelProperty("目录描述")
    private String categoryDescription;

    @ApiModelProperty("目录标记的文章")
    private List<Article> articles;
}
