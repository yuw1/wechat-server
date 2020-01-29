package space.wyu.wechatserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WechatServerApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(WechatServerApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		SpringApplicationBuilder springApplicationBuilder = builder.sources(WechatServerApplication.class);
		return springApplicationBuilder;
	}
}
