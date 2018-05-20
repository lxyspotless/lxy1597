package com.loan.pms.common.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loan.pms.common.dao.CommonDao;
import com.loan.pms.common.dto.DataDictionaryDTO;
import com.loan.pms.common.service.CommonService;
import com.loan.pms.common.util.ListUtil;

@Service(CommonService.SERVICE_ID)
public class CommonServiceImpl implements CommonService {
	
	private static Map<String, List<DataDictionaryDTO>> dataDictionaryMap = new HashMap<String, List<DataDictionaryDTO>>();
	
	@Autowired
	private CommonDao commonDao;

	@Override
	public List<String> queryDictionaryCode() {
		// 查询数据字典下所有codeNo
		return commonDao.queryDictionaryCode();
	}
	
	@Override
	public List<DataDictionaryDTO> queryDictionaryCodeItem(String codeNo) {
		// 查询数据字典，优先取内存
		if(dataDictionaryMap.containsKey(codeNo)){
			return dataDictionaryMap.get(codeNo);
		}else{
			return commonDao.queryDictionaryCodeItem(codeNo);
		}
	}

	@Override
	public void refreshDataDictionaryMemory() {
		List<String> list = queryDictionaryCode();
		if(!ListUtil.isEmpty(list)){
			for(String codeNo : list){
				dataDictionaryMap.put(codeNo, commonDao.queryDictionaryCodeItem(codeNo));
			}
		}
	}
}
