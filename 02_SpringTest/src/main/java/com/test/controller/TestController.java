package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	@RequestMapping("test.go")
	public String test() { //String->view(jsp)�ǹ�
		return "result"; //result.jsp
	}
	
	@RequestMapping("test22.go")
	public String test2() { //String->view(jsp)�ǹ�
		return "result2"; //result.jsp
	}


}
