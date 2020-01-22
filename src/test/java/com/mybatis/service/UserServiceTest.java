package com.mybatis.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doReturn;

import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.mybatis.model.UsersBean;
import com.mybatis.model.dao.UsersDao;
import com.mybatis.model.service.UserService;

@RunWith(SpringRunner.class)
public class UserServiceTest {
	
	@TestConfiguration
	static class UserServiceTestConfig {
		
		@Bean
		public UserService userService() {
			return new UserService();
		}
		
	}
	
	@MockBean
	private UsersDao usersDao;
	
	@Autowired
	private UserService userService;
	
//	@Ignore
	@Test
	public void test() {
		doReturn(null).when(usersDao).selectByUId(Mockito.any());
		doReturn(null).when(usersDao).selectByName(Mockito.any());
		doReturn(1).when(usersDao).insert(Mockito.any());
		
		UsersBean user = new UsersBean();
		user.setUserID("abc10324");
		user.setPwd("abc9814016");
		user.setUserName("Sam");
		
		Map<String,String> resultMap = userService.regist(user);
	
		assertThat(resultMap.get("userId")).isEqualTo(user.getUserID());
		assertThat(resultMap.get("userName")).isEqualTo(user.getUserName());
	}
	
	
}
