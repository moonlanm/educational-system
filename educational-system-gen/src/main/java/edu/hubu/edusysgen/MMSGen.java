package edu.hubu.edusysgen;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

/**
 * @author moonlan
 * date 2021/1/24 下午2:02
 */
@SuppressWarnings(value = "unused")
public class MMSGen {

    public static void main(String[] args) {
        AutoGenerator generator = new AutoGenerator();
        generator.setTemplateEngine(new FreemarkerTemplateEngine());

        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir("/home/moonlan/code/java/educational-system/educational-system-model-dao-service/src/main/java");
        globalConfig.setAuthor("moonlan");
        globalConfig.setOpen(false);
        globalConfig.setBaseResultMap(true);
        generator.setGlobalConfig(globalConfig);

        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:postgresql://localhost:5432/sys_edu");
        dataSourceConfig.setDriverName("org.postgresql.Driver");
        dataSourceConfig.setUsername("postgres");
        dataSourceConfig.setPassword("root");
        dataSourceConfig.setDbType(DbType.POSTGRE_SQL);
        generator.setDataSource(dataSourceConfig);

        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("edu.hubu.mds");
        packageConfig.setXml("mappers");

        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setEntityLombokModel(false);
        strategyConfig.setRestControllerStyle(true);


        generator.setStrategy(strategyConfig);
        generator.setPackageInfo(packageConfig);



        generator.execute();
    }

}