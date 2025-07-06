package org.aike.ordermanserver;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;
import org.aike.ordermanserver.entity.BaseEntity;

public class CodeGenerator {
    public static void main(String[] args) {
        // 执行快速生成
        FastAutoGenerator.create(
                        "jdbc:mysql://localhost:3306/order_man?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai",
                        "root", "root"
                )
                .globalConfig(builder -> {
                    builder
                            .author("艾科") // 开发人员
                            .outputDir(System.getProperty("user.dir") + "/src/main/java") // 输出路径
                            .dateType(DateType.TIME_PACK) // 时间类型
                            .commentDate("yyyy-MM-dd") // 注释日期格式
                            .enableSwagger() // 开启 Swagger 模式
                            .disableOpenDir(); // 禁止生成后打开目录
                })
                .packageConfig(builder -> {
                    builder
                            .parent("org.aike.ordermanserver") // 父包名
                            .entity("model")
                            .service("service") // 设置 Service 包名
                            .serviceImpl("service.impl") // 设置 Service Impl 包名
                            .mapper("mapper");// 设置 Mapper 包名

                })
                .strategyConfig(builder -> {
                    builder
                            .addInclude("user")
                            .serviceBuilder()
                            .formatServiceFileName("%sService")
                            .entityBuilder()
                            .superClass(BaseEntity.class)
                            .formatFileName("%sEntity")
                            .enableSerialAnnotation()
                            .enableLombok() // 启用Lombok
                            .enableChainModel()
                            .idType(IdType.AUTO) // 主键类型
                            .logicDeleteColumnName("is_deleted")
                            .columnNaming(NamingStrategy.underline_to_camel) // 字段转驼峰
                            .addSuperEntityColumns("id", "created_by", "created_at", "updated_by", "updated_at")
                            .addTableFills(new Column("created_at", FieldFill.INSERT))
                            .addTableFills(new Column("updated_at", FieldFill.UPDATE))
                            .controllerBuilder()

                            .enableRestStyle(); //生成RestController
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker模板
                .execute();
    }
}
