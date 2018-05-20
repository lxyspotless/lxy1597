package com.loan.pms.common.util;

import java.util.List;

public class ListUtil {
	public static <T> boolean isEmpty(List<T> list){
		if(null != list && list.size() > 0){
			return false;
		}else{
			return true;
		}
	}
}
