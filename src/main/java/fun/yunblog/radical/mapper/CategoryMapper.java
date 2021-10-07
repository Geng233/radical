package fun.yunblog.radical.mapper;

import fun.yunblog.radical.model.domain.Article;
import fun.yunblog.radical.model.domain.Category;
import io.swagger.annotations.ApiModelProperty;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author 耿子云
 * @date 2021/9/29
 */
@Mapper
public interface CategoryMapper {

    @Select("select * from category")
    @Results(id = "categoryArticleMap", value = {
            @Result(id = true, column = "categoryId", property = "categoryId"),
            @Result(column = "categoryName", property = "categoryName"),
            @Result(column = "categoryUrl", property = "categoryUrl"),
            @Result(column = "categoryDescription", property = "categoryDescription"),
            @Result(column = "categoryId", property = "articles",many = @Many(select = "fun.yunblog.radical.mapper.ArticleMapper.selectArticlesByCategoryId",fetchType = FetchType.LAZY))
    })
    List<Category> selectAllCategoryComplete();

    @Select("SELECT * FROM category WHERE categoryId IN (SELECT categoryId FROM article_category WHERE articleId = #{articleId})")
    List<Category> selectCategoriesByArticleId(Long articleId);

    @Select("select * from category")
    List<Category> selectAllCategory();

    @Select("select * from category where categoryId = #{categoryId}")
    Category selectCategoryByCategoryId(Long categoryId);

    @Select("select * from category where categoryName = #{categoryName}")
    Category selectCategoryByCategoryName(String categoryName);

    @Insert("insert into category (categoryName, categoryUrl, categoryDescription) values (#{categoryName}, #{categoryUrl}, #{categoryDescription})")
    boolean insertCategory(String categoryName, String categoryUrl, String categoryDescription);

    @Delete("delete from category where categoryId = #{categoryId}")
    boolean deleteCategory(Long categoryId);

    @Update("update category set categoryName = #{categoryName}, categoryUrl = #{categoryUrl}, categoryDescription = #{categoryDescription} where categoryId = #{categoryId}")
    boolean updateCategory(String categoryName, String categoryUrl, String categoryDescription, Long categoryId);
}
