package com.loan.pms.common.util;

import java.util.List;

public class ListUtil {
	/**
	 * 判断List是否为空，为空则返回true
	 * @param list
	 * @return boolean
	 */
	public static <T> boolean isEmpty(List<T> list){
		boolean resultFlag = true;
		if(null != list && list.size() > 0){
			resultFlag = false;
		}
		return resultFlag;
	}
	
	/**
	 * 判断List是否不为空，不为空则返回true
	 * @param list
	 * @return boolean
	 */
	public static <T> boolean isNotEmpty(List<T> list){
		boolean resultFlag = false;
		if(null != list && list.size() > 0){
			resultFlag = true;
		}
		return resultFlag;
	}
}
