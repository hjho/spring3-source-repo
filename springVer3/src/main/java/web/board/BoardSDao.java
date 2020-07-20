package web.board;
/*
 * SqlSessionFactory - myBatis-3.4.6.jar - POJP
 * SqlSession 
 * SqlSessionFactoryBean - myBatis-spring2.0.5.jar - Spring
 * SqlSessionTemplate -객체주입 받아야 함.
 * 
 * 
 */
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardSDao {
	Logger logger = LoggerFactory.getLogger(BoardSDao.class);
	@Autowired
	SqlSessionTemplate sqlSessionTemplate = null;
	public int boardSINS(Map<String, Object> pMap) {
		logger.info("boardSINS 호출 성공");
		int result = 0;
		//bm_no, bs_seq - 상수,  bs_file, bs_size -Logic
		result = sqlSessionTemplate.insert("boardSINS",pMap);
		logger.info("result:"+result);
		sqlSessionTemplate.commit(true);		
		return result;
	}

}
