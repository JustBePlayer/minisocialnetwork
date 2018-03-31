package com.ado.fmi.minisocialnetwork.app.configuration;

import org.jooq.SQLDialect;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import javax.sql.DataSource;

@Configuration
public class JooQConfig {

  @Autowired
  private DataSource dataSource;

  @Bean
  public DataSourceConnectionProvider connectionProvider() {
    return new DataSourceConnectionProvider(new TransactionAwareDataSourceProxy(dataSource));
  }

  @Bean
  public DefaultDSLContext getDslContext(){
    return new DefaultDSLContext(createDslConfiguration());
  }

  private org.jooq.Configuration createDslConfiguration(){
    org.jooq.Configuration config = new DefaultConfiguration();
    config.set(connectionProvider());
    config.set(SQLDialect.DERBY);
    return config;
  }

}
