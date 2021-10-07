package fun.yunblog.radical.model.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author 耿子云
 * @date 2021/9/26
 * @Description: 文章实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("文章实体")
public class Article {

    @ApiModelProperty("文章id")
    private Long articleId;

    @ApiModelProperty("文章标题")
    private String articleTitle;

    @ApiModelProperty("文章类型 ok -- 展示 ban -- 禁止 draft -- 草稿 recycleBin -- 回收站")
    private String articleType;

    @ApiModelProperty("文章创建日期")
    private Date articleCreateDate;

    @ApiModelProperty("文章更新日期")
    private Date articleUpdateDate;

    @ApiModelProperty("文章路径")
    private String articleUrl;

    @ApiModelProperty("文章html内容")
    private String articleHtmlContent;

    @ApiModelProperty("文章md内容")
    private String articleMdContent;

    @ApiModelProperty("文章作者")
    private Long userId;

    @ApiModelProperty("文章标记的标签")
    private List<Tag> tags;

    @ApiModelProperty("文章标记的目录")
    private List<Category> categories;
}
