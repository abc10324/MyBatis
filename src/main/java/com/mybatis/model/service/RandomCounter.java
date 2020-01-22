package com.mybatis.model.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomCounter {
	
	public static void main(String[] args) {
		Integer range = 100;
		Integer totalCount = 100000;
		
		List<Map<String,Integer>> resultList = genRandomNumList(range, totalCount);
		resultList.sort((e1,e2) -> e1.get("count") - e2.get("count"));
		
		System.out.printf("%3s  |%6s\n","No","Count");
		System.out.println("------------");
		for(Map<String,Integer> numPair : resultList) {
			System.out.printf("%3d  |%6d\n",numPair.get("index"),numPair.get("count"));
		}
	}
	
	private static List<Map<String,Integer>> genRandomNumList(Integer range,Integer totalCount){
		if(range == null || range < 1 || totalCount == null)
			return Collections.emptyList();
		
		List<Map<String,Integer>> result = new ArrayList<Map<String,Integer>>();
		
		for(int i=0 ; i<range ; i++) {
			Map<String,Integer> numPair = new HashMap<String, Integer>();
			numPair.put("index", i + 1);
			numPair.put("count", 0);
			
			result.add(numPair);
		}
		
		for(int i=0 ; i<totalCount ; i++) {
			Integer randomNum = (int)(Math.random() * range);
			
			Integer count = result.get(randomNum).get("count");
			result.get(randomNum).put("count", ++count);
		}
		
		return result;
	}
	
}
