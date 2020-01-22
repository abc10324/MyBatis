package com.mybatis.testsuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.mybatis.service.UserServiceTest;

@RunWith(Suite.class)
@SuiteClasses({
	UserServiceTest.class
})
public class ServiceTest {

}
