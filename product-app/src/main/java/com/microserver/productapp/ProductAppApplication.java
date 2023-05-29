package com.microserver.productapp;

import com.microserver.productapp.config.MigrationConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductAppApplication implements CommandLineRunner {

	@Autowired
	private MigrationConfiguration migrationConfiguration;

	public static void main(String[] args) {

		SpringApplication.run(ProductAppApplication.class, args);
	}

	@Override
	public void run(String... args)throws Exception{
		System.out.println("Migration configuration " + migrationConfiguration.getMigration());
	}

}
