package com.mybatis.testsuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.mybatis.controller.MockControllerTest;
import com.mybatis.controller.RealControllerTest;

@RunWith(Suite.class)
@SuiteClasses({
	MockControllerTest.class,
	RealControllerTest.class
})
public class ControllerTest {
	
}
