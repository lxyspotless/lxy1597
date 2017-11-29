package com.loan.pms.product.dao;

import java.util.List;

import com.loan.pms.product.dto.ProductInfoDTO;
import com.loan.pms.product.dto.QuerySaleProductDTO;

public interface ProductDao {
	
	public List<ProductInfoDTO> queryProductInfoList(QuerySaleProductDTO querySaleProductDto);
}
