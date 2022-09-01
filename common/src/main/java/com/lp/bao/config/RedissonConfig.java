package com.lp.bao.config;

import lombok.Setter;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.redis")
@Setter
public class RedissonConfig {
    private String host;
    private int port;
    private int database;
    private String password;


    @Bean(destroyMethod = "shutdown")
    RedissonClient redissonClient() {
        Config config = new Config();
        //Redis多节点
        // config.useClusterServers()
        //     .addNodeAddress("redis://127.0.0.1:6379", "redis://127.0.0.1:7001");
        //Redis单节点
        SingleServerConfig singleServerConfig = config.useSingleServer();
        //可以用"rediss://"来启用SSL连接
        String address = "redis://" + host + ":" + port;
        singleServerConfig.setAddress(address);
        //设置 数据库编号
        singleServerConfig.setDatabase(database);
       // singleServerConfig.setPassword(password);
        //连接池大小:默认值：64
        // singleServerConfig.setConnectionPoolSize()
        return Redisson.create(config);
    }

}
