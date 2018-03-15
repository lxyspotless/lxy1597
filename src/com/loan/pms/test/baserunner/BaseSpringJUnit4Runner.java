package com.loan.pms.test.baserunner;

import java.io.FileNotFoundException;

import org.junit.runners.model.InitializationError;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Log4jConfigurer;

@SuppressWarnings("deprecation")
public class BaseSpringJUnit4Runner extends SpringJUnit4ClassRunner{

    public BaseSpringJUnit4Runner(Class<?> clazz) throws InitializationError {
		super(clazz);
	}
    
	static {
        try {
            Log4jConfigurer.initLogging("classpath:properties/log4j.properties");
        } catch (FileNotFoundException ex) {
            System.err.println("Cannot Initialize log4j");
        }
    }
}
