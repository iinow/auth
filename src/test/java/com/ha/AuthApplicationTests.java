package com.ha;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthApplicationTests {
	@Autowired
	private RedisTemplate<byte[], byte[]> redisTemplate;

	@Test
	public void contextLoads() {
	}

	@Test
	public void google() {
		
	}
	
	@Test
	public void redisAdd() {
		String hello = "hello";
		String world = "world";
		redisTemplate.opsForValue().set(hello.getBytes(), world.getBytes());
		
		String res = new String(redisTemplate.opsForValue().get(hello.getBytes()));
		System.out.println(res);
	}
}
