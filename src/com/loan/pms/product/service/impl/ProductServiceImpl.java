package com.loan.pms.product.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loan.pms.product.dao.ProductDao;
import com.loan.pms.product.dto.ProductInfoDTO;
import com.loan.pms.product.service.ProductService;

@Service(ProductService.SERVICE_ID)
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	private static Logger logger = Logger.getLogger(ProductServiceImpl.class);

	@Override
	public List<ProductInfoDTO> queryProductInfoList(String businessLine, String saleProductName) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("businessLine", businessLine);
		paramMap.put("productType", "MAIN");
		paramMap.put("productName", saleProductName);
		List<ProductInfoDTO> list = productDao.queryProductInfoList(paramMap);
		logger.info("查询销售产品条数:" + list.size());
		return list;
	}
	
}
