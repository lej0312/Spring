package com.mycom.model;

import java.util.List;

public interface MPersonDAO {
	//�߰�
	public void per_insert(Person person);
	
	//��ü����
	public List<Person> per_list();
	
	//�󼼺���
	public Person per_view(String id);
	
	//����
	public void per_update(Person person);
	
	//����
	public void per_delete(String id);
	
	//����
	public int per_count();

}
