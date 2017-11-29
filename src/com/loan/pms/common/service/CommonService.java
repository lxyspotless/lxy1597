package com.loan.pms.common.service;

import java.util.List;

import com.loan.pms.common.dto.DataDictionaryDTO;

public interface CommonService {
	
	public String SERVICE_ID = "pms.common.commonService";
	/**
	 * 查询数据字典下该codeNo所有数据
	 * @param codeNo
	 * @return List<Map<String,Object>>
	 */
	public List<DataDictionaryDTO> queryDictionaryCodeItem(String codeNo);
}
