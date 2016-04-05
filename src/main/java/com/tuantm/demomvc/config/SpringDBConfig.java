package com.tuantm.demomvc.config;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.hsqldb.util.DatabaseManagerSwing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
public class SpringDBConfig {

    @Autowired
    DataSource dataSource;

//    @Bean
//    public JdbcTemplate getJdbcTemplate() {
//        return new JdbcTemplate(dataSource);
//    }

    @Bean
    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean
    public DataSource getDataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase db = builder.setName("dkmh").setType(EmbeddedDatabaseType.HSQL).setScriptEncoding("UTF-8")
                .addScript("db/sql/create-db.sql").addScript("db/sql/insert-data.sql").build();

//        EmbeddedDatabase db = builder.setName("dkmh").setType(EmbeddedDatabaseType.HSQL).build();
        return db;
    }

    @PostConstruct
    public void startDBManager() {
//
//        // hsqldb
//        DatabaseManagerSwing.main(new String[]{"--url", "jdbc:hsqldb:file:/Users/tuantmtb-osx/Documents/dkmh",
//                "--user", "sa", "--password", ""});
//
//        DatabaseManagerSwing.main(new String[]{"--url", "jdbc:hsqldb:file:/Users/tuantmtb-osx/Documents/dkmh"});
//jdbc:hsqldb:file:/Users/tuantmtb-osx/Documents/db_dkmh.sql;shutdown=true
    }


}