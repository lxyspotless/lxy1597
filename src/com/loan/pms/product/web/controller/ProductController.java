package com.loan.pms.product.web.controller;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.loan.pms.system.service.SystemService;

import org.springframework.stereotype.Controller;

@Controller
public class ProductController {
	
	@Resource(name = SystemService.SERVICE_ID)
	private SystemService systemService;
	
	@RequestMapping(value = "forward/saleProductDetaol.do", method = RequestMethod.POST)
	public ModelAndView login1(HttpServletRequest request, HttpServletResponse response){
		String username = request.getParameter("username");
		Map paramMap = new HashMap<String,String>();
		Map resultMap = new HashMap<String,Object>();
		ArrayList<Map<String, Object>> menuList = new ArrayList<Map<String,Object>>();
		paramMap.put("umId", null==username?"":username.toUpperCase());
		paramMap.put("passWord", request.getParameter("password"));
		if(systemService.loginSystem(paramMap)){
			resultMap.put("helloworld", "pass_"+username);
		}else{
			resultMap.put("helloworld", "refuse_"+username);
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		mav.addAllObjects(resultMap);
		//mav.addObject("helloworld", "login_"+hello);
		return mav;
	}
	
}
