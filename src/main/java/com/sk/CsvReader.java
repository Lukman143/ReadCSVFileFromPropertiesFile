package com.sk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class CsvReader {

	public List<String> readData() throws IOException {

		ApplicationContext context = new AnnotationConfigApplicationContext(DataConfig.class);
		DataConfig dataConfig = context.getBean(DataConfig.class);

		String location = dataConfig.getLocation();

		// use the properties as required

		System.out.println("#location: " + location);

		Resource resource = new ClassPathResource(location);

		InputStream input = resource.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
		List<String> lines = new ArrayList<>();
		String line;
		while ((line = reader.readLine()) != null) {
			lines.add(line);
		}
		reader.close();
		return lines;
	}
}
