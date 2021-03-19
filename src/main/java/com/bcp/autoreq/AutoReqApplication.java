package com.bcp.autoreq;

import com.bcp.autoreq.property.RequestStorageProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
//@EnableConfigurationProperties({RequestStorageProperty.class})
public class AutoReqApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutoReqApplication.class, args);
	}

}
