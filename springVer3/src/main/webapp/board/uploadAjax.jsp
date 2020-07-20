<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>첨부파일 - 멀티옵션 추가</title>
<script type="text/javascript" src="/js/jquery-3.4.1.js"></script>
</head>
<body>
<div>
	<input type="file" name="uploadFile" multiple>
</div>
<button id="btnUpload">Upload</button>
<script type="text/javascript">
	$(document).ready(function(){
		$("#btnUpload").on("click", function(e){
			var formData = new FormData();
			var inputFile = $("input[name='uploadFile']");
			var files = inputFile[0].files;
			console.log(files);
			for(var i=0;i<files.length;i++){
				formData.append('uploadFile',files[i]);
			}
			$.ajax({
				url:'uploadAction'
			   ,processData: false	
			   ,contentType: false
			   ,data: formData
			   ,type: 'post'  
			   ,success:function(result){
					alert('uploaded ok!!!');
				}	   
			});
		});
	});
</script>
</body>
</html>