package com.loan.pms.product.dao;

import java.util.List;

import com.loan.pms.product.dto.ProductInfoDTO;
import com.loan.pms.product.dto.QuerySaleProductDTO;
import com.loan.pms.product.dto.QuerySubProductDTO;
import com.loan.pms.product.dto.SubProductInfoDTO;

public interface ProductDao {
	
	/**
	 * 查询产品大类信息列表
	 * @param querySaleProductDto
	 * @return List<ProductInfoDTO>
	 */
	public List<ProductInfoDTO> querySaleProductInfoList(QuerySaleProductDTO querySaleProductDto);
	
	/**
	 * 查询所有产品大类信息列表
	 * @return List<ProductInfoDTO>
	 */
	public List<ProductInfoDTO> queryAllSaleProductList();

	/**
	 * 查询所有产品子类信息列表
	 * @return List<SubProductInfoDTO>
	 */
	public List<SubProductInfoDTO> querySubProductInfoList(QuerySubProductDTO querySubProductDTO);
}
