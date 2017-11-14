package com.loan.pms.product.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.loan.pms.product.dto.ProductInfoDTO;
import com.loan.pms.product.service.ProductService;
import com.loan.pms.system.web.controller.SystemController;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

@Controller
public class ProductController {
	
	private static Logger logger = Logger.getLogger(SystemController.class);
	
	@Resource(name = ProductService.SERVICE_ID)
	private ProductService productService;
	
	@RequestMapping(value = "/querySaleProductList.do", method = RequestMethod.POST)
	@ResponseBody
	public List<ProductInfoDTO> querySaleProductList(HttpServletRequest request, HttpServletResponse response) {
		logger.info("/querySaleProductList.do - begin");
		// 获取入参：业务条线和销售产品名称
		String businessLine = request.getParameter("businessLine");
		String saleProductName = request.getParameter("saleProductName");
		logger.info(String.format("入参：业务条线:%s,销售产品名称:%s", businessLine, saleProductName));
		List<ProductInfoDTO> list = productService.queryProductInfoList(businessLine, saleProductName);
		logger.info("/querySaleProductList.do - end");
		return list;
	}
}
