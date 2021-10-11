package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dto.CartDTO;
import com.dto.GoodsDTO;
import com.dto.MemberDTO;
import com.service.GoodsService;

@Controller
public class GoodsController {
	@Autowired
	GoodsService serivce;
	
	@RequestMapping("/loginCheck/cartAdd")
	public String cartAdd(CartDTO cart, HttpSession session) {
		MemberDTO mDTO= (MemberDTO)session.getAttribute("login");
		cart.setUserid(mDTO.getUserid());
		session.setAttribute("mesg", cart.getgCode());
		serivce.cartAdd(cart);
		
		return "redirect:../goodsRetrieve?gCode="+cart.getgCode();
	}
	
	@RequestMapping("/goodsRetrieve")//goodsRetrieve.jsp  //view에 대한 지정이 없음 url= 뷰파일.jsp
	@ModelAttribute("goodsRetrieve") //key값  goodsRetrieve= dto
	public GoodsDTO goodsRetrieve(@RequestParam("gCode") String gCode) {//상품자세히 보기
		GoodsDTO dto= serivce.goodsRetrieve(gCode);
		return dto;		
	}
	
	
	
	
	
	
	
	
	
	@RequestMapping("/goodsList")
	public ModelAndView goodsList(@RequestParam("gCategory") String gCategory) {//상품목록보기
		if(gCategory== null) {
			gCategory="top";
		}
		List<GoodsDTO> list= serivce.goodsList(gCategory);
		ModelAndView mav= new ModelAndView();
		mav.addObject("goodsList", list);
		//request.setAttribute("goodsList", list)와 동일
		mav.setViewName("main"); //main.jsp
		return mav;				
	}
	/*
	 * @RequestMapping("/goodsList/gCategory/{category}") public String
	 * goodsList2(@PathVariable("category") String gCategory, Model m) {
	 * List<GoodsDTO> list =serivce.goodsList(gCategory);
	 * m.addAttribute("goodsList", list); return
	 * "redirect:../../goodsList?gCategory="+gCategory; }
	 */
	
}
