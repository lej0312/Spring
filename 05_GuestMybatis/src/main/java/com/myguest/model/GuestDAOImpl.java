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
	
	@Override
	public void dao_guestInsert(GuestDTO guest) {
		mapper.insert(guest);
	}

	@Override
	public List<GuestDTO> dao_gusetList(HashMap<String, String> hm) {
		return mapper.list(hm);
	}

	@Override
	public GuestDTO dao_findByNum(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void dao_guestUpdate(GuestDTO guest) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dao_guestDelete(int num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int dao_guestCount(HashMap<String, String> hm) {
		// TODO Auto-generated method stub
		return 0;
	}

}
