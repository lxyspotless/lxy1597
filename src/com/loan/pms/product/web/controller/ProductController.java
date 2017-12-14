package com.loan.pms.product.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.loan.pms.product.dto.ProductInfoDTO;
import com.loan.pms.product.dto.QuerySaleProductDTO;
import com.loan.pms.product.dto.QuerySubProductDTO;
import com.loan.pms.product.dto.SubProductInfoDTO;
import com.loan.pms.product.service.ProductService;
import com.loan.pms.system.web.controller.SystemController;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

@Controller
public class ProductController {
	
	private static Logger logger = Logger.getLogger(SystemController.class);
	
	@Resource(name = ProductService.SERVICE_ID)
	private ProductService productService;
	
	// 查询产品大类信息列表
	@RequestMapping(value = "/querySaleProductInfoList.json", method = RequestMethod.POST)
	@ResponseBody
	public List<ProductInfoDTO> querySaleProductInfoList(HttpServletRequest request, HttpServletResponse response) {
		logger.info("/querySaleProductInfoList.json - begin");
		// 获取入参：业务条线和销售产品名称
		String businessLine = request.getParameter("businessLine");
		String saleProductName = request.getParameter("saleProductName");
		String page = request.getParameter("page");
		String rows = request.getParameter("rows");
		logger.info(String.format("入参：业务条线:%s,销售产品名称:%s", businessLine, saleProductName));
		QuerySaleProductDTO querySaleProductDto = new QuerySaleProductDTO();
		querySaleProductDto.setBusinessLine(businessLine);
		querySaleProductDto.setProductName(saleProductName);
		// 产品类型为大类
		querySaleProductDto.setPage(page);
		querySaleProductDto.setRows(rows);
		List<ProductInfoDTO> list = productService.querySaleProductInfoList(querySaleProductDto);
		logger.info("/querySaleProductInfoList.json - end");
		return list;
	}
	
	// 查询所有产品大类列表
	@RequestMapping(value = "/queryAllSaleProductList.json", method = RequestMethod.GET)
	@ResponseBody
	public List<ProductInfoDTO> queryAllSaleProductList(HttpServletRequest request, HttpServletResponse response) {
		logger.info("/queryAllSaleProductList.do - begin");
		List<ProductInfoDTO> list = productService.queryAllSaleProductList();
		logger.info("/queryAllSaleProductList.do - end");
		return list;
	}

	// 查询产品子类信息列表
	@RequestMapping(value = "/querySubProductList.json", method = RequestMethod.POST)
	@ResponseBody
	public List<SubProductInfoDTO> querySubProductList(QuerySubProductDTO querySubProductDto, HttpServletRequest request) {
		logger.info("/querySubProductList.json - begin");
		String page = request.getParameter("page");
		String rows = request.getParameter("rows");
		querySubProductDto.setPage(page);
		querySubProductDto.setRows(rows);
		List<SubProductInfoDTO> list = productService.querySubProductInfoList(querySubProductDto);
		logger.info("/querySubProductList.json - end");
		return list;
	}
}
