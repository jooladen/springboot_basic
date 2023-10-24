package com.niceinfoshop.springboot_basic.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.niceinfoshop.springboot_basic.dto.User;

@Controller
public class ResponseEntityController {
	
	//ReponseEntity를 사용하면 @ResponseBody사용하지 않아도 화면에
	//나타나는 듯 하다.
	@GetMapping("/data")
    public ResponseEntity<String> getData() {
        String data = "This is the response data.";
        return ResponseEntity.ok(data); // 상태 코드 200 OK와 데이터 반환
    }
	
	@GetMapping("/data1")
	@ResponseBody
    public String getData1() {
        String data = "This is the response data.";
        return data; 
    }
	
	@GetMapping("/users/ok")
    public ResponseEntity<User> getUserOk() {
        User user = new User();
        user.setAge(30);
        user.setEmail("jooalden@gmail.com");;
        // 사용자를 찾았을 경우 200 OK 상태 코드와 사용자 정보 반환
        return ResponseEntity.ok(user);
        
    }
	
	@GetMapping("/users/null")
    public ResponseEntity<User> getUserNull() {
		User user = new User();
        // 사용자를 찾지 못한 경우 404 Not Found 상태 코드 반환
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		//return ResponseEntity.status(HttpStatus.OK).body(null);
		//return ResponseEntity.status(HttpStatus.OK).body(user);
        
    }
}
