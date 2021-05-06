package com.mycom.models;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.vo.PersonVO;

@Service
public class PersonServiceImpl implements PersonService {
	@Autowired
	private PersonDAOImpl dao;
	
	//전체보기(검색없음)
	public List<PersonVO>listAll(){
		return dao.dao_listAll("allPerson");
	}
	
	//개수
	public int countAll() {
		return dao.dao_countAll("allCount");
	}
	
	//추가
	@Override
	public void insert(PersonVO person) {
		dao.dao_insert("insertPerson", person);
		
	}	
	
	//보기(검색 있음)
	@Override
	public List<PersonVO> list(HashMap<String, String> hm) {
		return dao.dao_list("listPerson", hm);
	}

	//상세보기
	@Override
	public PersonVO view(String id) { //viewPerson
		return dao.dao_view("viewPerson", id);
	}

	//수정
	@Override
	public void update(PersonVO person) {
		dao.dao_update("updatePerson", person);
	}

	//삭제
	@Override
	public void delete(String id) {
		dao.dao_delete("deletePerson", id);
		
	}

	//개수
	@Override
	public int count(HashMap<String, String> hm) {
		return dao.dao_count("countPerson", hm);
	}

}
