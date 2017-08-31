package com.fail.trade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.sql.DataSource;

@Component
public class DataSourceService {
	
    private final  DataSource primaryDataSource;
    private final  DataSource secondaryDataSource;

	   @Autowired
	    public DataSourceService(final DataSource primaryDataSource,@Qualifier("secondDatasource") final DataSource secondaryDataSource ) {
	      this.primaryDataSource = primaryDataSource;
	       this.secondaryDataSource = secondaryDataSource;
	    }
	       
	 
	    @Bean
	    public JdbcTemplate jdbcTemplate(DataSource dataSource)
	    {
	        return new JdbcTemplate(dataSource);
	    }
	 
	    @Bean
	    public PlatformTransactionManager transactionManager(DataSource dataSource)
	    {
	        return new DataSourceTransactionManager(dataSource);
	    }

 
   
   @Transactional(readOnly=true)
   public List<String> findAll() {
       return jdbcTemplate(primaryDataSource).queryForList("SELECT name FROM activity", String.class);
   }
   
   @Transactional(readOnly=true)
   public List<String> getAlexisAll() {
       return jdbcTemplate(secondaryDataSource).queryForList("SELECT name FROM ibmradcsit10", String.class);
   }
   
 
   
    
}