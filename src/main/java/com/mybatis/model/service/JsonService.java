package com.mybatis.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.mybatis.model.JsonTable;
import com.mybatis.model.dao.JsonDao;

@Service
public class JsonService {

	@Autowired
	private JsonDao repo;

	public List<JsonTable> findByName(String name){
		List<JsonTable> resultList = repo.findByName(name);
		
		for(JsonTable json : resultList) {
			json.parseJsonCol();
		}
		
		return resultList;
	}
	
	public List<JsonTable> findByNames(List<String> names){
		List<JsonTable> resultList = repo.findByNames(names);
		
		for(JsonTable json : resultList) {
			json.parseJsonCol();
		}
		
		return resultList;
	}
	
	public List<JsonTable> findByTag(List<String> tag){
		List<JsonTable> resultList = repo.findByTag((new Gson()).toJson(tag));
		
		for(JsonTable json : resultList) {
			json.parseJsonCol();
		}
		
		return resultList;
	}
	
	public List<JsonTable> findAll(){
		List<JsonTable> resultList = repo.findAll();
		
		for(JsonTable json : resultList) {
			json.parseJsonCol();
		}
		
		return resultList;
	}
	
	public void insert(JsonTable jsonTable) {
		jsonTable.genJsonCol();
		repo.insert(jsonTable);
	}
	
	public void update(JsonTable jsonTable) {
		jsonTable.genJsonCol();
		jsonTable.updateById();
	}
	
	public boolean exist(Integer id) {
		return repo.selectById(id) != null;
	}
	
	
}
