package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dto.MemberDTO;

@Controller////////////////////////////////////////
public class MemberController {

	@RequestMapping(value="/memberAdd")//회원가입 기능 
	public String memberAdd(MemberDTO m) {
		System.out.println("memberAdd()============"+ m);
		//출력까지만 구현함. 이후 회원가입 구현 함
		return "main";//main.jsp
	}
	
}
