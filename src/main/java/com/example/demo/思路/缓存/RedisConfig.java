package com.example.demo.思路.缓存;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;

@Configuration
public class RedisConfig {

    @Bean(name = "redisPool")
    public JedisPool jedisPool(@Value("${jedis.host}")String host,
                               @Value("${jedis.port}")int port){
        return new JedisPool(host,port);
    }
}
