package com.sk;

import java.io.IOException;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MyApplication {

	public static void main(String[] args) throws IOException {

		ConfigurableApplicationContext context = SpringApplication.run(MyApplication.class, args);
		CsvReader csvReader = context.getBean(CsvReader.class);
		List<String> lines = csvReader.readData();
		for (String line : lines) {
			String[] fields = line.split(",");
			String id = fields[0];
			System.out.println(id);
		}

	}
}
