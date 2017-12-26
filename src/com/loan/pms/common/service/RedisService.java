package com.loan.pms.common.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface RedisService {
	
	public String SERVICE_ID = "pms.common.redisService";
	
	/**
	 * 存入String-String
	 * @param key
	 * @param value
	 */
    public void setString(String key, String value);
    
    /**
     * 取String
     * @param key
     * @return
     */
    public String getString(String key);
    
    /**
     * 存String-Object
     * @param key
     * @param value
     */
    public void setObject(String key, Object value);
    
    /**
     * 取Object对象
     * @param key
     * @return
     */
    public Object getObject(String key);
    
    /**
     * 存String-List
     * @param key
     * @param value
     */
    public void setList(String key, List<?> value);
    
    /**
     * 取List对象
     * @param key
     * @return
     */
    public Object getList(String key);
    
    /**
     * 存String-Set
     * @param key
     * @param value
     */
    public void setSet(String key, Set<?> value);
    
    /**
     * 取Set对象
     * @param key
     * @return
     */
    public Object getSet(String key);
    
    /**
     * 存String-Map
     * @param key
     * @param value
     */
    public void setHash(String key, Map<String, ?> value);
    
    /**
     * 取Hash对象
     * @param key
     * @return
     */
    public Object getHash(String key);
    
    /**
     * 删除key
     * @param key
     */
    public void delete(String key);
}
