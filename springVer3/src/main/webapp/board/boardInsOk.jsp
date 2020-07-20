<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int result = 0;
	if(request.getParameter("result") != null) {
		result = Integer.parseInt(request.getParameter("result"));
	}
%>
<script>
	alert("등록 되었습니다. : <%= result %>");
	location.href="./boardList";
</script>