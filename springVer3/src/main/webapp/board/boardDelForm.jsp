<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String pbm_no = request.getParameter("bm_no");
	String pbm_pw = request.getParameter("bm_pw");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="margin-bottom:20px">
		<input id="u_pw" name="u_pw" class="easyui-textbox" label="비밀번호" style="width:250px; ">
	</div>
</body>
</html>