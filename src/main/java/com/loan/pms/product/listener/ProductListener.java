package com.loan.pms.product.listener;

import javax.annotation.Resource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.loan.pms.common.service.RedisService;

@Component
public class ProductListener implements InitializingBean {
	
	@Resource(name = RedisService.SERVICE_ID)
	public RedisService redisService;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		redisService.setStringToRedis("PH1000100010001", "O2Oloan123");
	}

}
