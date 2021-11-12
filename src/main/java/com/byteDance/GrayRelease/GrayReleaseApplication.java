package com.byteDance.GrayRelease;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com/byteDance/GrayRelease/infrastructure/mapper")
@EnableApolloConfig
public class GrayReleaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(GrayReleaseApplication.class,args);
    }
}
