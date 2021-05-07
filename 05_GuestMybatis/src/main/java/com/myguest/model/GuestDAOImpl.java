package com.myguest.model;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myguest.mapper.GuestMapper;

@Repository("dao")
public class GuestDAOImpl implements GuestDAO{
	@Autowired
	private GuestMapper mapper;
	
	//입력
	@Override
	public void dao_guestInsert(GuestDTO guest) {
		mapper.insert(guest);
	}

	//전체보기
	@Override
	public List<GuestDTO> dao_gusetList(HashMap<String, String> hm) {
		return mapper.list(hm);
	}

	//상세보기
	@Override
	public GuestDTO dao_findByNum(int num) {
		return mapper.findByNum(num);
	}

	@Override
	public void dao_guestUpdate(GuestDTO guest) {
		// TODO Auto-generated method stub
		
	}

	//삭제
	@Override
	public void dao_guestDelete(int num) {
		mapper.delete(num);
		
	}

	//개수
	@Override
	public int dao_guestCount(HashMap<String, String> hm) {
		return mapper.count(hm);
	}

}
