package com.mycom.models;

import java.util.HashMap;
import java.util.List;

import com.mycom.vo.PersonVO;

public interface PersonService {
	//�߰�
	public void insert(PersonVO person);
	
	//��ü����
	public List<PersonVO> list(HashMap<String, String> hm);
	
	//�󼼺���
	public PersonVO view(String id);
	
	//����
	public void update(PersonVO person);
	
	//����
	public void delete(String id);
	
	//����
	public int count(HashMap<String, String> hm);
}
