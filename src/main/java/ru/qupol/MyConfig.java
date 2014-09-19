package ru.qupol;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;


/**
 * simple Spring Config example which contains Datasource to connect to database and entitymanagerfactory to process jpa entities
 * edited by Pavel
 * @author WinZib
 */
@Configuration
public class MyConfig {


    @Bean
    /**
     * Creation of datasource (need be changed for some database)
     */
    public DataSource dataSource() {
        SingleConnectionDataSource dataSource = new SingleConnectionDataSource();
        //driver - depends on database type
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        //url - depends on database location
        dataSource.setUrl("jdbc:mysql://localhost:3306/RoomAuth");
        //auth properies

        dataSource.setUsername("root");
        //some flag
        dataSource.setSuppressClose(true);
        return dataSource;
    }

    @Bean
    //with method should be initialize after datasource
    @DependsOn("dataSource")
    //init entity manager factory bean

    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws Exception {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

        //set jpa dialect to usage hibernate
        entityManagerFactoryBean.setJpaDialect(new HibernateJpaDialect());

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setShowSql(false);
        vendorAdapter.setGenerateDdl(true);
        vendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");

        entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
        //set datasource
        entityManagerFactoryBean.setDataSource(dataSource());
        //set persistence provider class
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        //set package to scan for jpa entities
        entityManagerFactoryBean.setPackagesToScan("ru.qupol.model");


        return entityManagerFactoryBean;
    }

}
