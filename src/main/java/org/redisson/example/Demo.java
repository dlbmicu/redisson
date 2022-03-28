package org.redisson.example;

import org.redisson.Config;
import org.redisson.Redisson;
import org.redisson.RedissonClient;
import org.redisson.client.RedisClient;
import org.redisson.core.RLock;

import java.util.concurrent.TimeUnit;

/**
 * @author zhouhao
 * @date 2022/3/28
 */

public class Demo {
    public static void main(String[] args) {
        Config config=new Config();
        config.useSingleServer()
                .setAddress("localhost:6379");
        RedissonClient client=Redisson.create(config);
        RLock lock=client.getLock("test");
        lock.lock(-1, TimeUnit.SECONDS);
    }
}
