<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Demo</title>
	<script type="text/javascript" src="<c:url value="/" />resources/jquery-1.5.js"></script>
	<script type="text/javascript">
		var j$ = jQuery.noConflict();
		j$(document).ready(function (){
			
			j$('#id_btn_insert').click(function(e) {
				e.preventDefault();						
				fnAjaxCall('<c:url value="/" />test1/insert');
			});	

			j$('#id_btn_update1').click(function(e) {
				e.preventDefault();						
				fnAjaxCall('<c:url value="/" />test1/update/1');
			});	

			j$('#id_btn_update2').click(function(e) {
				e.preventDefault();						
				fnAjaxCall('<c:url value="/" />test1/update/2');
			});	

			j$('#id_btn_updateAll').click(function(e) {
				e.preventDefault();						
				fnAjaxCall('<c:url value="/" />test1/updateAll');
			});	
		});
	
		
		function fnAjaxCall(strUrl) {
			j$.ajax({
				type: 'get',
				cache: false,
				url: strUrl,
				data: '',
				success: function(jsonData) {
					alert(jsonData.result);
				},
				error: function(xhr, info) {
					alert('Error!!!');
				}
			});
		}
	</script>
</head>
<body>

	<h1>테스트 메뉴</h1>
	
	<a href="<c:url value="/" />test1/demo1" target="contents">DB에서 데이터 조회 (Cache 미사용)</a>
	<br><br>
	<a href="#" id="id_btn_insert">데이터 추가 (Cache Reset)</a>
	<br><br>
	<a href="<c:url value="/" />test1/demo2?boardId=1" target="contents">DB에서 데이터 조회 (Cache 사용, Key1)</a>
	<br><br>
	<a href="<c:url value="/" />test1/demo2?boardId=2" target="contents">DB에서 데이터 조회 (Cache 사용, Key2)</a>
	<br><br>
	<a href="#" id="id_btn_update1">Cache Key1 삭제</a>
	<br><br>
	<a href="#" id="id_btn_update2">Cache Key2 삭제</a>
	<br><br>
	<a href="#" id="id_btn_updateAll">Cache Key 모두삭제</a>
	<br><br>

	

</body>
</html>
