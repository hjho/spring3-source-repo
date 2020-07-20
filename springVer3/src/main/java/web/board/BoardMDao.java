package web.board;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
//@Repository
public class BoardMDao {
	
	Logger logger = LoggerFactory.getLogger(BoardMDao.class);
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate = null;
	
	public int getTotal(Map<String, Object> pMap) {
		logger.info("getTotal 호출 성공");
		int tot = 0;
		tot= sqlSessionTemplate.selectOne("getTotal",pMap);
		logger.info("tot  : "+tot);
		return tot;
	}
	public List<Map<String, Object>> boardList(Map<String, Object> pMap) {
		logger.info("boardList 호출 성공"+pMap.get("bm_no"));
		List<Map<String, Object>> bList = null;
		bList = sqlSessionTemplate.selectList("boardList",pMap);
		logger.info("bList:"+bList.size());
		return bList;
	}
	public  List proc_boardList(Map<String, Object> pMap) {
		logger.info("boardList 호출 성공");
		List<Map<String,Object>> bList = null;
		sqlSessionTemplate.selectOne("proc_boardList",pMap);
		bList = (List<Map<String,Object>>)pMap.get("key");
		logger.info("bList:"+bList.size());
		Iterator iter = bList.iterator();
		while(iter.hasNext()) {
			Map<String,Object> bVO2 = (Map<String,Object>)iter.next();
			logger.info("저자 : "+bVO2.get("BM_WRITER"));
		}
		return bList;
	}
	public int getBmNo(Map<String, Object> pMap) {
		logger.info("getBmNo 호출 성공");
		int bm_no = 0;
		bm_no = sqlSessionTemplate.selectOne("getBmNo",pMap);
		logger.info("bm_no:"+bm_no);
		return bm_no;
	}
	public int getBmGroup(Map<String, Object> pMap) {
		logger.info("getBmGroup호출 성공");
		int bm_group = 0;
		bm_group = sqlSessionTemplate.selectOne("getBmGroup",pMap);
		logger.info("bm_group:"+bm_group);
		return bm_group;
	}

	public int boardMINS(Map<String, Object> pMap) {
		logger.info("boardMINS 호출 성공");
		int result = 0;
		result = sqlSessionTemplate.insert("boardMINS",pMap);
		logger.info("result:"+result);
		sqlSessionTemplate.commit(true);
		return result;
	}
	public int bmStepUpdate(Map<String, Object> pMap) {
		logger.info("bmStepUpdate 호출 성공");
		int result = 0;
		result = sqlSessionTemplate.update("bmStepUpdate",pMap);
		logger.info("result:"+result);
		sqlSessionTemplate.commit(true);
		return result;
	}

	public int boardUPD(Map<String, Object> pMap) {
		logger.info("boardUPD 호출 성공");
		return 0;
	}

	public int boardDEL(Map<String, Object> pMap) {
		logger.info("boardDEL 호출 성공"+pMap.get("bm_no"));
		int result = 0;
		result = sqlSessionTemplate.update("boardDEL",pMap);
		logger.info("result:"+result);
		sqlSessionTemplate.commit(true);
		return result;
	}

}
