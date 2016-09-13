package com.xtu.graduation;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * 测试基类
 * @author Xia
 * @since AbstractSpringTest.java 2016年3月29日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback=false)
@Transactional
public abstract class AbstractSpringTest {
	
	@BeforeClass
	public static void setUpBeforeClass()  {
		
	}

	@AfterClass
	public static void tearDownAfterClass()  {
		
	}

}
