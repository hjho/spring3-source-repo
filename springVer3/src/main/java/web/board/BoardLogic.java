package web.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/*
 * 왜 로직과 DAO패턴에는 메소드 이름앞에 어노테이션이 없나요..
 * 의존적인 것은 Controller이면 된다.
 * 클래스의 의존관계는 Service로 해결 되었다.
 */
@Service
public class BoardLogic {
	
	Logger logger = LoggerFactory.getLogger(BoardLogic.class);
	
	@Autowired(required=false)
	private BoardMDao bmDao = null;	
	@Autowired(required=false)
	private BoardSDao bsDao = null;

	
	public List<Map<String, Object>> boardList(Map<String, Object> pMap) {
		logger.info("boardList 호출 성공");
		List<Map<String, Object>> bList = new ArrayList<>();
		bList = bmDao.boardList(pMap);
		return bList;
	}
	
	public List proc_boardList(Map<String, Object> pMap) {
		logger.info("proc_boardList 호출 성공");
		List bList = null;		
		bList = bmDao.proc_boardList(pMap);
		logger.info("bList ==>"+bList);
		return bList;
	}
	//난이도 : 상, 1차목표, 2차목표, 3차목표
	//트랜잭션처리에 대한 부분 - 프로시저로 해보면 좋겠다.-금융,보험,물류,회계
	//첨부파일 처리
	//위젯 API 구현해 본다.- 스타트업,1인기업, 소규모
	//공통코드 작성 - PL - 공통팀, 형상관리팀, 품질관리팀, 개발팀, 관리팀, 테스트
	public int boardINS(Map<String, Object> pMap) {
		logger.info("boardINS 호출 성공");
		int result = 0;
		int bm_no = 0;
		bm_no = bmDao.getBmNo(pMap);
		
		int bm_group = 0;
		//그룹번호가 있나요?
		//어디서 오셨죠? list.jsp이면 없다, read.jsp 이면 있다.
		bm_group = bmDao.getBmGroup(pMap);
		//예외처리 추가할것. - io사용시 꼭 필요 - 첨부파일
		int pbm_no = 0;
		if(pMap.get("bm_no")!=null) {
			pbm_no = Integer.parseInt(pMap.get("bm_no").toString());
			
		}
		try {
			//새글인가? 
//			if(!pMap.containsKey("bm_no")) {
			if(pbm_no==0) {
				//logger.info("새글인가? ==> "+pMap.get("bm_group"));
				pMap.put("bm_no",bm_no);
				//새글이면 그룹번호를 새로 채번해야 합니다.
				pMap.put("bm_group",bm_group);
				pMap.put("bm_pos",0);
				pMap.put("bm_step",0);
			}
			//아님 댓글이야?
			else {
				//logger.info("댓글인가? ==> "+pMap.get("bm_group"));
				bmDao.bmStepUpdate(pMap);
				if(pMap.get("bm_pos")!=null) {
					pMap.put("bm_pos"
							,Integer.parseInt(pMap.get("bm_pos").toString())+1);
				}
				if(pMap.get("bm_step")!=null) {
					pMap.put("bm_step"
							,Integer.parseInt(pMap.get("bm_step").toString())+1);
				}
			}
			//첨부파일이 있을까요?
			if(pMap.get("bs_file")!=null && pMap.get("bs_file").toString().length()>=1) {
				logger.info("첨부파일이 있는 경우");
				int sresult = 0;
				pMap.put("bs_seq",1);
				sresult = bsDao.boardSINS(pMap);
			}
			//데이터 유효성 체크 코드 추가. XML문서 분석하기
			//크루는 PL로 부터 소스를 받으면 제일 먼저 단위테스트를 수행
			//주의사항:테이블 컬럼을 사용자로 부터 입력받는 값과 개발자끼리만 공유하는 값
			logger.info("bs_file===>"+pMap.get("bs_file"));
			logger.info("bs_size===>"+pMap.get("bs_size"));
			logger.info("bm_no===>"+pMap.get("bm_no"));
			logger.info("bm_group===>"+pMap.get("bm_group"));
			logger.info("bm_pos===>"+pMap.get("bm_pos"));
			logger.info("bm_step===>"+pMap.get("bm_step"));
			logger.info("bm_title===>"+pMap.get("bm_title"));
			logger.info("bm_writer===>"+pMap.get("bm_writer"));
			logger.info("bm_content===>"+pMap.get("bm_content"));
			logger.info("bm_email===>"+pMap.get("bm_email"));
			logger.info("bm_pw===>"+pMap.get("bm_pw"));
			pMap.put("bm_no",bm_no);
			result = bmDao.boardMINS(pMap);
			//첨부파일이 있을때만 bsDao.boardSINS(pMap);
		} catch (Exception e) {
			//라인 번호도 출력됨. - log4j
			e.printStackTrace();//stack메모리에 쌓여있는 로그 히스토리를 출력함.
		}
		return result;
	}

	public int boardUPD(Map<String, Object> pMap) {
		logger.info("boardUPD 호출 성공");
		int result = 0;
		result = bmDao.boardUPD(pMap);
		return result;
	}

	public int boardDEL(Map<String, Object> pMap) {
		logger.info("boardDEL 호출 성공");
		int result = 0;
		result = bmDao.boardDEL(pMap);
		return result;
	}
}
