package com.myguest.model;

import lombok.Data;

@Data
public class GuestDTO { //lombok(@Data) ����ϸ� �ڵ������� getter, setter ��� �ڵ����� ������
	private int num;
	private String name;
	private String content;
	private String grade;
	private String created;
	private String ipaddr;
}
