package top.onos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MemcachedInPractiseApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MemcachedInPractiseApplication.class, args);
	}
}
