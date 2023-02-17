package com.sk;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;

@Configuration
@PropertySource(value = "application.properties", ignoreResourceNotFound = true)
public class DataConfig implements InitializingBean {

	@Value("${csv.file.location}")
	private String location;

	@Override
	public void afterPropertiesSet() {
		System.out.println(location);
	}

	public String getLocation() {
		return this.location;
	}
}