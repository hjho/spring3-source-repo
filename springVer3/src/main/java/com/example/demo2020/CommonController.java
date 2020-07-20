package com.example.demo2020;

import java.sql.SQLDataException;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/common/*")
public class CommonController {

	Logger logger = LoggerFactory.getLogger(CommonController.class);
	
	@Autowired
	private CommonLogic commonLogic = null;
	
	@GetMapping("test")
	public String test() {
		return "redirect:test.jsp";
	}
	
	@GetMapping("cudEmp.do")
	public String cudEmp() {
		logger.info("cudEmp 호출 성공");
		int result = 0;
		String error = null;
		try {
			result = commonLogic.cudEmp();
			error = "redirect:empAccount.jsp";
		} catch (DataAccessException de) {
			de.printStackTrace();
			logger.info("SQL EXCEPTION");
			error = "redirect:sqlerror.jsp";
			//throw de;
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("EXCEPTION");
			error = "redirect:error.jsp";
			//throw e;
		}
		return error;
	}
}
