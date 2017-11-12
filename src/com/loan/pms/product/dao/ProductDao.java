package com.loan.pms.product.dao;

import java.util.List;
import java.util.Map;

import com.loan.pms.product.dto.ProductInfoDTO;

public interface ProductDao {
	
	public List<ProductInfoDTO> queryProductInfoList(Map<String, Object> paramMap);
}
