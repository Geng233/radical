package fun.yunblog.radical.mapper;

import fun.yunblog.radical.model.domain.Article;
import fun.yunblog.radical.model.domain.Category;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.Date;
import java.util.List;

/**
 * @author 耿子云
 * @date 2021/9/26
 */
@Mapper
public interface ArticleMapper {

    @Select("select * from article where userId = #{userId}")
    @Results(id = "articleTagMap", value = {
            @Result(id = true, column = "articleId", property = "articleId"),
            @Result(column = "articleTitle", property = "articleTitle"),
            @Result(column = "articleType", property = "articleType"),
            @Result(column = "articleCreateDate", property = "articleCreateDate"),
            @Result(column = "articleUrl", property = "articleUrl"),
            @Result(column = "userId", property = "userId"),
            @Result(column = "articleUpdateDate", property = "articleUpdateDate"),
            @Result(column = "articleHtmlContent", property = "articleHtmlContent"),
            @Result(column = "articleMdContent", property = "articleMdContent"),
            @Result(column = "articleId", property = "tags",many = @Many(select = "fun.yunblog.radical.mapper.TagMapper.selectTagsByArticleId",fetchType = FetchType.LAZY)),
            @Result(column = "articleId", property = "categories",many = @Many(select = "fun.yunblog.radical.mapper.CategoryMapper.selectCategoriesByArticleId",fetchType = FetchType.LAZY))
    })
    List<Article> selectAllArticleComplete(Long userId);

    @Select("select * from article where userId = #{userId} order by `articleUpdateDate` limit #{length}")
    @Results(id = "articleTagMapWithLength", value = {
            @Result(id = true, column = "articleId", property = "articleId"),
            @Result(column = "articleTitle", property = "articleTitle"),
            @Result(column = "articleType", property = "articleType"),
            @Result(column = "articleCreateDate", property = "articleCreateDate"),
            @Result(column = "articleUrl", property = "articleUrl"),
            @Result(column = "userId", property = "userId"),
            @Result(column = "articleUpdateDate", property = "articleUpdateDate"),
            @Result(column = "articleHtmlContent", property = "articleHtmlContent"),
            @Result(column = "articleMdContent", property = "articleMdContent"),
            @Result(column = "articleId", property = "tags",many = @Many(select = "fun.yunblog.radical.mapper.TagMapper.selectTagsByArticleId",fetchType = FetchType.LAZY)),
            @Result(column = "articleId", property = "categories",many = @Many(select = "fun.yunblog.radical.mapper.CategoryMapper.selectCategoriesByArticleId",fetchType = FetchType.LAZY))
    })
    List<Article> selectAllArticleCompleteWithLength(Long userId, Long length);

    @Select("SELECT * FROM article WHERE articleId IN (SELECT articleId FROM article_tag WHERE tagId = #{tagId})")
    List<Article> selectArticlesByTagId(Long tagId);


    @Select("SELECT * FROM article WHERE articleId IN (SELECT articleId FROM article_category WHERE categoryId = #{categoryId})")
    List<Article> selectArticlesByCategoryId(Long categoryId);

    @Select("select * from article where userId = #{userId}")
    List<Article> selectArticlesByUserId(Long userId);

    @Select("select `articleId`, `articleTitle`, `articleType`, `articleCreateDate`, `articleUpdateDate`, `articleUrl`, `userId`  from article where userId = #{userId}")
    List<Article> selectArticlesSimpleByUserId(Long userId);

    @Select("select `articleId`, `articleTitle`, `articleType`, `articleCreateDate`, `articleUpdateDate`, `articleUrl`, `userId`  from article where userId = #{userId} order by `articleUpdateDate` limit #{length}")
    List<Article> selectArticlesSimpleWithLengthByUserId(Long userId, Long length);

    @Select("select `articleId`, `articleTitle`, `articleType`, `articleCreateDate`, `articleUpdateDate`, `articleUrl`, `userId` from article where userId = #{userId}")
    @Results(id = "articleTagMapWithoutContent", value = {
            @Result(id = true, column = "articleId", property = "articleId"),
            @Result(column = "articleTitle", property = "articleTitle"),
            @Result(column = "articleType", property = "articleType"),
            @Result(column = "articleCreateDate", property = "articleCreateDate"),
            @Result(column = "articleUrl", property = "articleUrl"),
            @Result(column = "userId", property = "userId"),
            @Result(column = "articleUpdateDate", property = "articleUpdateDate"),
            @Result(column = "articleId", property = "tags",many = @Many(select = "fun.yunblog.radical.mapper.TagMapper.selectTagsByArticleId",fetchType = FetchType.LAZY)),
            @Result(column = "articleId", property = "categories",many = @Many(select = "fun.yunblog.radical.mapper.CategoryMapper.selectCategoriesByArticleId",fetchType = FetchType.LAZY))
    })
    List<Article> selectArticleWithoutContent(Long userId);

    @Select("select * from article where articleId = #{articleId}")
    Article selectArticlesByArticleId(Long articleId);

    @Select("select articleId from article where articleTitle = #{articleTitle}")
    Long selectArticleIdByArticleTitle(String articleTitle);

    @Insert("INSERT INTO article (`articleTitle`, `articleType`, `articleCreateDate`, `articleUpdateDate`, `articleUrl`, " +
            "`articleHtmlContent`, `articleMdContent`, `userId`) " +
            "VALUES (#{articleTitle},#{articleType},#{articleCreateDate},#{articleUpdateDate},#{articleUrl},#{articleHtmlContent},#{articleMdContent},#{userId})")
    boolean insertArticle(String articleTitle, String articleType, Date articleCreateDate, Date articleUpdateDate, String articleUrl,
                       String articleHtmlContent, String articleMdContent, Long userId);

    @Insert("insert into article_tag (`articleId`, `tagId`) values (#{articleId}, #{tagId})")
    boolean insertArticleTag(Long articleId, Long tagId);

    @Insert("insert into article_category (`articleId`, `categoryId`) values (#{articleId}, #{categoryId})")
    boolean insertArticleCategory(Long articleId, Long categoryId);

    @Delete("DELETE FROM article WHERE articleId = #{articleId}")
    boolean deleteArticle(Long articleId);

    @Delete("DELETE FROM article_tag WHERE articleId = #{articleId} and tagId = #{tagId}")
    boolean deleteArticleTag(Long articleId, Long tagId);

    @Delete("DELETE FROM article_category WHERE articleId = #{articleId} and categoryId = #{categoryId}")
    boolean deleteArticleCategory(Long articleId, Long categoryId);

    @Update("UPDATE article SET articleTitle = #{articleTitle}, articleType = #{articleType}," +
            "articleUpdateDate = #{articleUpdateDate}," +
            "articleUrl = #{articleUrl}, articleHtmlContent = #{articleHtmlContent}, articleMdContent = #{articleMdContent} " +
            "WHERE articleId = #{articleId}")
    boolean updateArticle(Long articleId,String articleTitle, String articleType, Date articleUpdateDate, String articleUrl,
                          String articleHtmlContent, String articleMdContent);

    @Update("update article set articleType = #{articleType} where articleId = #{articleId}")
    boolean updateArticleType(Long articleId, String articleType);
}
