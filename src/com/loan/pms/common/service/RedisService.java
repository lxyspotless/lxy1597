package com.loan.pms.common.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.JedisPool;

public interface RedisService {
	
	public String SERVICE_ID = "pms.common.redisService";
	
	//--------------------------------------StringRedisTemplate-------------------------------------------
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

    //--------------------------------------JedisPool-------------------------------------------
    /**
     * 获取Jedis连接池，线程安全
     * @return JedisPool
     */
    public JedisPool getJedisPool();
    
    /**
     * jedisPool存值String-String，线程安全
     * @param key
     * @param value
     * @return
     */
    public Boolean setStringToRedis(String key, String value);
    
    /**
     * jedisPool获取String值，线程安全
     * @param key
     * @return
     */
    public String getStringFromRedis(String key);

    /**
     * jedisPool存值String-Object，线程安全
     * @param key
     * @param value
     * @return
     */
    public Boolean setObjectToRedis(String key, Object value);
    
    /**
     * jedisPool获取Object值，线程安全
     * @param key
     * @return
     */
    public Object getObjectFromRedis(String key);
    
    /**
     * 是否存在key(jedis)，线程安全
     * @param key
     * @return
     */
    public boolean isExist(String key);
    
    /**
     * 删除key(jedis)，线程安全
     * @param key
     */
    public void deleteKeyFromRedis(String key);
    
    /**
     * 设置key失效时间(jedis)，线程安全
     * @param key
     */
    public void setRedisKeyDie(String key, int seconds);
    
}
