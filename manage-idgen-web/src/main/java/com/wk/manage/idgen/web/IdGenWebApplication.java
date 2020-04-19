package com.wk.manage.idgen.web;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 描述:
 *
 * @author wukong
 * @create 2020-03-29 下午6:15
 */
@SpringBootApplication
@DubboComponentScan(basePackages = "com.wk.manage.idgen.biz")
public class IdGenWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(IdGenWebApplication.class, args);
    }
}
