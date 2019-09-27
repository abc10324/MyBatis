package com.mybatis.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mybatis.model.UsersBean;

@Mapper
public interface UsersDao extends BaseMapper<UsersBean> {
	public UsersBean selectByUId(String userId);
	public UsersBean selectByName(String name);
	public UsersBean selectByColumn(@Param("column") String column,@Param("value") String value);
	public List<String> selectLikeName(String name);
}
