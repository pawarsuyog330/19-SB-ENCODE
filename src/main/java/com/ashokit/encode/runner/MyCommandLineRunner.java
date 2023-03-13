package com.ashokit.encode.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRunner implements CommandLineRunner {
	
	private static final String USER_QUERY = "INSERT INTO USERS VALUES(?,?,?)";
	private static final String USER_AUTHORITIES_QUERY = "INSERT INTO AUTHORITIES VALUES(?, ?)";
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	@Override
	public void run(String... args) throws Exception {
		jdbcTemplate.update(USER_QUERY, "Juli", encoder.encode("juli@34"), 1);
		jdbcTemplate.update(USER_QUERY, "Allen", encoder.encode("allen#21"), 1);
		jdbcTemplate.update(USER_QUERY, "Nitin", encoder.encode("nitin@123"), 0);
		
		jdbcTemplate.update(USER_AUTHORITIES_QUERY, "ROLE_MANAGER", "Juli");
		jdbcTemplate.update(USER_AUTHORITIES_QUERY, "ROLE_ADMIN", "Allen");
		jdbcTemplate.update(USER_AUTHORITIES_QUERY, "ROLE_ADMIN", "Nitin");

	}

}
