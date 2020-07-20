<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map" %>  
<%@ page import="java.util.HashMap" %>     
<%
	List<Map<String, Object>> boardList = 
		(List<Map<String, Object>>)request.getAttribute("updateView");
	int size = 0;
	Map<String, Object> rMap = new HashMap<String,Object>();
	if(boardList!=null){
		size = boardList.size();
		rMap = boardList.get(0);
	}
	//out.print("size:"+size);//1이면 성공 0이면 실패
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글수정</title>
</head>
<body>

</body>
</html>