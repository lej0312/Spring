package com.myguest.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.myguest.model.GuestDTO;

public interface GuestMapper {
	//�߰�
	@Insert("insert into guest (name, content, grade, created, ipaddr)" 
	+ "values (#{name}, #{content}, #{grade}, now(), #{ipaddr})")
	public void insert(GuestDTO guest);
	
	//��ü����
	@Select("select * from guest")
	public List<GuestDTO> list(HashMap<String, String> hm);

}
