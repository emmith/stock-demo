import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;


public class Generator {
    // 代码生成路径
    static String outputDir = "src/main/java";
    // xml输出路径
    static String xmlOutputDir = "src/main/resources/mapper";

    public static void main(String[] args) {
        //配置pgsql数据库信息
        DataSourceConfig.Builder configBuilder = new DataSourceConfig
                .Builder("jdbc:mysql://localhost:3306/stock", "root", "root");


        FastAutoGenerator.create(configBuilder)
                .globalConfig(builder -> {
                    builder.author("emmith") // 设置作者
//                            .enableSwagger() // 开启 swagger 模式
//                            .fileOverride() // 覆盖已生成文件
                            .outputDir(outputDir) // 指定输出目录
                            .dateType(DateType.TIME_PACK)
                            .commentDate("yyyy-MM-dd")
                            .disableOpenDir();   //禁止打开输出目录，默认:true
                })
                .packageConfig(builder -> {
                    builder.parent("com.example") // 设置父包名
                            .moduleName("stockdemo") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, xmlOutputDir)); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    //实体类生成策略 使用lombok 关闭序列化 生成表字段注解 覆盖已经存在文件
                    builder.entityBuilder().enableLombok().disableSerialVersionUID().enableTableFieldAnnotation().fileOverride();
                    //mapper和controller不选择覆盖，因为我们可能已经在里面编写了代码，防止再次调用生成器时覆盖原有代码
                    //mapper生成策略 添加@Mapper注解 在xml中生成字段映射
                    builder.mapperBuilder().enableMapperAnnotation().enableBaseResultMap();
                    //controller生成策略 开启驼峰转连字符 开启生成@RestController 控制器
                    builder.controllerBuilder().enableHyphenStyle().enableRestStyle();
                    // 设置需要生成的表名 生成实体去除前缀
                    builder.addInclude("stock", "stock_flow");
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}