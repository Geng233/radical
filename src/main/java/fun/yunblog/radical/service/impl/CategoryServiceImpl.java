package fun.yunblog.radical.service.impl;

import fun.yunblog.radical.mapper.CategoryMapper;
import fun.yunblog.radical.model.domain.Category;
import fun.yunblog.radical.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 耿子云
 * @date 2021/9/29
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> queryAllCategory() {
        return categoryMapper.selectAllCategory();
    }

    @Override
    public Category queryCategoryByCategoryId(Long categoryId) {
        return categoryMapper.selectCategoryByCategoryId(categoryId);
    }

    @Override
    public Category queryCategoryByCategoryName(String categoryName) {
        return categoryMapper.selectCategoryByCategoryName(categoryName);
    }

    @Override
    public boolean addCategory(Category category) {
        return categoryMapper.insertCategory(category.getCategoryName(), category.getCategoryUrl(), category.getCategoryDescription());
    }

    @Override
    public boolean removeCategory(Long categoryId) {
        return categoryMapper.deleteCategory(categoryId);
    }

    @Override
    public boolean alterCategory(Category category) {
        return categoryMapper.updateCategory(category.getCategoryName(), category.getCategoryUrl(), category.getCategoryDescription(), category.getCategoryId());
    }
}
