package com.mycom.myapp05;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myguest.model.GuestDTO;
import com.myguest.model.GuestListVO;
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
	
	//추가
	@PostMapping("gInsert")
	@ResponseBody
	public String insert(@RequestBody GuestDTO guest, //void:리턴되어지는 jsp..? @RequestBody:json형태로 받음
			HttpServletRequest request){
		guest.setIpaddr(request.getRemoteAddr());
		service.guestInsert(guest);
		//return "redirect:gList";
		return "success";
	}
	
	//전체보기
	@GetMapping("gList")
	@ResponseBody
	public GuestListVO list(String field, String word) {
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("field", field);
		hm.put("word", word);
		List<GuestDTO> guestlist = service.gusetList(hm);
		int count = service.guestCount(hm);
		GuestListVO listvo = new GuestListVO(count, guestlist);
		return listvo;
	}
	
	//상세보기
	@GetMapping("gView")
	@ResponseBody
	public GuestDTO view (@RequestParam(name = "num", required = false) int num) {
		GuestDTO guest = service.findByNum(num);
		return guest;
	}
	
//	@GetMapping("gView")
//	@ResponseBody
//	public String view(@RequestParam("num") int num) {
//		GuestDTO guest = service.findByNum(num);
//		JSONObject obj = new JSONObject();
//		obj.put("num", guest.getNum());
//		obj.put("name", guest.getName());
//		obj.put("content", guest.getContent());
//		obj.put("grade", guest.getGrade());
//		obj.put("created", guest.getCreated());
//		obj.put("ipaddr", guest.getIpaddr());
//		return obj.toString();
//	} jackson 안쓰고 json 썼을때
	
	//삭제
	@DeleteMapping("gDelete/{num}")
	@ResponseBody
	public String delete(@PathVariable int num) {
		service.guestDelete(num);
		return "success";
	}
}
