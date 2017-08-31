package com.fail.trade.controller;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;  

@RestController
@RequestMapping("/failtrade")
public class RestApiController {
	
@Autowired
private DataSourceService dataSourceService;
	
	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

	// -------------------Retrieve All
	// Users---------------------------------------------

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsers() {
		List<User> users = new ArrayList<User>();
		User user = new User("Amit", "Sarah", "FIT");
		users.add(user);
		if (users.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	
	@RequestMapping(value = "/str", method = RequestMethod.GET)
	public List<String> listAllString() {
		List<String> users = new ArrayList<String>();
        
		users.add("Amit");
		 
		users.add("Sumit");
		return users;
	}
	
	@RequestMapping(value = "/jdbctemp", method = RequestMethod.GET)
	public List<String> listJDBCString() {
		List<String> users = dataSourceService.findAll();
        

		return users;
	}
	
	@RequestMapping(value = "/jdbcalexis", method = RequestMethod.GET)
	public List<String> listAlexisJDBCString() {
		List<String> users = dataSourceService.getAlexisAll();
        
		return users;
	}
}
