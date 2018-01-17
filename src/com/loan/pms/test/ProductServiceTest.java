package com.loan.pms.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.loan.pms.product.dao.ProductDao;
import com.loan.pms.product.dto.ProductInfoDTO;
import com.loan.pms.test.base.BaseSpringJunit4RunnerTest;

public class ProductServiceTest extends BaseSpringJunit4RunnerTest {

	@Autowired
	private ProductDao productDao;
	
	@Test   //标明是测试方法  
	@Transactional   //标明此方法需使用事务  
	@Rollback(false)  //标明使用完此方法后事务不回滚,true时为回滚
	public void queryAllSaleProductListTest() {
		List<ProductInfoDTO> list = productDao.queryAllSaleProductList();
		System.out.println(list.size());
	}
}
