package fun.yunblog.radical;

import fun.yunblog.radical.mapper.ArticleMapper;
import fun.yunblog.radical.mapper.UserMapper;
import fun.yunblog.radical.model.domain.Article;
import fun.yunblog.radical.service.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
class RadicalApplicationTests {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private LinkService linkService;
    @Autowired
    private OptionService optionService;
    @Autowired
    private TagService tagService;
    @Autowired
    private CategoryService categoryService;


    @Test
    void contextLoads() {
    }

    @Test
    void testUserService() {
        System.out.println(userService.queryMenu("name1"));
        System.out.println(userService.queryAllUser());
        System.out.println(userService.queryUserByUserId((long)1));
        System.out.println(userService.queryUserByUserName("name1"));

        // wrong
        System.out.println(userService.queryMenu("namenull"));
        System.out.println(userService.queryUserByUserId((long)-1));
        System.out.println(userService.queryUserByUserName("namenull"));
    }

    @Test
    void testRoleService() {
        System.out.println(roleService.queryRolesByUserName("name1"));
        System.out.println(roleService.queryRolesNameByUserName("name1"));

        //wrong
        System.out.println(roleService.queryRolesByUserName("namenull"));
        System.out.println(roleService.queryRolesNameByUserName("namenull"));
    }

    @Test
    void testPermissionService() {
        System.out.println(permissionService.queryPermissionByUserName("name1"));
        System.out.println(permissionService.queryPermissionCodeByUserName("name1"));
        System.out.println(permissionService.queryAllPermission());
        System.out.println(permissionService.queryFatherPermissionByUserName("name1"));
        System.out.println(permissionService.querySubPermissionByFatherPermissionId((long)7));

        //wrong
        System.out.println(permissionService.queryPermissionByUserName("namenull"));
        System.out.println(permissionService.queryPermissionCodeByUserName("namenull"));
        System.out.println(permissionService.queryFatherPermissionByUserName("namenull"));
        System.out.println(permissionService.querySubPermissionByFatherPermissionId((long)-1));
    }

    @Test
    void testArticleService() {
//        System.out.println(articleService.queryArticlesByUserId((long)1));
//        System.out.println(articleService.queryArticlesByUserName("name1"));
//        Article article = new Article((long) 29, "title", "articletype", new Date(), new Date(), "url", "content", "content", (long)1);
//        System.out.println(articleService.alterArticle(article));
//        System.out.println(articleService.queryArticleByArticleId((long) 32));
//                articleService.addArticle(article);


        //wrong
//        System.out.println(articleService.queryArticlesByUserId((long)-1));
//        System.out.println(articleService.queryArticlesByUserName("namenull"));
//        System.out.println(articleService.queryArticleByArticleId((long) 33));

//        System.out.println(articleService.removeArticle((long) 7));

//        System.out.println(articleService.queryArticleByArticleId((long) 48));
//        System.out.println(articleService.queryArticlesByUserName("admin"));
//        System.out.println(articleService.queryArticlesByUserId((long) 1));
//        System.out.println(articleService.queryArticlesByCategoryId((long) 1));
//        System.out.println(articleService.queryArticlesByTagId((long) 1));
//        System.out.println(articleService.queryArticlesComplete("admin"));
        System.out.println(articleService.queryArticlesSimple("admin", (long) 5));
//        System.out.println(articleService.queryArticleWithoutContent("admin"));
    }



    @Test
    void testOptionService() {
        System.out.println(optionService.queryAllOption());
        System.out.println(optionService.queryOptionByOptionId((long) 1));

        //wrong
        System.out.println(optionService.queryOptionByOptionId((long) -1));
    }


    @Test
    void testLinkService() {
        System.out.println(linkService.queryAllLink());
        System.out.println(linkService.queryLinkByLinkId((long) 1));

        //wrong
        System.out.println(linkService.queryLinkByLinkId((long) -1));
    }

    @Test
    void testTagService() {
        System.out.println(tagService.queryAllTag());

//        System.out.println(tagService.queryAllTagComplete());
//        System.out.println(tagService.queryTagByTagId((long) 1));
//        System.out.println(tagService.queryTagByTagName("tag1"));
//
//        System.out.println(tagService.queryTagByTagId((long) 11));
//        System.out.println(tagService.queryTagByTagName("tagffffff"));
    }

    @Test
    void testCategoryService() {
        System.out.println(categoryService.queryAllCategory());
        System.out.println(categoryService.queryCategoryByCategoryId((long) 1));
        System.out.println(categoryService.queryCategoryByCategoryName("categoryName1"));
    }

}
