package com.myguest.model;

import java.util.List;

import lombok.Data;
import lombok.Getter;

@Getter
public class GuestListVO {
	private int count;
	private List<GuestDTO> list;
	
	public GuestListVO(int count, List<GuestDTO> list) {
		this.count = count;
		this.list = list;
	}
}
