package com.example.demo2020;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
//ajax, 카카오맵, 카카오서비스, 리액트, google chart
@RestController
@RequestMapping(value="/common/*",produces="text/plain;charset=UTF-8")
public class RestCommonController {
	Logger logger = LoggerFactory.getLogger(RestCommonController.class);
	@Autowired
	private CommonLogic commonLogic = null;
	@GetMapping("restTest")
	public String restTest() {
		return "테스트 페이지 입니다.";
	}
	@GetMapping("currentTime")
	public String currentTime() {
		logger.info("currentTime 호출 성공");
		String ctime = null;
		ctime = commonLogic.currentTime();
		return ctime;
	}
	@GetMapping("jsonResult")
	public String jsonResult() {
		List<Map<String,Object>> imsi = new ArrayList<>();
		Map<String,Object> rmap = new HashMap<>();
		rmap.put("mem_no", 123);
		rmap.put("mem_name", "김유신");
		imsi.add(rmap);
		rmap = new HashMap<>();
		rmap.put("mem_no", 124);
		rmap.put("mem_name", "이성계");
		imsi.add(rmap);
		Gson g = new Gson();
		String temp = g.toJson(imsi);
		return temp;
	}
}
