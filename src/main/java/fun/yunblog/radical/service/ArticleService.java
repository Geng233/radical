package fun.yunblog.radical.service;

import fun.yunblog.radical.model.domain.Article;
import fun.yunblog.radical.model.domain.User;

import java.util.Date;
import java.util.List;

/**
 * @author 耿子云
 * @date 2021/9/27
 */
public interface ArticleService {

    public List<Article> queryArticlesComplete(String userName, Long length);

    public List<Article> queryArticlesSimple(String userName, Long length);

    public List<Article> queryArticleWithoutContent(String userName);

    public List<Article> queryArticlesByUserId(Long userId);

    public List<Article> queryArticlesByCategoryId(Long categoryId);

    public List<Article> queryArticlesByTagId(Long tagId);

    public List<Article> queryArticlesByUserName(String userName);

    public Article queryArticleByArticleId(Long articleId);

    public Long queryArticleIdByArticleName(String articleName);

    public boolean addArticle(Article article);

    public boolean addArticleTag(Long articleId, Long tagId);

    public boolean addArticleCategory(Long articleId, Long categoryId);

    public boolean removeArticle(Long articleId);

    public boolean removeArticleTag(Long articleId, Long tagId);

    public boolean removeArticleCategory(Long articleId, Long categoryId);

    public boolean alterArticle(Article article);

    public boolean alterArticleType(Long articleId, String articleType);
}
