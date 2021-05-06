package com.mycom.models;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycom.vo.PersonVO;
@Repository
public class PersonDAOImpl implements PersonDAO {
	@Autowired
	private SqlSession sqlMapper;
	
	//전체보기(검색 없음)
	public List<PersonVO> dao_listAll(String mid){
		return sqlMapper.selectList(mid);
	}
	
	//추가
	@Override
	public void dao_insert(String mid, PersonVO person) {
		sqlMapper.insert(mid, person);
		
	}
	
	//전체 개수
	public int dao_countAll(String mid) {
		return sqlMapper.selectOne(mid);
	}

	//전체보기(검색 추가)
	@Override
	public List<PersonVO> dao_list(String mid, HashMap<String, String> hm) {
		return sqlMapper.selectList(mid, hm);
	}

	//상세보기
	@Override
	public PersonVO dao_view(String mid, String id) {
		return sqlMapper.selectOne(mid, id);
	}

	//수정하기
	@Override
	public void dao_update(String mid, PersonVO person) {
		sqlMapper.update(mid, person);
		
	}

	//삭제
	@Override
	public void dao_delete(String mid, String id) {
		sqlMapper.delete(mid, id);
		
	}

	//개수(검색 추가)
	@Override
	public int dao_count(String mid, HashMap<String, String> hm) {
		return sqlMapper.selectOne(mid, hm);
	}

}
