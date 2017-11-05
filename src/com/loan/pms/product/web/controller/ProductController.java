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

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;

@Controller
public class ProductController {
	
	@Resource(name = SystemService.SERVICE_ID)
	private SystemService systemService;
	
	
}
