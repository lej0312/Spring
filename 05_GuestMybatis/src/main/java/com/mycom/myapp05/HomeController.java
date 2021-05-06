package com.mycom.myapp05;

import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myguest.model.GuestDTO;
import com.myguest.model.GuestServiceImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Resource(name="service")
	private GuestServiceImpl service;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "insert";
	}
	
	@PostMapping("gInsert")
	public void insert(GuestDTO guest, HttpServletRequest request){
		guest.setIpaddr(request.getRemoteAddr());
		service.guestInsert(guest);
	}
	
	@GetMapping("gList")
	public String list(Model model) {
		List<GuestDTO> guestlist = service.gusetList(null);
		model.addAttribute("guestlist", guestlist);
		return "list";
	}
	
}
