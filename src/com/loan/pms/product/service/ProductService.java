package com.loan.pms.product.service;

import java.util.List;

import com.loan.pms.product.dto.ProductInfoDTO;
import com.loan.pms.product.dto.QuerySaleProductDTO;
import com.loan.pms.product.dto.QuerySubProductDTO;
import com.loan.pms.product.dto.SubProductInfoDTO;

public interface ProductService {
	
	public String SERVICE_ID = "pms.product.productService";
	
	/**
	 * 查询产品大类信息列表
	 * @param businessLine
	 * @return saleProductName
	 * @return List<ProductInfoDTO>
	 */
	public List<ProductInfoDTO> querySaleProductInfoList(QuerySaleProductDTO querySaleProductDto);
	
	/**
	 * 查询所有产品大类信息列表
	 * @return List<ProductInfoDTO>
	 */
	public List<ProductInfoDTO> queryAllSaleProductList();
	
	/**
	 * 
	 * @param querySubProductDto
	 * @return List<SubProductInfoDTO>
	 */
	public List<SubProductInfoDTO> querySubProductInfoList(QuerySubProductDTO querySubProductDto);
}
