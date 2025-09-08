package com.example.demo.config;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

	@Bean
	public <HikariDataSource> HikariDataSource dataSource()
	{
        //HikariDataSource 사용할 것
        HikariDatSource dataSource = new HikariDatSource();

        //Mysql Connection
        // Id : root
        // Pw : 1234
        datSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/testdb");
        dataSource.setUsername("root");
        dataSource.setPassword("1234");
        return dataSource;
	}

}
