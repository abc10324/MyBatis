package com.mybatis;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.mybatis.testsuite.ControllerTest;
import com.mybatis.testsuite.ServiceTest;

//@Ignore
@RunWith(Suite.class)
@SuiteClasses({
	ServiceTest.class,
	ControllerTest.class
})
public class MyBatisApplicationTests {

}
