package fun.yunblog.radical.service;

import fun.yunblog.radical.model.domain.Category;

import java.util.List;

/**
 * @author 耿子云
 * @date 2021/9/29
 */
public interface CategoryService {

//    List<Category> queryAllCategoryComplete();
//
    List<Category> queryAllCategory();

    Category queryCategoryByCategoryId(Long categoryId);

    Category queryCategoryByCategoryName(String categoryName);

    boolean addCategory(Category category);

    boolean removeCategory(Long categoryId);

    boolean alterCategory(Category category);
}
