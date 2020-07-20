<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map" %>
<%@ page import="com.util.PageBar"%>
<%
	int tot = 0;
	if(session.getAttribute("s_tot") != null) {
		tot = Integer.parseInt(session.getAttribute("s_tot").toString());
		out.print("tot : "+tot);
	}
	//자바영역 - 서버에서 처리된 결과가 html코드에 합쳐져서 클라이언트 측으로 다운로드 되는 것임.
	// 이미 모든 값이 결정된 상태임 - 변경 불가함. - 정적
	List<Map<String, Object>> boardList = (List<Map<String, Object>>)request.getAttribute("boardList");
	//전체 레코드
	int size = 0;
	if(boardList != null) {
		size = boardList.size();
		out.print(size+"row");
	}
	
	//페이지네이션 추가분
	int numPerPage = 10;
	int nowPage = 0;
	if(request.getParameter("nowPage")!=null) {
		nowPage = Integer.parseInt(request.getParameter("nowPage"));
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here[WEBAPP]</title>
<!-- 공통코드 영역 (화면공통 코드, 인증처리) -->
<%@ include file="../common/jEasyUICommon.jsp" %>
<script type="text/javascript">
	function boardList() {
		location.href="/board/boardList";
		/*
		$.ajax({
			url: "/board/boardList.mvc3?cud=sel"
		});
		*/
	}
	function writeForm() {
		$('#dlg_write').dialog({
		    title: '글쓰기 화면',
		    width: 600,
		    height: 500,
		    closed: false,
		    cache: false,
		    href: 'writeForm.jsp',
		    modal: true
		});
	}
	function board_ins() {
		alert("board_ins 호출성공");
		/**/ 
		$('#f_write').attr('method','post');
		$('#f_write').attr('action','./boardINS');
		$('#f_write').submit();
	}
</script>
</head>
<body>
    <table id="dg" title="My Users" class="easyui-datagrid" style="width:700px;height:500px"
           toolbar="#toolbar" pagination="true"
           rownumbers="true" fitColumns="true" singleSelect="true">
        <thead>
            <tr>
                <th field="bm_no" width="50">번호</th>
                <th field="bm_title" width="250">글 제목</th>
                <th field="bm_writer" width="100">작성자</th>
                <th field="bs_file" width="120">첨부파일</th> 
                <th field="bm_hit" width="90">조회수</th>
            </tr>
        </thead>
<%
	if(boardList != null && boardList.size()>0 ) {
%>
		<tbody>
<%
		for(int i=0; i<boardList.size(); i++) {
		//for(int i=nowPage*numPerPage; i<(nowPage*numPerPage)+numPerPage; i++) {
			Map<String, Object> rMap = boardList.get(i);
			//if(tot == i) break;
%>
			<tr>
				<td><%= rMap.get("BM_NO") %></td>
				<td>
					<!-- 너 댓글이니? ㄴ 이미지  -->
					<%
						String imgPath = "";
						if(Integer.parseInt(rMap.get("BM_POS").toString()) > 0) {
							for(int j=1; j<Integer.parseInt(rMap.get("BM_POS").toString()); j++) {
								out.print("&nbsp;&nbsp;");
							}
						%>
							<img src="L.gif" border="0">
						<%
						}
					%>
					<a href="./boardDetail.mvc3?cud=DET&bm_no=<%=rMap.get("BM_NO")%>">
								<%= rMap.get("BM_TITLE") %></a>
									
				</td>
				<td><%= rMap.get("BM_WRITER") %></td>
				<td><a href="download.jsp?bs_file="><%= rMap.get("BS_FILE") %></td>
				<td><%= rMap.get("BM_HIT") %></td>
			</tr>
<%
		}// end of for
%>
		</tbody>
<%
	}// end of if
%>
    </table>
    <div id="toolbar">
        <a class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="boardList()">조회</a>
        <a class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="writeForm()">글쓰기</a>
    </div>
    <table border="1" style="width:700px;height:50px">
    	<tr>
    		<!-- <td align="center">1 2 3 4 5 6 7 8 9 10</td> -->
    		<td align="center">
<%				
				String pagePath = "boardList.mvc3?cud=SEL";
				PageBar	pb = new PageBar(numPerPage, tot, nowPage, pagePath);
				String pagination = pb.getPageBar();
				out.print(pagination);
%>			</td>
    	</tr>
    </table>
    <!-- ===================== 글쓰기 다이얼로그 시작 ======================== -->
    <div id="dlg_write" class="easyui-dialog" data-options="closed:true, modal:true"></div>
    <!-- ===================== 글쓰기 다이얼로그   끝  ======================== -->
</body>
</html>