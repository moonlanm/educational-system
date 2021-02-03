# educational-system

## 非java环境摘要
1. nacos
   > 单体运行，不需要设置mysql持久化
2. postgresql
   > 数据库为sys_edu，如果没有数据库，可以按照以下步骤
   > 1. 把该项目的application.yml文件中的`spring.jpa.hibernate.auto`修改为create，
   > 2. 运行`educational-system-commons`项目下的edu.hubu.commons.CommonTests类中的任意一个空方法即可创建数据库
   > 3. 将`spring.jpa.hibernate.auto`修改为update