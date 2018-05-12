package com.loan.pms.common.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.log4j.Logger;

import com.loan.pms.common.service.impl.RedisServiceImpl;

public class CommonUtil {

	private static Logger logger = Logger.getLogger(RedisServiceImpl.class);
	
	/**
	 * 序列化对象
	 * @param value
	 * @return
	 */
	public static byte[] serialize(Object object){
		if(null == object){
			logger.error("can't serialize null");
			return null;
		}
		byte[] resultByte = null;
		ByteArrayOutputStream bos = null;
		ObjectOutputStream oos = null;
		try {
			bos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(bos);
			oos.writeObject(object);
			oos.close();
			bos.close();
			resultByte = bos.toByteArray();
		} catch (Exception e) {
			logger.error("unable serialize object"+object, e);
		} finally {
			try {
				bos.close();
				oos.close();
			} catch (IOException e) {
				logger.error("unable to close", e);
			}
		}
		return resultByte;
	}
	
	public static Object deserialize(byte[] in){
		if(null == in){
			logger.error("can't deserialize null");
			return null;
		}
		Object resultObject = null;
		ByteArrayInputStream bis = null;
		ObjectInputStream ois = null;
		try {
			bis = new ByteArrayInputStream(in);
			ois = new ObjectInputStream(bis);
			resultObject = ois.readObject();
		} catch (Exception e) {
			logger.error("unable deserialize object:"+in, e);
		} finally {
			try {
				bis.close();
				ois.close();
			} catch (IOException e) {
				logger.error("unable to close", e);
			}
		}
		return resultObject;
	}
}
