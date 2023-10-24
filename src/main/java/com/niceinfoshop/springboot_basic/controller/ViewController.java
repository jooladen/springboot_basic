package com.niceinfoshop.springboot_basic.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.niceinfoshop.springboot_basic.dto.User;
import com.niceinfoshop.springboot_basic.mapper.UserMapper;

@Controller
public class ViewController {
	
	@Autowired UserMapper um;

	@GetMapping("/")
	public String queryDirect(Model model) {
		//Query에서 List<HashMap<String, Object>>로 리턴받는다.
		model.addAttribute("result", um.findAll());
//		{result=[{
//					no=1, 
//		            name=주영준, 
//		            regDate=2023-10-18T11:44:23, 
//		            email=jooladen@gmail.com
//		        }]
//		}
		return "user/List";
	}
	@GetMapping("/re")
	public ResponseEntity<List<Map<String, Object>>> queryDirect() {
	    List<Map<String, Object>> userList = um.findAll();

	    return new ResponseEntity<>(userList, HttpStatus.OK);
	}
	
	@GetMapping("/re2")
	@ResponseBody
	public List<Map<String, Object>> queryDirect2() {
	    List<Map<String, Object>> userList = um.findAll();

	    return userList;
	}
	
	@GetMapping("/listMap")
	public String listMap(Model model) {
		//List<HashMap<String, String>> 방식	
		
		String name ="홍길동1";
		String email ="hong@hanmail.net";
		String regDate ="2023-10-18";
		
		//List<HashMap<String, String>> list = new ArrayList<>(); 아래와 동일
		List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("no", "1");
		map.put("name", name);
		map.put("email", email);
		map.put("regDate", regDate);
		
		list.add(map);
		model.addAttribute("result", list);
		//{no=1, name=홍길동1, regDate=2023-10-18, email=hong@hanmail.net}
		//[{no=1, name=홍길동1, regDate=2023-10-18, email=hong@hanmail.net}]
		//{result=[{no=1, name=홍길동1, regDate=2023-10-18, email=hong@hanmail.net}]}
		return "user/List";

	}
	@GetMapping("/listDto")
	public String listDto(Model model) {
		// List<User> list방식
		//List<User> list = new ArrayList<User>(); 아래와 동일
		
		List<User> list = new ArrayList<>();
		User user = null;
		user = new User();
		user.setNo("1");
		user.setName("김영준");
		user.setEmail("hong@hanmail.net");
		user.setRegDate("2023-10-18");
		list.add(user);
		
		user = new User();
		user.setNo("2");
		user.setName("박영준");
		user.setEmail("im@hanmail.net");
		user.setRegDate("2023-10-19");
		list.add(user);
		
		model.addAttribute("result", list);
		
		//{result=[User(no=1, name=김영준, email=hong@hanmail.net, regDate=2023-10-18, age=0, regDateSqlDate=null, regDateUtilDate=null)]}
		//[User(no=1, name=김영준, email=hong@hanmail.net, regDate=2023-10-18, age=0, regDateSqlDate=null, regDateUtilDate=null), User(no=2, name=박영준, email=im@hanmail.net, regDate=2023-10-19, age=0, regDateSqlDate=null, regDateUtilDate=null)]
		//{result=[User(no=1, name=김영준, email=hong@hanmail.net, regDate=2023-10-18, age=0, regDateSqlDate=null, regDateUtilDate=null), User(no=2, name=박영준, email=im@hanmail.net, regDate=2023-10-19, age=0, regDateSqlDate=null, regDateUtilDate=null)]}
		return "user/List";
	}
	//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	@GetMapping("/findById/{no}")
	public String findById(@PathVariable("no") int no, Model model) {
		model.addAttribute("result", um.findById(no));
		return "user/Select";
	}
	
	@GetMapping("/editById/{no}")
	public String editById(@PathVariable("no") int no, Model model) {
		model.addAttribute("result", um.findById(no));
		return "user/Update";
	}
	
	@PostMapping("/editById")
	public String editById(@RequestParam Map<String, Object> paramMap) {
		int state = um.editById(paramMap);
		return "redirect:/findById/" + paramMap.get("no");
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("no") int no) {
		int state = um.delete(no);
		return "redirect:/";
	}
	
	@GetMapping("/save")
	public String save() {
		return "user/Create";
	}
	
	@PostMapping("/save")
	public String save(@RequestParam Map<String, Object> paramMap) {
		int state = um.save(paramMap);
		int no = um.findByNo();
		return "redirect:/findById/" + no;
	}
	
}
