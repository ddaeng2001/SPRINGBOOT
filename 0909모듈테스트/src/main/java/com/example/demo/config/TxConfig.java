package com.example.demo.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
public class TxConfig {

    @Autowired
    private DataSource dataSource;

    @Bean(name="jpaTransactionManager")
            //JpaTransactionManager를 JpaConfig에 포함시킴
    public JpaTransactionManager jpaTransactionManager(EntityManagerFactory entityManagerFactory) {

                                                        //만들어진 entityManagerFactory를 전달받음(의존주입)
        //트랜잭션 기본 코드 작성
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
                            //이 매니저에 Transaction 처리를 해주는 manager가 포함됨
        transactionManager.setDataSource(dataSource);
        return transactionManager;


    }

}

