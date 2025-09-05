package com.example.demo.Config;


import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

//설정파일
@Configuration
@EnableTransactionManagement //매니저 활성화
public class TxConfig {

    //dataSource 거내쓰기

    @Autowired
    private DataSource dataSource;
    //기본 Tx(Mybatis용)

    //JPA Tx
    @Bean(name="jpaTransactionManager")

            //JpaTransactionManager를 JpaConfig에 포함시킴
    public JpaTransactionManager jpaTransactionManager(EntityManagerFactory entityManagerFactory) {//만들어진 entityManagerFactory를 전달받음(의존주입)
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
                                //이 매니저에 Transaction처리를 해주는 Manager가 포함됨
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }
}
