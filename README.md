---
简介：
基于springboot + vue + mybatis
这是我本人的个人博客项目，开始于2021年国庆期间，有很多bug，先上线测试

---

实现的功能：
博客的基础功能：前台展示和后台控制

- 用户及其权限控制
- 文章
- 标签
- 目录
- 链接

---

计划实现的功能：

- 评论（表情，图片）
- 邮箱
- 二维码分享(demo单元测试已经ok)
- 图床（demo）

---

用到的相关技术栈

### 后端框架/技术

**springboot**:简化spring开发

**maven&git**:项目管理工具

**h2&mysql**:mysql数据库,h2是内置数据库(适合博客等小型项目)

**mybaits**:一个基于Java的持久层框架

**druid**:jdbc连接池组件

**shiro**:一个功能强大和易于使用的Java安全框架

**swagger**:生成各种格式的接口文档,生成多种语言的客户端和服务端的代码,以及在线接口调试页面

### 后端工具

**lombok**:简化开发

**fastjson**:以将Java对象转换为JSON格式,当然它也可以将JSON字符串转换为Java对象

**commons-lang3**:Apache提供的一个java.lang包的增强版本

**Thumbnailator**:Google开源的优秀图片处理的第三方Java类库,处理效果远比Java API的好

### 前端框架/技术

**vue**:一套用于构建用户界面的渐进式框架

**element-ui**:组件库

**axios**:Axios是一个基于promise的HTTP库,可以用在浏览器和node.js 中

### 前端工具

**simplemde**:markdown语法解析

**showdown**:markdown转html

**qrcodejs2**:二维码生成

**prismjs**:markdown美化

**live2d-widget**:看板娘

**vue-aplayer**:音乐插件

**tocbot**:生成目录
