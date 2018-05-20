package com.loan.pms.product.listener;

import javax.annotation.Resource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.loan.pms.product.service.ProductService;

@Component
public class ProductListener implements InitializingBean {
	
	@Resource(name = ProductService.SERVICE_ID)
	public ProductService productService;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		productService.putPublishedProductListToRedis();
	}

}
