package com.jiujiuhouse.resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author zzh
 */
@SpringBootApplication
@EnableJpaAuditing
public class ResourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResourceApplication.class, args);
	}

}
