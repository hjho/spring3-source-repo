package com.example.demo2020;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommonLogic {
	Logger logger = LoggerFactory.getLogger(CommonLogic.class);
	@Autowired
	private CommonDao commonDao = null;
	@Autowired
	private DeptDao deptDao = null;
	
	public String currentTime() {
		logger.info("currentTime 호출 성공");
		String cdate = null;
		cdate = commonDao.currentTime();
		return cdate;
	}
	
	@Transactional(rollbackFor = DataAccessException.class)
	public int cudEmp() throws DataAccessException {
		logger.info("cudEmp 호출 성공");
		int result = 0;
		int r1=0;
		int r2=0;
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("empno", 8000);
		pMap.put("deptno", 90);
		commonDao.empINS(pMap);
		
		Map<String, Object> pMap1 = new HashMap<>();
		pMap1.put("deptno", 910);
		pMap1.put("dname", "COMMON");
		pMap1.put("loc", "GASAN");
		deptDao.deptINS(pMap1);
		return result;
	}
}
