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
	
	//��ü����(�˻� ����)
	public List<PersonVO> dao_listAll(String mid){
		return sqlMapper.selectList(mid);
	}
	
	//�߰�
	@Override
	public void dao_insert(String mid, PersonVO person) {
		sqlMapper.insert(mid, person);
		
	}
	
	//��ü ����
	public int dao_countAll(String mid) {
		return sqlMapper.selectOne(mid);
	}

	//��ü����(�˻� �߰�)
	@Override
	public List<PersonVO> dao_list(String mid, HashMap<String, String> hm) {
		return sqlMapper.selectList(mid, hm);
	}

	//�󼼺���
	@Override
	public PersonVO dao_view(String mid, String id) {
		return sqlMapper.selectOne(mid, id);
	}

	//�����ϱ�
	@Override
	public void dao_update(String mid, PersonVO person) {
		sqlMapper.update(mid, person);
		
	}

	//����
	@Override
	public void dao_delete(String mid, String id) {
		sqlMapper.delete(mid, id);
		
	}

	//����(�˻� �߰�)
	@Override
	public int dao_count(String mid, HashMap<String, String> hm) {
		return sqlMapper.selectOne(mid, hm);
	}

}
