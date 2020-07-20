package com.example.demo2020;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CommonDao {
	Logger logger = LoggerFactory.getLogger(CommonDao.class);
	@Autowired
	SqlSessionTemplate sqlSessionTemplate = null;
	
	
	public String currentTime() {
		logger.info("currentTime 호출 성공");
		String cdate = null;
		cdate = sqlSessionTemplate.selectOne("currentTime");
		return cdate;
	}
	
	public int empINS(Map<String, Object> pMap) throws DataAccessException  {
		logger.info("empINS 호출 성공");
		int result = 0;
		result = sqlSessionTemplate.insert("empINS", pMap);
		return result;
	}

	
}
