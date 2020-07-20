package web.board;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired(required = false)
	private BoardLogic boardLogic = null;
	
	@PostMapping("boardINS")
	public String boardINS(Model model, @RequestParam Map<String, Object> pMap) { //화면만 호출하기 
		logger.info("boardINS호출 성공");
		logger.info("Parameter map : "+pMap);
		int result = boardLogic.boardINS(pMap);
		return "redirect:boardInsOk.jsp?result="+result;
		//return "board/boardList";   //WEB-INF
	}
	
	@GetMapping("writeAction")
	public String writeAction() { // insert : 실제 글쓰기를 처리 
		logger.info("writeAction호출 성공");
		
		return "board/writeForm";   
	}
	
	@GetMapping("boardList")
	public String boardList(Model model, @RequestParam Map<String, Object> pMap) { //화면 쪽에 설계하는 
		logger.info("호출 : boardList");
		List<Map<String, Object>> bList = null;
		bList = boardLogic.boardList(pMap);
		model.addAttribute("boardList", bList);
		return "board/list";
	}
	
	@GetMapping("boardList2")
	public String boardList2(Model model) {
		logger.info("호출 : boardList2");
		return "redirect:/board/list.jsp";
	}
	/**********************************************************************************************
	 * 글 목록 조회 구현하기 
	 * @param uploadFile
	 * @param Model model - scope:request
	 * @return
	 */
	@PostMapping("uploadAction")
	public String uploadAction(MultipartFile[] uploadFile, @RequestParam Map<String,Object> pMap) {
		String uploadFolder = 
			"C:\\workspace_spring4\\springVer3-1\\src\\main\\webapp\\pds";
		for(MultipartFile mpFile:uploadFile) {
			logger.info("======================================");
			logger.info("파일명:"+mpFile.getOriginalFilename());
			logger.info("파일 크기:"+mpFile.getSize());
			File saveFile = new File(uploadFolder,mpFile.getOriginalFilename());
			try {
				mpFile.transferTo(saveFile);
			} catch (Exception e) {
				logger.info(e.getMessage());
			}
		}
		return "redirect:listTest.jsp";
	}
	
	@GetMapping("downLoad")
	public String downLoad(HttpServletRequest request, HttpServletResponse response) throws Exception {
		   String b_file = request.getParameter("bs_file");
		   String fname = b_file;
		   PrintWriter out = response.getWriter();
		   //out.print("b_file: 8->euc"+b_file);      
		   //out.print("<br>");      
		   String filePath = "D://workspace_spring4//springVer3-2//src//main//webapp//pds//"; // 절대경로.   
		   //파일이름만을 객체화 시켜줌, 파일 크기
		   //a.txt파일자체를[이름] 객체화 시켜줌. 안에 내용은 따로 처리해야 됨.
		   File file = new File(filePath,b_file.trim());
		   
//		    String mimeType = getServletContext().getMimeType(file.toString());
		    String mimeType = null;
		   
		    //브라우저는 모르는 마임 타입에 대해서는 무조건 다운로드 처리함.
		    if(mimeType == null){
		      response.setContentType("application/octet-stream");
		   }
		   String downName = null;
		   if(request.getHeader("user-agent").indexOf("MSIE")==-1){
		      downName = new String(b_file.getBytes("UTF-8"),"8859_1");
		   }else{
		      downName = new String(b_file.getBytes("EUC-KR"),"8859_1");
		   }
		   response.setHeader("Content-Disposition", "attachment;filename="+downName);
		   FileInputStream fis = new FileInputStream(file);
		   ServletOutputStream sos = null;
		   PrintWriter pwout = response.getWriter();
		   try{
			   //out.clear();
			   //out=pageContext.pushBody();
			   sos = response.getOutputStream();
		      byte b[] = new byte[1024*10];
		      int data = 0;
		      while((data=(fis.read(b,0,b.length)))!=-1){
//		         sos2.write(b,0,data);
		         sos.write(b,0,data);
		      }
		      fis.close();
		      sos.flush();   
		   }catch(Exception e){
		      out.print(e.toString());
		   }finally{
		      if(sos != null) sos.close();
		      if(fis != null) fis.close();
		   }		
		return null;
	}	
	
	@GetMapping("test")
	public String test() {
		logger.info("test호출 성공");
		return "redirect:test.jsp";
	}
}
