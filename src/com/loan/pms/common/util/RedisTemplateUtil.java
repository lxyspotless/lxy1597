package com.loan.pms.common.util;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;

@Component
public class RedisTemplateUtil {
	
	@Autowired
	private RedisTemplate redisTemplate;  
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;  
	
    // 对String操作
    public void setString(String key, String value) {
        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        valueOperations.set(key, value);
    }

    public String getString(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }
    
    // 默认对对象操作
    public Object getObject(String key) {
        return redisTemplate.opsForValue().get(key);
    }
    public void setObject(String key, Object value) {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key, value);
    }
    
    // List
    public void setList(String key, List<?> value) {
        ListOperations listOperations = redisTemplate.opsForList();
        listOperations.leftPush(key, value);
    }
    
    public Object getList(String key) {
        return redisTemplate.opsForList().leftPop(key);
    }
    
    // Set
    public void setSet(String key, Set<?> value) {
        SetOperations setOperations = redisTemplate.opsForSet();
        setOperations.add(key, value);
    }
    
    public Object getSet(String key) {
        return redisTemplate.opsForSet().members(key);
    }
    
    // Hash
    public void setHash(String key, Map<String, ?> value) {
        HashOperations hashOperations = redisTemplate.opsForHash();
        hashOperations.putAll(key, value);
    }
    
    public Object getHash(String key) {
        return redisTemplate.opsForHash().entries(key);
    }
    
    // delete key
    public void delete(String key) {
        redisTemplate.delete(key);
    }
}
