package org.ojoseco.guanta;

import org.ojoseco.guanta.domain.repositories.mongo.ProcesoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class ServicesApplication {
	public static void main(String[] args) {
		SpringApplication.run(ServicesApplication.class, args);
	}
}
