package com.myguest.model;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("service")
public class GuestServiceImpl implements GuestService {

	@Resource(name="dao")
	private GuestDAOImpl dao;
	
	//추가
	@Override
	public void guestInsert(GuestDTO guest) {
		dao.dao_guestInsert(guest);
	}

	//보기
	@Override
	public List<GuestDTO> gusetList(HashMap<String, String> hm) {
		return dao.dao_gusetList(hm);
	}

	//
	@Override
	public GuestDTO findByNum(int num) {
		return dao.dao_findByNum(num);
	}

	@Override
	public void guestUpdate(GuestDTO guest) {
		// TODO Auto-generated method stub
		
	}

	//삭제
	@Override
	public void guestDelete(int num) {
		dao.dao_guestDelete(num);
		
	}

	//개수
	@Override
	public int guestCount(HashMap<String, String> hm) {
		return dao.dao_guestCount(hm);
	}

}
