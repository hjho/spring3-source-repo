package web.board;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
@RequestMapping(value="/json/*",produces="text/plain;charset=UTF-8")
public class RestBoardController {
	
	Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardLogic boardLogic = null;
	
	@GetMapping("jsonBoardList")
	public String jsonBoardList(@RequestParam Map<String, Object> pMap) { //화면 쪽에 설계하는 
		logger.info("호출 : jsonBoardList");
		List<Map<String, Object>> boardList = null;
		boardList = boardLogic.proc_boardList(pMap);
		Gson g = new Gson();
		String jsonList = g.toJson(boardList);
		return jsonList;
	}
}
