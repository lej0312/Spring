package com.myguest.model;

import java.util.HashMap;
import java.util.List;

public interface GuestDAO {
	//�߰�
	public void dao_guestInsert(GuestDTO guest);
	
	//��ü����
	public List<GuestDTO> dao_gusetList(HashMap<String, String>hm);
	
	//�󼼺���
	public GuestDTO dao_findByNum(int num);
	
	//����
	public void dao_guestUpdate(GuestDTO guest);
	
	//����
	public void dao_guestDelete(int num);
	
	//����
	public int dao_guestCount(HashMap<String, String>hm);
}
