<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="com.google.gson.Gson"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	List<Map<String, Object>> boardList = (List<Map<String, Object>>)request.getAttribute("boardList");
	Gson g = new Gson();
	String jsonList = g.toJson(boardList);
	out.print(jsonList);
%>