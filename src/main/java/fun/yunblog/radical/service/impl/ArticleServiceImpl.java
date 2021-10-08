package fun.yunblog.radical.service.impl;

import com.alibaba.fastjson.JSON;
import fun.yunblog.radical.mapper.UserMapper;
import fun.yunblog.radical.model.domain.Article;
import fun.yunblog.radical.model.domain.Category;
import fun.yunblog.radical.model.domain.Tag;
import fun.yunblog.radical.model.domain.User;
import fun.yunblog.radical.model.response.Result;
import fun.yunblog.radical.service.ArticleService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fun.yunblog.radical.mapper.ArticleMapper;

import java.util.Date;
import java.util.List;

/**
 * @author 耿子云
 * @date 2021/9/26
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Article> queryArticlesComplete(String userName, Long length) {
        Long userId = userMapper.selectUserIdByUserName(userName);
        if (length != null) {
            return articleMapper.selectAllArticleCompleteWithLength(userId, length);
        } else {
            return articleMapper.selectAllArticleComplete(userId);
        }
    }

    @Override
    public List<Article> queryArticlesSimple(String userName, Long length) {
        Long userId = userMapper.selectUserIdByUserName(userName);
        if (length != null) {
            return articleMapper.selectArticlesSimpleWithLengthByUserId(userId, length);
        } else {
            return articleMapper.selectArticlesSimpleByUserId(userId);
        }
    }

    @Override
    public List<Article> queryArticleWithoutContent(String userName, Long length) {
        Long userId = userMapper.selectUserIdByUserName(userName);
        if (length != null) {
            return articleMapper.selectArticleWithoutContentLimitLength(userId, length);
        } else {
            return articleMapper.selectArticleWithoutContent(userId);
        }
    }

    @Override
    public List<Article> queryArticlesByCategoryId(Long categoryId) {
        return articleMapper.selectArticlesByCategoryId(categoryId);
    }

    @Override
    public List<Article> queryArticlesByTagId(Long tagId) {
        return articleMapper.selectArticlesByTagId(tagId);
    }

    @Override
    public List<Article> queryArticlesByUserId(Long userId) {
        return articleMapper.selectArticlesByUserId(userId);
    }

    @Override
    public List<Article> queryArticlesByUserName(String userName) {
        Long userId = userMapper.selectUserIdByUserName(userName);
        return articleMapper.selectArticlesByUserId(userId);
    }

    @Override
    public Article queryArticleByArticleId(Long articleId) {
        return articleMapper.selectArticlesByArticleId(articleId);
    }

    @Override
    public Long queryArticleIdByArticleName(String articleTitle) {
        return articleMapper.selectArticleIdByArticleTitle(articleTitle);
    }

    @Override
    public boolean addArticle(Article article) {
        boolean res = articleMapper.insertArticle(article.getArticleTitle(), article.getArticleType(), article.getArticleCreateDate(), article.getArticleUpdateDate(),
                article.getArticleUrl(), article.getArticleHtmlContent(), article.getArticleMdContent(), article.getUserId());
        if (res) {
            Long articleId = this.queryArticleIdByArticleName(article.getArticleTitle());
            if (article.getTags().size() != 0) {
                for (Tag tag : article.getTags()) {
                    this.addArticleTag(articleId, tag.getTagId());
                }
            }
            if (article.getCategories().size() != 0) {
                for (Category category : article.getCategories()) {
                    this.addArticleCategory(articleId, category.getCategoryId());
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean addArticleTag(Long articleId, Long tagId) {
        return articleMapper.insertArticleTag(articleId, tagId);
    }

    @Override
    public boolean addArticleCategory(Long articleId, Long categoryId) {
        return articleMapper.insertArticleCategory(articleId, categoryId);
    }

    @Override
    public boolean removeArticle(Long articleId) {
        return articleMapper.deleteArticle(articleId);
    }

    @Override
    public boolean removeArticleTag(Long articleId, Long tagId) {
        return articleMapper.deleteArticleTag(articleId, tagId);
    }

    @Override
    public boolean removeArticleCategory(Long articleId, Long categoryId) {
        return articleMapper.deleteArticleCategory(articleId, categoryId);
    }

    @Override
    public boolean alterArticle(Article article) {
        return articleMapper.updateArticle(article.getArticleId(), article.getArticleTitle(), article.getArticleType(), article.getArticleUpdateDate(),
                article.getArticleUrl(), article.getArticleHtmlContent(), article.getArticleMdContent());
    }

    @Override
    public boolean alterArticleType(Long articleId, String articleType) {
        return articleMapper.updateArticleType(articleId, articleType);
    }
}
