package com.person2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.person2.model.Person2DAOImpl;
import com.person2.model.PersonVO;

@Controller
public class Person2Controller {
	@Autowired
	private Person2DAOImpl dao;
	
	//추가 폼
	@RequestMapping("personInsert.go")
	public String insertForm() {
		return "personForm";
	}
	
	//추가(db에 추가)
	@RequestMapping(value="personInsert.go", method = RequestMethod.POST)
	public String insert(PersonVO person) {
		dao.person_insert(person);
		return "redirect:personList.go";	
	}
	
	//전체보기
	@RequestMapping(value="personList.go", method = RequestMethod.GET)
	public ModelAndView list() {
		List<PersonVO> userlist = dao.person_list();
		ModelAndView mv = new ModelAndView();
		mv.addObject("personlist", userlist);
		mv.setViewName("personList");
		return mv;
	}
	
	//상세보기
	@RequestMapping("personView.go")
	public ModelAndView view(String id) {
		PersonVO person = dao.person_view(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("person", person);
		mv.setViewName("personView");
		return mv;
	}
	
	//수정폼
	@RequestMapping("personUpdateForm.go")
	public ModelAndView update(String id) {
	PersonVO person = dao.person_view(id);
	ModelAndView mv = new ModelAndView();
	mv.addObject("person", person);
	mv.setViewName("personUpdate");
	return mv;
}

	//수정
	@RequestMapping(value="personUpdate.go", method = RequestMethod.POST)
	public String update(PersonVO person) {
		dao.person_update(person);
		return "redirect:personList.go";
	}
	
	//삭제하기
	@RequestMapping("personDelete.go")
	public ModelAndView delete(String id) {
		dao.person_delete(id);
		return new ModelAndView("redirect:personList.go");
	}
	
}
