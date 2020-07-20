<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글목록 샘플</title>
<%@ include file="../common/jEasyUICommon.jsp" %>
</head>
<body>
    <table id="dg" title="My Users" 
    			   class="easyui-datagrid" 
    			   style="width:700px;height:250px">
        <thead>
            <tr>
                <th data-options="field:'bs_file1',width:200">첨부파일1</th>
                <th data-options="field:'bs_file2',width:200">첨부파일2</th>
                <th data-options="field:'bs_file3',width:200">첨부파일3</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td><a href='downLoad.jsp?bs_file=<%="jsp시험문제샘플.hwp"%>'>jsp시험문제샘플.hwp</a></td>
                <td><a href='downLoad.jsp?bs_file=<%="MVC패턴.xlsx"%>'>MVC패턴.xlsx</a></td>
                <td><a href='downLoad.jsp?bs_file=<%="계층형게시판.xlsx"%>'>계층형게시판.xlsx</a></td>
            </tr>
        </tbody>
    </table>

</body>
</html>