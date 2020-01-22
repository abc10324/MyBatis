package com.mybatis.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.mybatis.model.UsersBean;
import com.mybatis.model.service.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(MyBatisController.class)
public class MockControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserService userService;
	
	@Test
	public void regist() throws Exception {
		Map<String,String> result = new HashMap<>();
		result.put("userId", "abc10324");
		result.put("userName", "Sam");
		
		JSONObject jsonObj = (JSONObject) JSONObject.wrap(result);
		jsonObj.put("pwd", "abc9814016");
		
		UsersBean user = new UsersBean();
		user.setUserID(jsonObj.getString("userId"));
		user.setUserName(jsonObj.getString("userName"));
		user.setPwd(jsonObj.getString("pwd"));
		
		doReturn(result).when(userService).regist(Mockito.any());
		
		mockMvc.perform(post("/api/user")
					   .contentType(MediaType.APPLICATION_JSON)
					   .content(jsonObj.toString()))
   			   .andExpect(status().isOk())
   			   .andExpect(jsonPath("$.userId",is(equalTo(result.get("userId")))))
   			   .andExpect(jsonPath("$.userName",is(equalTo(result.get("userName")))));
	}
	
	@Test
	public void test() throws Exception {
		mockMvc.perform(get("/"))
			   .andExpect(status().isOk())
			   .andExpect(jsonPath("$.status",is(equalTo("success"))));
	}
	
}
