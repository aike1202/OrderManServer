package org.aike.ordermanserver;

import cn.dev33.satoken.SaManager;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.aike.ordermanserver.mapper")
//@EnableOpenApi
public class OrderManServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderManServerApplication.class, args);
        System.out.println("启动成功，Sa-Token 配置如下：" + SaManager.getConfig());
    }

}
