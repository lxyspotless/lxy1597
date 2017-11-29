package com.loan.pms.common.web.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.loan.pms.common.dto.DataDictionaryDTO;
import com.loan.pms.common.service.CommonService;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

@Controller
public class CommonController {
	
	private static Logger logger = Logger.getLogger(CommonController.class);
	
	@Resource(name = CommonService.SERVICE_ID)
	private CommonService commonService;
	
	@RequestMapping(value = "/queryDictionaryCodeItem.json", method = RequestMethod.GET)
	@ResponseBody
	public List<DataDictionaryDTO> queryDictionaryCodeItem(HttpServletRequest request, HttpServletResponse response){
		String codeNo = request.getParameter("codeNo");
		List<DataDictionaryDTO> resultList = new ArrayList<DataDictionaryDTO>();
		logger.info("查询数据字典类型:" + codeNo);
		if(!StringUtils.isEmpty(codeNo)) {
			resultList = commonService.queryDictionaryCodeItem(codeNo);
		}
		return resultList;
	}
}
