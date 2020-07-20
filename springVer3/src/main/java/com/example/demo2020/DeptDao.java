package com.example.demo2020;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class DeptDao {

	Logger logger = LoggerFactory.getLogger(DeptDao.class);
	@Autowired
	SqlSessionTemplate sqlSessionTemplate = null;
	
	public int deptINS(Map<String, Object> pMap) throws DataAccessException {
		logger.info("deptINS 호출 성공");
		int result = 0;
		result = sqlSessionTemplate.insert("deptINS", pMap);
		return result;
	}
}
