package com.niceinfoshop.springboot_basic.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {

	@Select("select no, name, IFNULL(email, '') as email, regDate from user2")
	public List<Map<String, Object>> findAll();
	
	@Select("select no, name, IFNULL(email, '') as email, pwd, gender, regDate from user2 where no = #{no}")
	public Map<String, Object> findById(int no);
	
	@Update("update user2 set email = #{email}, pwd = #{pwd}, gender = #{gender} where no = #{no}")
	public int editById(Map<String, Object> paramMap);
	
	@Delete("delete from user2 where no = #{no}")
	public int delete(int no);
	
	@Insert("insert into user2 (name, email, pwd, gender) value (#{name}, #{email}, #{pwd}, #{gender})")
	public int save(Map<String, Object> paramMap);
	
	@Select("select last_insert_id() as no")
	public int findByNo();
	
}
