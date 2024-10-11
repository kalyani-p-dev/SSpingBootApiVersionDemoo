package com.zensar;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ApiConfig {
 
	@Value("${spring.application.name}")
	private String appName;
	
	@Bean
	public String getAppName() {
		return this.appName;
	}
	@Bean
	@Profile("prod")
	
		public Operation getOperation() {
			return new Operation(50);
		}
	}
	
	
	class Operation {
		int x;
		public Operation() {}
		public Operation(int x) {
			this.x = x;
		}
		@Override
		public String toString() {
			return "Operation [x=" + x + "]";
		}
		
	}
