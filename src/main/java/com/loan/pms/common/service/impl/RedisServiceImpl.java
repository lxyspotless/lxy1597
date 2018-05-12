package com.loan.pms.common.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.loan.pms.common.service.RedisService;
import com.loan.pms.common.util.CommonFinal;
import com.loan.pms.common.util.CommonUtil;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Service(RedisService.SERVICE_ID)
@SuppressWarnings({ "unchecked", "rawtypes" })
public class RedisServiceImpl implements RedisService {
	
	@Autowired
	private JedisPoolConfig jedisPoolConfig;
	
	@Autowired
	private RedisTemplate redisTemplate;  
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	private static JedisPool jedisPool;
	
	@Value("${redis.host}")
	private String host;

	@Value("${redis.port}")
	private String port;

	@Value("${redis.timeout}")
	private String timeout;

	@Value("${redis.password}")
	private String password;
	
	private static Logger logger = Logger.getLogger(RedisServiceImpl.class);
	
	//--------------------------------------StringRedisTemplate-------------------------------------------
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

	//--------------------------------------JedisPool-------------------------------------------
	@Override
	public JedisPool getJedisPool() {
		if(null == jedisPool){
			jedisPool = new JedisPool(jedisPoolConfig, host, Integer.parseInt(port), Integer.parseInt(timeout), password);
		}
		return jedisPool;
	}

	@Override
	public Boolean setStringToRedis(String key, String value) {
		Jedis jedis = null;
		// 默认失败
		Boolean resultFlag = false;
		try {
			JedisPool jedisPool = getJedisPool();
			jedis = jedisPool.getResource();
			String result = jedis.set(key, value);
			if(CommonFinal.OK.equals(result)){
				// 返回OK则成功
				resultFlag = true;
				logger.info("jedisPool存值成功:"+key+","+value);
			} else {
				logger.info("jedisPool存值失败:"+key+","+value);
			}
		} catch (Exception e) {
			logger.error("jedisPool存值失败:"+key+","+value);
		} finally {
			if(null != jedis){
				jedis.close();
			}
		}
		return resultFlag;
	}

	@Override
	public String getStringFromRedis(String key) {
		Jedis jedis = null;
		// 默认为空
		String resultString = null;
		try {
			JedisPool jedisPool = getJedisPool();
			jedis = jedisPool.getResource();
			resultString = jedis.get(key);
			if(null != resultString){
				// 成功
				logger.info("jedisPool取值成功:"+key+","+resultString);
			} else {
				logger.info("jedisPool取值失败:"+key+","+resultString);
			}
		} catch (Exception e) {
			logger.error("jedisPool取值失败:"+key, e);
		} finally {
			if(null != jedis){
				jedis.close();
			}
		}
		return resultString;
	}

	@Override
	public Boolean setObjectToRedis(String key, Object value) {
		Jedis jedis = null;
		// 默认失败
		Boolean resultFlag = false;
		try {
			JedisPool jedisPool = getJedisPool();
			jedis = jedisPool.getResource();
			String result = jedis.set(key.getBytes(), CommonUtil.serialize(value));
			if(CommonFinal.OK.equals(result)){
				// 返回OK则成功
				resultFlag = true;
				logger.info("jedisPool存值成功:"+key+","+value);
			} else {
				logger.info("jedisPool存值失败:"+key+","+value);
			}
		} catch (Exception e) {
			logger.error("jedisPool存值失败:"+key+","+value);
		} finally {
			if(null != jedis){
				jedis.close();
			}
		}
		return resultFlag;
	}

	@Override
	public Object getObjectFromRedis(String key) {
		Jedis jedis = null;
		// 默认为空
		Object resultObject = null;
		try {
			JedisPool jedisPool = getJedisPool();
			jedis = jedisPool.getResource();
			byte[] in = jedis.get(key.getBytes());
			resultObject = CommonUtil.deserialize(in);
			if(null != resultObject){
				// 成功
				logger.info("jedisPool取值成功:"+key+","+resultObject);
			} else {
				logger.info("jedisPool取值失败:"+key+","+resultObject);
			}
		} catch (Exception e) {
			logger.error("jedisPool取值失败:"+key, e);
		} finally {
			if(null != jedis){
				jedis.close();
			}
		}
		return resultObject;
	}

	@Override
	public boolean isExist(String key) {
		Jedis jedis = null;
		// 默认不存在
		boolean resultFlag = false;
		try {
			JedisPool jedisPool = getJedisPool();
			jedis = jedisPool.getResource();
			resultFlag = jedis.exists(key);
			if(resultFlag){
				// 成功
				logger.info("jedisPool存在该值:"+key);
			} else {
				logger.info("jedisPool不存在该值:"+key);
			}
		} catch (Exception e) {
			logger.error("jedisPool取值失败:"+key, e);
		} finally {
			if(null != jedis){
				jedis.close();
			}
		}
		return resultFlag;
	}

	@Override
	public void deleteKeyFromRedis(String key) {
		Jedis jedis = null;
		try {
			JedisPool jedisPool = getJedisPool();
			jedis = jedisPool.getResource();
			long resultFlag = jedis.del(key);
			if(1 == resultFlag){
				// 成功
				logger.info("jedisPool删除该值成功:"+key);
			} else {
				logger.info("jedisPool删除该值失败:"+key);
			}
		} catch (Exception e) {
			logger.error("jedisPool取值失败:"+key, e);
		} finally {
			if(null != jedis){
				jedis.close();
			}
		}
	}

	@Override
	public void setRedisKeyDie(String key, int seconds) {
		Jedis jedis = null;
		try {
			JedisPool jedisPool = getJedisPool();
			jedis = jedisPool.getResource();
			long resultFlag = jedis.expire(key, seconds);
			if(1 == resultFlag){
				// 成功
				logger.info("jedisPool设置该值失效时间成功:"+key);
			} else {
				logger.info("jedisPool设置该值失效时间失败:"+key);
			}
		} catch (Exception e) {
			logger.error("jedisPool设置该值失效时间失败:"+key, e);
		} finally {
			if(null != jedis){
				jedis.close();
			}
		}
	}

}
