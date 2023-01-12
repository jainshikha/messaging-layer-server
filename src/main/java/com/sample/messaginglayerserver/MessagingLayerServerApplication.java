package com.sample.messaginglayerserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import redis.embedded.RedisServer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;

@SpringBootApplication
public class MessagingLayerServerApplication {


	private RedisServer redisServer;
	public static void main(String[] args) {
		SpringApplication.run(MessagingLayerServerApplication.class, args);
	}


	/*@Value("${spring.redis.port}")
	private int port;
*/
	@PostConstruct
	public void startRedis() throws IOException {
		redisServer  = new RedisServer(6371);
		redisServer.start();
	}

	@PreDestroy
	public void stopRedis(){
		redisServer.stop();
	}
}
