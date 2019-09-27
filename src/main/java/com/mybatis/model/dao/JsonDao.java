package com.mybatis.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mybatis.model.JsonTable;

@Mapper
public interface JsonDao extends BaseMapper<JsonTable> {
	
	public List<JsonTable> findByName(String name);
	public List<JsonTable> findByNames(@Param("names") List<String> names);
	public List<JsonTable> findByTag(String tag);
	public List<JsonTable> findAll();
	
}
