<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here[Web-INF 아래에서]</title>
<script type="text/javascript">
	
</script>
</head>
<body>
<!--  새글 일 때[list.jsp >> 글쓰기 버튼을 눌렀을 때] 
       - 새글과 댓글은 어떻게 구분하나요.(글번호 유무)
  -->
  <!-- bm_no, bm_title, bm_writer, bm_email, bm_content, bm_hit, bm_date, bm_group, bm_pos, bm_step, bm_pw -->
	<form id="f_write" method="post" enctype="multipart/form-data">
	<table align="center" id="p" class="easyui-panel" title="글상세보기" data-options="footer:'#d_ins'"
        style="width:670px;height:380px;padding:10px;background:#fafafa;">
       	 	<input type="hidden" name="cud" value="INS">
	    	<tr>
	    	<td>제목</td>
	    	<td><input id="bm_title" name="bm_title" data-options="width:'450px'" class="easyui-textbox"></td>
	    	</tr>
	    	<tr>
	    	<td>작성자</td>
	    	<td><input id="bm_writer" name="bm_writer" class="easyui-textbox"></td>
	    	</tr>
	    	<tr>
	    	<td>이메일</td>
	    	<td><input id="bm_email" name="bm_email" class="easyui-textbox"></td>
	    	</tr>
	    	<tr>
	    	<td>내용</td>
	    	<td><input id="bm_content" name="bm_content" data-options="multiline:'true', width:'570px', height:'90px'" class="easyui-textbox"></td>
	    	</tr>
	    	<tr>
	    	<td>비밀번호</td>
	    	<td><input id="bm_pw" name="bm_pw" class="easyui-passwordbox"></td>
	    	</tr>	    
	    	<td>첨부파일</td>
	    	<td><input id="bs_file"  name="bs_file" class="easyui-filebox"></td>
	    	</tr>   		
	</table>
	</form>
	<!-- 사원등록 테이블에 footer부분 -->
	<div id="d_ins" style="margin-bottom:10px">
		<a id="" class="easyui-linkbutton" href="javascript:board_ins()" 
				data-options="iconCls:'icon-save'">등록</a><!-- emp_ins -->
		<a id="" class="easyui-linkbutton" href="javascript:$('#dlg_write').dialog('close')" 
				data-options="iconCls:'icon-cancel'" >닫기</a>
	</div>
<!-- 댓글 일 때[read.jsp >> ]  -->
<form id="f_reple">
	<input type="hidden" name="cud" value="INS">
	<input type="hidden" name="bm_no" value="<%= 5 %>">
	<input type="hidden" name="bm_group" value="<%= 2 %>">
	<input type="hidden" name="bm_pos" value="<%= 0 %>">
	<input type="hidden" name="bm_step" value="<%= 0 %>">
</form>
</body>
</html>