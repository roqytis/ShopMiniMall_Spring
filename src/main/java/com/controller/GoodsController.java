package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dto.GoodsDTO;
import com.service.GoodsService;

@Controller
public class GoodsController {
	@Autowired
	GoodsService serivce;
	
	@RequestMapping("/goodsList")
	public ModelAndView goodsList(@RequestParam("gCategory") String gCategory) {//카테고리별 상품목록보기 단 로그인 된 경우만 호출
		if(gCategory== null) {
			gCategory="top";
		}
		List<GoodsDTO> list= serivce.goodsList(gCategory);
		ModelAndView mav= new ModelAndView();
		mav.addObject("goodsList", list);  //
		//request.setAttribute("goodsList", list)와 동일
		mav.setViewName("main"); //main.jsp=>   goodList.jsp에서 목록을 뿌려줌
		return mav;				
	}
	/*
	 * @RequestMapping("/goodsList/gCategory/{category}")//pathVariable사용할 url
	 * public String goodsList2() { return ""; }
	 */
	
}
