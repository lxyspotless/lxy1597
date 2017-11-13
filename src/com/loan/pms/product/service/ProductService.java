package com.loan.pms.product.service;

import java.util.List;

import com.loan.pms.product.dto.ProductInfoDTO;

public interface ProductService {
	
	public String SERVICE_ID = "pms.product.productService";
	
	/**
	 * 查询产品大类或子类信息列表
	 * @param businessLine
	 * @return saleProductName
	 * @return List<ProductInfoDTO>
	 */
	public List<ProductInfoDTO> queryProductInfoList(String businessLine, String saleProductName);
	
}
