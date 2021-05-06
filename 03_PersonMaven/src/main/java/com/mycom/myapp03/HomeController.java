package com.mycom.myapp03;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mycom.model.MPersonDAOImpl;
import com.mycom.model.Person;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private MPersonDAOImpl dao;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	

	//�߰���
	//@RequestMapping("insert")
//	@GetMapping
//	public String insert() {
//		return "insert";
//	}
	
	@GetMapping("insert")
	public void insert() {
		
	}
	
	//�߰�
	@PostMapping("insert")
	public String insert(Person person) {
		dao.per_insert(person);
		return "redirect:list";
	}
	
	//��ü����
	@GetMapping("list")
	public String list(Model model) { //���� �����ؾ� �Ѵٸ� Model�� ���
		List<Person> personlist = dao.per_list();
		int count = dao.per_count();
		model.addAttribute("personlist", personlist);
		model.addAttribute("count", count);
		return "personList";
	}
	
	//�󼼺���, ������
	@GetMapping({"view", "update"})
	public void view(String id, Model model) { //void ���� view, update�� �Ѿ���� jsp�� ã��
		Person person = dao.per_view(id);
		model.addAttribute("person", person);
	}
	
	//����
	@PostMapping("update")
	public String update(Person person) {
		dao.per_update(person);
		return "redirect:list";
	}
	
	//����
	@GetMapping("delete")
	public String delete(String id) {
		dao.per_delete(id);
		return "redirect:list";
	}
	
}
