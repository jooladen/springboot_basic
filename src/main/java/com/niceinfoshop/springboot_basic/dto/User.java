package com.niceinfoshop.springboot_basic.dto;

import java.sql.Date;
//import java.util.Date;
import lombok.Data;

@Data
public class User {
	private String no;
	private String name;
	private String email;
	private String regDate;
	private int age;
	private Date regDateSqlDate;
	private Date regDateUtilDate;
}

