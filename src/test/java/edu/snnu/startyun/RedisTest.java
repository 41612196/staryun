package edu.snnu.startyun;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisTest {

    @Test
    public void demo(){

        Jedis jedis = new Jedis("192.168.0.136", 6379);
        System.out.println("服务正在运行：" + jedis.get("k1"));
    }
}
