package com.loan.pms.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loan.pms.common.dao.CommonDao;
import com.loan.pms.common.dto.DataDictionaryDTO;
import com.loan.pms.common.service.CommonService;

@Service(CommonService.SERVICE_ID)
public class CommonServiceImpl implements CommonService {
	
	@Autowired
	private CommonDao commonDao;
	
	@Override
	public List<DataDictionaryDTO> queryDictionaryCodeItem(String codeNo) {
		// 查询数据字典
		return commonDao.queryDictionaryCodeItem(codeNo);
	}

}
