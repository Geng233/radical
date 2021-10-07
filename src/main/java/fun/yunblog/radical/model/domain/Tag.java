package fun.yunblog.radical.model.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 耿子云
 * @date 2021/9/29
 */
@Data
@ApiModel("文章标签")
public class Tag {

    @ApiModelProperty("标签id")
    private Long tagId;

    @ApiModelProperty("标签名字")
    private String tagName;

    @ApiModelProperty("标签url")
    private String tagUrl;

    @ApiModelProperty("标签标记的文章")
    private List<Article> articles;
}
