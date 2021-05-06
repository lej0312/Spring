package com.myguest.model;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("service")
public class GuestServiceImpl implements GuestService {

	@Resource(name="dao")
	private GuestDAOImpl dao;
	
	//�߰�
	@Override
	public void guestInsert(GuestDTO guest) {
		dao.dao_guestInsert(guest);
	}

	//����
	@Override
	public List<GuestDTO> gusetList(HashMap<String, String> hm) {
		return dao.dao_gusetList(hm);
	}

	//
	@Override
	public GuestDTO findByNum(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void guestUpdate(GuestDTO guest) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void guestDelete(int num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int guestCount(HashMap<String, String> hm) {
		// TODO Auto-generated method stub
		return 0;
	}

}