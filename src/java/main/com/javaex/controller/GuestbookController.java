package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;


@Controller
public class GuestbookController {

	@Autowired//자동으로 연결해달라 
	private GuestbookDao guestbookDao;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		System.out.println("list 진입");
		
		List<GuestbookVo> gList =guestbookDao.getList();
		model.addAttribute("gList", gList);
		
		return "list";
	}

	@RequestMapping(value = "/deleteform", method = RequestMethod.GET)
	public String deleteform(@RequestParam("no") int no, Model model) {
		System.out.println("deleteform 진입");
		
		model.addAttribute("no", no);
		return "deleteform";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(@RequestParam("no") int no, 
						 @RequestParam("password") String password) {
		System.out.println("delete 진입");
		guestbookDao.delete(no, password);
		
		return "redirect:/list";
	}
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(@ModelAttribute GuestbookVo guestbookVo) {
		System.out.println(guestbookVo.toString());
		
		guestbookDao.insert(guestbookVo);
		
		return "redirect:/list";
	}
	
}

