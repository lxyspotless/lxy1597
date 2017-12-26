package com.loan.pms.product.listener;

import javax.annotation.Resource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.loan.pms.common.service.RedisService;
import com.loan.pms.common.util.RedisTemplateUtil;
import com.loan.pms.common.util.SpringContextUtil;

@Component
public class ProductListener implements InitializingBean {
	
	@Resource(name = RedisService.SERVICE_ID)
	public RedisService redisService;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		redisService.setString("PH1000100010001", "O2Oloan12345");
	}

}
