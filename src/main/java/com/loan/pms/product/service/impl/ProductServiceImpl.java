package com.loan.pms.product.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.loan.pms.common.service.RedisService;
import com.loan.pms.common.util.ListUtil;
import com.loan.pms.common.util.RedisKeyFinal;
import com.loan.pms.product.dao.ProductDao;
import com.loan.pms.product.dto.ProductInfoDTO;
import com.loan.pms.product.dto.QuerySaleProductDTO;
import com.loan.pms.product.dto.QuerySubProductDTO;
import com.loan.pms.product.dto.SubProductInfoDTO;
import com.loan.pms.product.dto.SubProductRedisInfoDTO;
import com.loan.pms.product.service.ProductService;

@Service(ProductService.SERVICE_ID)
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	@Resource(name = RedisService.SERVICE_ID)
	public RedisService redisService;
	
	private static Logger logger = Logger.getLogger(ProductServiceImpl.class);

	@Override
	public List<ProductInfoDTO> querySaleProductInfoList(QuerySaleProductDTO querySaleProductDto) {
		List<ProductInfoDTO> list = productDao.querySaleProductInfoList(querySaleProductDto);
		if(!ListUtil.isEmpty(list)) {
			logger.info("查询产品大类条数:" + list.size());
		} else {
			logger.info("查询产品大类为空");
		}
		return list;
	}

	@Override
	public List<ProductInfoDTO> queryAllSaleProductList() {
		List<ProductInfoDTO> list = productDao.queryAllSaleProductList();
		if(!ListUtil.isEmpty(list)) {
			logger.info("查询所有产品大类条数:" + list.size());
		} else {
			logger.info("查询所有产品大类为空");
		}
		return list;
	}

	@Override
	public List<SubProductInfoDTO> querySubProductInfoList(QuerySubProductDTO querySubProductDto) {
		List<SubProductInfoDTO> list = productDao.querySubProductInfoList(querySubProductDto);
		if(!ListUtil.isEmpty(list)) {
			logger.info("查询产品子类条数:" + list.size());
		} else {
			logger.info("查询产品子类为空");
		}
		return list;
	}

	@Override
	public Map<String, ? extends Object> queryPublishedProductList() {
		List<SubProductRedisInfoDTO> productList = productDao.queryPublishedProductList();
		Map<String, List<SubProductRedisInfoDTO>> resultMap = new HashMap<String, List<SubProductRedisInfoDTO>>();
		if(!ListUtil.isEmpty(productList)) {
			logger.info("查询产品子类条数:" + productList.size());
			for(SubProductRedisInfoDTO productDto : productList) {
				List<SubProductRedisInfoDTO> listDto = resultMap.get(productDto.getParentProductNo());
				if(ListUtil.isEmpty(listDto)) {
					listDto = new ArrayList<SubProductRedisInfoDTO>();
					resultMap.put(productDto.getParentProductNo(), listDto);
				}
				listDto.add(productDto);
			}
		} else {
			logger.info("查询产品子类为空");
		}
		return resultMap;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void putPublishedProductListToRedis() {
		Map<String, Object> redisMap = (Map<String, Object>)queryPublishedProductList();
		JSONObject json = new JSONObject(redisMap);
		redisService.setStringToRedis(RedisKeyFinal.REDIS_KEY_PUBLISHED_PRODUCT_LIST, json.toJSONString());
	}

}
