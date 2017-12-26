package com.loan.pms.common.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.loan.pms.common.service.RedisService;

@Service(RedisService.SERVICE_ID)
@SuppressWarnings({ "unchecked", "rawtypes" })
public class RedisServiceImpl implements RedisService {
	
	@Autowired
	private RedisTemplate redisTemplate;  
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;  
	
	@Override
	public void setString(String key, String value) {
		ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        valueOperations.set(key, value);
	}

	@Override
	public String getString(String key) {
		return stringRedisTemplate.opsForValue().get(key);
	}

	@Override
	public void setObject(String key, Object value) {
		ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key, value);
	}

	@Override
	public Object getObject(String key) {
		return redisTemplate.opsForValue().get(key);
	}

	@Override
	public void setList(String key, List<?> value) {
		ListOperations listOperations = redisTemplate.opsForList();
        listOperations.leftPush(key, value);
	}

	@Override
	public Object getList(String key) {
		return redisTemplate.opsForList().leftPop(key);
	}

	@Override
	public void setSet(String key, Set<?> value) {
		SetOperations setOperations = redisTemplate.opsForSet();
        setOperations.add(key, value);
	}

	@Override
	public Object getSet(String key) {
		return redisTemplate.opsForSet().members(key);
	}

	@Override
	public void setHash(String key, Map<String, ?> value) {
		HashOperations hashOperations = redisTemplate.opsForHash();
        hashOperations.putAll(key, value);
	}

	@Override
	public Object getHash(String key) {
		return redisTemplate.opsForHash().entries(key);
	}

	@Override
	public void delete(String key) {
		redisTemplate.delete(key);
	}

}
