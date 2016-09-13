package com.xtu.graduation.common.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * ApplicationContextUtil  工具类，用于获得 Spring框架的应用上下文对象
 * @author Xia
 * @since ApplicationContextUtil.java 2016年3月30日
 */
public abstract class ApplicationContextUtil {
	
    /** Spring框架应用上下文对象 */  
    private static ApplicationContext factory = getApplicationContext();  
      
    static{  
        getApplicationContext();  
    }  
      
    public static void setFactoryBean(ApplicationContext factory){  
    	ApplicationContextUtil.factory = factory;  
    }  
    /** 
     * 获得Spring框架应用上下文对象  
     * @return ApplicationContext 
     */  
    public static ApplicationContext getApplicationContext()  
    {  
        //判断如果 ApplicationContext 的对象 ＝＝ NULL  
        if ( factory == null )  
        {  
            try  
            {  
                factory = new ClassPathXmlApplicationContext(new String[]{"classpath:applicationContext.xml"});  
            }  
            catch ( Exception e1 )  
            {  
                e1.printStackTrace();  
            }  
        }  
        //返回ApplicationContext  
        return factory;  
    }  
}
