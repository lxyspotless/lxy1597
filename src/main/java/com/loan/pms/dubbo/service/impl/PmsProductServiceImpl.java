package com.loan.pms.dubbo.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONObject;
import com.loan.pms.common.service.RedisService;
import com.loan.pms.common.util.RedisKeyConstant;
import com.loan.pms.dubbo.service.PmsProductService;
import com.loan.pms.product.service.ProductService;

@Service
public class PmsProductServiceImpl implements PmsProductService {

	@Resource(name = RedisService.SERVICE_ID)
	private RedisService redisService;
	
	@Resource(name = ProductService.SERVICE_ID)
	private ProductService productService;
	
	private static Logger logger = Logger.getLogger(PmsProductServiceImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public JSONObject queryPublishedProductList() {
		JSONObject json = new JSONObject();
		// 先取Redis
		String publishedProductList = redisService.getStringFromRedis(RedisKeyConstant.REDIS_KEY_PUBLISHED_PRODUCT_LIST);
		if(StringUtils.isNotEmpty(publishedProductList)) {
			json = JSONObject.parseObject(publishedProductList);
		} else {
			// Redis为空取数据库
			logger.info(String.format("Redis:%s,为空,取数据库", RedisKeyConstant.REDIS_KEY_PUBLISHED_PRODUCT_LIST));
			Map<String, Object> publishedProductMap = (Map<String, Object>)productService.queryPublishedProductList();
			json = new JSONObject(publishedProductMap);
		}
		logger.info(String.format("queryPublishedProductList返回:%s", json.toJSONString()));
		return json;
	}

}
