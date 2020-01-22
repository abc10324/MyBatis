package com.mybatis.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mybatis.model.UsersBean;

@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Transactional
public class RealControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void regist() throws Exception {
		Map<String,String> result = new HashMap<>();
		result.put("userId", "abc999999");
		result.put("userName", "Sammy.J");
		
		JSONObject jsonObj = (JSONObject) JSONObject.wrap(result);
		jsonObj.put("pwd", "abc9814016");
		
		UsersBean user = new UsersBean();
		user.setUserID(jsonObj.getString("userId"));
		user.setUserName(jsonObj.getString("userName"));
		user.setPwd(jsonObj.getString("pwd"));
		
		HttpEntity httpEntity = new HttpEntity<String>(jsonObj.toString());
		
		String serverResult = restTemplate.exchange("/api/user", HttpMethod.POST, httpEntity, String.class).getBody();
		
		Map<String,String> resultMap = (new Gson()).fromJson(serverResult, new TypeToken<Map<String,String>>(){}.getType());
		assertThat(resultMap.get("userId")).isEqualTo(user.getUserID());
		assertThat(resultMap.get("userName")).isEqualTo(user.getUserName());
//		mockMvc.perform(post("/api/user")
//					   .contentType(MediaType.APPLICATION_JSON)
//					   .content(jsonObj.toString()))
//   			   .andExpect(status().isOk())
//   			   .andExpect(jsonPath("$.userId",is(equalTo(result.get("userId")))))
//   			   .andExpect(jsonPath("$.userName",is(equalTo(result.get("userName")))));
	}
	
}
