package fun.yunblog.radical.mapper;

import fun.yunblog.radical.model.domain.Tag;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author 耿子云
 * @date 2021/9/29
 */
@Mapper
public interface TagMapper {

    @Select("select * from tag")
    @Results(id = "tagArticleMap", value = {
            @Result(id = true, column = "tagId", property = "tagId"),
            @Result(column = "tagName", property = "tagName"),
            @Result(column = "tagUrl", property = "tagUrl"),
            @Result(column = "tagId", property = "articles",many = @Many(select = "fun.yunblog.radical.mapper.ArticleMapper.selectArticlesByTagId",fetchType = FetchType.LAZY))
    })
    List<Tag> selectAllTagComplete();

    @Select("SELECT * FROM tag WHERE tagId IN (SELECT tagId FROM article_tag WHERE articleId = #{articleId})")
    List<Tag> selectTagsByArticleId(Long articleId);

    @Select("select * from tag")
    List<Tag> selectAllTag();

    @Select("select * from tag where tagId = #{tagId}")
    Tag selectTagByTagId(Long tagId);

    @Select("select * from tag where tagName = #{tagName}")
    Tag selectTagByTagName(String tagName);

    @Insert("insert into tag (tagName, tagUrl) values (#{tagName}, #{tagUrl})")
    boolean insertTag(String tagName, String tagUrl);

    @Delete("delete from tag where tagId = #{tagId}")
    boolean deleteTag(Long tagId);

    @Update("update tag set tagName = #{tagName}, tagUrl = #{tagUrl} where tagId = #{tagId}")
    boolean updateTag(String tagName, String tagUrl, Long tagId);
}
