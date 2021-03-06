package com.web.store.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;

@Controller
public class HomeController {
//	@RequestMapping("/welcome123")
//	public String welcome(Model model) {
//		model.addAttribute("title", "歡迎蒞臨君雅網路商城！");
//		model.addAttribute("subtitle", "網路上獨一無二的購物天堂！");
//		return "welcome";
//	}
	
	@RequestMapping("/welcome123")
	public ModelAndView welcome() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("title", "歡迎蒞臨君雅網路商城！(mv)"); //mv.addObject("原來的識別字串", 原屬性物件);
		mv.addObject("subtitle", "網路上獨一無二的購物天堂！(mv)"); //mv.addObject("原來的識別字串", 原屬性物件);
		Date date = new Date();// 表示「現在」的Date物件
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String now = sdf.format(date);
		mv.addObject("now", now);
		View view = new InternalResourceView("/WEB-INF/views/welcome.jsp");
		mv.setView(view);
//		mv.setViewName("welcome"); 此行=31、32兩行
		return mv;
	}

	@RequestMapping("/")
	public String index() {
		return "index";
	}
}
