package com.loan.pms.product.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loan.pms.product.dao.ProductDao;
import com.loan.pms.product.dto.ProductInfoDTO;
import com.loan.pms.product.dto.QuerySaleProductDTO;
import com.loan.pms.product.service.ProductService;

@Service(ProductService.SERVICE_ID)
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	private static Logger logger = Logger.getLogger(ProductServiceImpl.class);

	@Override
	public List<ProductInfoDTO> queryProductInfoList(QuerySaleProductDTO querySaleProductDto) {
		List<ProductInfoDTO> list = productDao.queryProductInfoList(querySaleProductDto);
		logger.info("查询产品大类条数:" + list.size());
		return list;
	}
	
}
