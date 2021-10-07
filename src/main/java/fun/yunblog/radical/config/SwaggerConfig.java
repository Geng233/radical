package fun.yunblog.radical.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author 耿子云
 * @date 2021/9/28
 * @Description swagger 访问路径  /swagger-ui.html#/
 * 使用方法：
 * *  @ApiOperation("content")在方法上
 * *  @ApiModel("entity")在实体上
 * *  @ApiModelProperties("property")在属性上
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("space")
                .apiInfo(apiInfo())
                .enable(true)
                .select()
                .apis(RequestHandlerSelectors.basePackage("fun.yunblog.radical.web.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        Contact DEFAULT_CONTACT = new Contact(
                "gzy",
                "www.yunblog.fun",
                "gengziyun@outlook.com");
        return new ApiInfo(
                "YunBlog的Swagger",
                "查看接口与调试",
                "0.0.1-SNAPSHOT",
                "",
                DEFAULT_CONTACT,
                "Apache 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0.html",
                new ArrayList<>());
    }
}
