package org.techhub.Config;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@Configuration
@ComponentScan(basePackages = {"org.techhub.service","org.techhub.repository"})
public class DBConfig {

	@Bean(name="datasource")
	public DriverManagerDataSource getDataSource() {

		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/springmini");
		datasource.setUsername("root");
		datasource.setPassword("1234");
		return datasource;
	}
	@Bean(name="template")
	public JdbcTemplate getTemplate() {
		JdbcTemplate template = new JdbcTemplate();
		template.setDataSource(getDataSource());
		return template;
	}
}
