package com.loan.pms.dubbo.service;

import com.alibaba.fastjson.JSONObject;

public interface PmsProductService {
	
	public String SERVICE_ID = "pms.dubbo.product.pmsProductService";
	
	/**
	 * 查询所有已发布产品信息
	 * @return List<SubProductInfoRedisDTO>
	 */
	public JSONObject queryPublishedProductList();
	
}
